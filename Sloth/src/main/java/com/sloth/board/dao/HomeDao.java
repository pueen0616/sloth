package com.sloth.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sloth.board.vo.HostPicVO;

public class HomeDao extends DAO {
	   private PreparedStatement psmt;   //sql 명령문 실행
	   private ResultSet rs;    //select 후 결과셋 받기
	   private HostPicVO vo;
	   
	 
	   //private final String WANTSELECT = "SELECT * FROM HOST WHERE ROOM_MAX=?";
	   private final String WANTSELECT = "SELECT * FROM HOST H JOIN PIC P ON (H.ROOM_NUM = P.ROOM_NUM)WHERE H.ROOM_ADDRESS = ? "
								   		+ "AND H.ROOM_CHECKIN <= ? "
								   		+ "AND H.ROOM_CHECKOUT >= ? "
								   		+ "AND H.ROOM_MAX>=? "
								   		+ "AND H.ROOM_NUM=P.ROOM_NUM"
								   		+ "AND FIRST_YN ='Y'";
	   
	   private final String HIGHPRICE = "SELECT * FROM HOST H JOIN PIC P ON (H.ROOM_NUM = P.ROOM_NUM)WHERE H.ROOM_ADDRESS = ? "
								   		+ "AND H.ROOM_CHECKIN <= ? "
								   		+ "AND H.ROOM_CHECKOUT >= ? "
								   		+ "AND H.ROOM_MAX>=? "
								   		+ "AND H.ROOM_NUM=P.ROOM_NUM "
								   		+ "AND FIRST_YN ='Y'"
	   									+ "ORDER BY  DESC";
	   public List<HostPicVO> wantselect(HostPicVO vo){  // 원하는거 검색창
	      List<HostPicVO> list = new ArrayList<HostPicVO>();
	      try {   
	         psmt = conn.prepareStatement(WANTSELECT);         
	         psmt.setString(1, vo.getRoom_address());
	         psmt.setDate(2, vo.getRoom_checkin());
	         psmt.setDate(3, vo.getRoom_checkout());
	         psmt.setString(4, vo.getRoom_max());
	         rs = psmt.executeQuery();
	         while(rs.next()) {
	            
	            vo = new HostPicVO();
	            vo.setRoom_num(rs.getInt("room_num"));
	            vo.setRoom_name(rs.getString("room_name"));
	            vo.setRoom_address(rs.getString("room_address"));
	            vo.setRoom_max(rs.getString("room_max"));
	            vo.setRoom_price(Integer.parseInt(rs.getString("room_price")));
	            vo.setRoom_checkin(rs.getDate("room_checkin"));
	            vo.setRoom_checkout(rs.getDate("room_checkout"));
	            vo.setRoom_info(rs.getString("room_info"));
	            vo.setId(rs.getString("id"));
	            vo.setLocation(rs.getString("location"));
	            vo.setPic_num(rs.getInt("pic_num"));
	            vo.setPic(rs.getString("pic"));
	            vo.setFirst_yn(rs.getString("first_yn"));
	            list.add(vo);            
	         }

	            
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close();// db 연결을 끊어준다.
	      }
	      return list;
	   }
	   
	   public List<HostPicVO> highPrice(HostPicVO vo){  // 원하는거 검색창
		      List<HostPicVO> list = new ArrayList<HostPicVO>();
		      try {   
		         psmt = conn.prepareStatement(HIGHPRICE);         
		         psmt.setString(1, vo.getRoom_address());
		         psmt.setDate(2, vo.getRoom_checkin());
		         psmt.setDate(3, vo.getRoom_checkout());
		         psmt.setString(4, vo.getRoom_max());
		         rs = psmt.executeQuery();
		         while(rs.next()) {
		            vo = new HostPicVO();
		            vo.setRoom_num(rs.getInt("room_num"));
		            vo.setRoom_name(rs.getString("room_name"));
		            vo.setRoom_address(rs.getString("room_address"));
		            vo.setRoom_max(rs.getString("room_max"));
		            vo.setRoom_price(Integer.parseInt(rs.getString("room_price")));
		            vo.setRoom_checkin(rs.getDate("room_checkin"));
		            vo.setRoom_checkout(rs.getDate("room_checkout"));
		            vo.setRoom_info(rs.getString("room_info"));
		            vo.setId(rs.getString("id"));
		            vo.setLocation(rs.getString("location"));
		            vo.setPic_num(rs.getInt("pic_num"));
		            vo.setPic(rs.getString("pic"));
		            vo.setFirst_yn(rs.getString("first_yn"));
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