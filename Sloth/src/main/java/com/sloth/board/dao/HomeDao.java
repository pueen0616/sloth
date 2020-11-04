package com.sloth.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sloth.board.vo.HostVO;
import com.sloth.board.vo.RoomPicVO;

public class HomeDao extends DAO {
	   private PreparedStatement psmt;   //sql 명령문 실행
	   private ResultSet rs;    //select 후 결과셋 받기
	   private HostVO vo;
	   
	 
	   //private final String WANTSELECT = "SELECT * FROM HOST WHERE ROOM_MAX=?";
	   private final String WANTSELECT = "SELECT * FROM HOST H JOIN PIC P ON (H.ROOM_NUM = P.ROOM_NUM)WHERE H.ROOM_ADDRESS = ? "
								   		+ "AND H.ROOM_CHECKIN <= ? "
								   		+ "AND H.ROOM_CHECKOUT >= ? "
								   		+ "AND H.ROOM_MAX>=? "
								   		+ "AND H.ROOM_NUM=P.ROOM_NUM";
	   
	   public List<RoomPicVO> wantselect(RoomPicVO vo){  // 원하는거 검색창
	      List<RoomPicVO> list = new ArrayList<RoomPicVO>();
	      try {   
	         psmt = conn.prepareStatement(WANTSELECT);         
	         psmt.setString(1, vo.getLroom_address());
	         psmt.setDate(2, vo.getLroom_checkin());
	         psmt.setDate(3, vo.getLroom_checkout());
	         psmt.setString(4, vo.getLroom_max());
	         rs = psmt.executeQuery();
	         while(rs.next()) {
	            
	            vo = new RoomPicVO();
	            vo.setLroom_num(rs.getInt("room_num"));
	            vo.setLroom_name(rs.getString("room_name"));
	            vo.setLroom_address(rs.getString("room_address"));
	            vo.setLroom_max(rs.getString("room_max"));
	            vo.setLprice(rs.getString("room_price"));
	            vo.setLroom_checkin(rs.getDate("room_checkin"));
	            vo.setLroom_checkout(rs.getDate("room_checkout"));
	            vo.setLroom_info(rs.getString("room_info"));
	            vo.setLid(rs.getString("id"));
	            vo.setLlocation(rs.getString("location"));
	            vo.setLpic_num(rs.getInt("pic_num"));
	            vo.setLpic(rs.getString("pic"));
	            vo.setLfirst_yn(rs.getString("first_yn"));
	            list.add(vo);            
	         }

	            
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close();// db 연결을 끊어준다.
	      }
	      return list;
	   }
	   
	   private void close() {
	      try {
	         if(rs != null) rs.close();
	         if(psmt != null) psmt.close();
	         if(conn != null) conn.close();
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }
	   }
	}