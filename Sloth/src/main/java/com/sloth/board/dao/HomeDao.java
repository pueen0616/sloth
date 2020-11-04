package com.sloth.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sloth.board.vo.HostVO;

public class HomeDao extends DAO {
	   private PreparedStatement psmt;   //sql 명령문 실행
	   private ResultSet rs;    //select 후 결과셋 받기
	   private HostVO vo;
	   
	 
	   //private final String WANTSELECT = "SELECT * FROM HOST WHERE ROOM_MAX=?";
	   private final String WANTSELECT = "SELECT * FROM HOST WHERE ROOM_ADDRESS = ? AND ROOM_CHECKIN <= ? AND ROOM_CHECKOUT >=? AND ROOM_MAX>=?";
	   

	   
	   public List<HostVO> wantselect(HostVO vo){  // 원하는거 검색창
	      List<HostVO> list = new ArrayList<HostVO>();
	      try {   
	         psmt = conn.prepareStatement(WANTSELECT);         
	         psmt.setString(1, vo.getRoomAddress());
	         psmt.setDate(2, vo.getRoomCheckIn());
	         psmt.setDate(3, vo.getRoomCheckOut());
	         psmt.setString(4, vo.getRoomMax());
	         rs = psmt.executeQuery();
	         while(rs.next()) {
	            
	            vo = new HostVO();
	            vo.setRoomNum(rs.getInt("room_num"));
	            vo.setRoomName(rs.getString("room_name"));
	            vo.setRoomAddress(rs.getString("room_address"));
	            vo.setRoomMax(rs.getString("room_max"));
	            vo.setRoomPrice(rs.getString("room_price"));
	            vo.setRoomCheckIn(rs.getDate("room_checkin"));
	            vo.setRoomCheckOut(rs.getDate("room_checkout"));
	            vo.setRoomInfo(rs.getString("room_info"));
	            vo.setId(rs.getString("id"));
	            vo.setLocation(rs.getString("location"));
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