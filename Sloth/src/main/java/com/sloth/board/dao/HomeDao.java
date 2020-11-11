package com.sloth.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sloth.board.vo.HostPicVO;
import com.sloth.board.vo.reserVO;

public class HomeDao extends DAO {
	   private PreparedStatement psmt;   //sql 명령문 실행
	   private ResultSet rs;    //select 후 결과셋 받기
	   private HostPicVO vo;
	   
	   //검색한 날짜
	   private final String WANTSELECT = "SELECT * FROM HOST H JOIN PIC P ON (H.ROOM_NUM = P.ROOM_NUM)WHERE H.ROOM_ADDRESS = ? "
								   		+ "AND H.ROOM_CHECKIN <= ? "
								   		+ "AND H.ROOM_CHECKOUT >= ? "
								   		+ "AND H.ROOM_MAX>=? "
								   		+ "AND H.ROOM_NUM=P.ROOM_NUM "
								   		+ "AND FIRST_YN = 'Y'";
	   //오름차순 필터
	   private final String LOWPRICE = "SELECT * FROM HOST H JOIN PIC P ON (H.ROOM_NUM = P.ROOM_NUM)WHERE H.ROOM_ADDRESS = ? "
								   		+ "AND H.ROOM_CHECKIN <= ? "
								   		+ "AND H.ROOM_CHECKOUT >= ? "
								   		+ "AND H.ROOM_MAX>=? "
								   		+ "AND H.ROOM_NUM=P.ROOM_NUM "
								   		+ "AND FIRST_YN = 'Y' "
								   		+ "ORDER BY H.ROOM_PRICE ASC";
	   //내림차순 필터
	   private final String HIGHPRICE = "SELECT * FROM HOST H JOIN PIC P ON (H.ROOM_NUM = P.ROOM_NUM)WHERE H.ROOM_ADDRESS = ? "
								   		+ "AND H.ROOM_CHECKIN <= ? "
								   		+ "AND H.ROOM_CHECKOUT >= ? "
								   		+ "AND H.ROOM_MAX>=? "
								   		+ "AND H.ROOM_NUM=P.ROOM_NUM "
								   		+ "AND FIRST_YN = 'Y' "
								   		+ "ORDER BY H.ROOM_PRICE DESC";
	   
	   private final String TEST = "SELECT * FROM RESER WHERE RESER_CHECKIN<=? AND RESER_CHECKOUT>=? AND RESER_ADDRESS=?";
	   
	   //예약된거 빼고 출력
	   private final String WANTSELECT2 ="SELECT * FROM HOST H JOIN PIC P ON (H.ROOM_NUM = P.ROOM_NUM)"
	   									+ " WHERE NOT(H.ROOM_CHECKIN<=? AND H.ROOM_CHECKOUT>=?)"
	   									+ " AND H.ROOM_ADDRESS=?"
	   									+ "AND FIRST_YN = 'Y'";
	   //예약된거 내림차순
	   private final String R_HIGHPRICE ="SELECT * FROM HOST H JOIN PIC P ON (H.ROOM_NUM = P.ROOM_NUM)"
										+ " WHERE NOT(H.ROOM_CHECKIN<=? AND H.ROOM_CHECKOUT>=?)"
										+ " AND H.ROOM_ADDRESS=?"
										+ "AND FIRST_YN = 'Y'"
										+ "ORDER BY H.ROOM_PRICE DESC";
	   //예약된거 오름차순
	   private final String R_LOWPRICE ="SELECT * FROM HOST H JOIN PIC P ON (H.ROOM_NUM = P.ROOM_NUM)"
										+ " WHERE NOT(H.ROOM_CHECKIN<=? AND H.ROOM_CHECKOUT>=?)"
										+ " AND H.ROOM_ADDRESS=?"
										+ "AND FIRST_YN = 'Y'"
										+ "ORDER BY H.ROOM_PRICE ASC";
	   
	   //wantselect2
	   public List<HostPicVO> wantselect2(HostPicVO vo){  // 원하는거 검색창
           List<HostPicVO> list = new ArrayList<HostPicVO>();
           try {   
              psmt = conn.prepareStatement(WANTSELECT2);         
              psmt.setDate(1, vo.getRoom_checkin());
              psmt.setDate(2, vo.getRoom_checkout());
              psmt.setString(3, vo.getRoom_address());
              
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
	   
	   // 예약된거 제외한거 내림 필터
	   public List<HostPicVO> r_highPrice(HostPicVO vo){  // 원하는거 검색창
           List<HostPicVO> list = new ArrayList<HostPicVO>();
           try {   
              psmt = conn.prepareStatement(R_HIGHPRICE);         
              psmt.setDate(1, vo.getRoom_checkin());
              psmt.setDate(2, vo.getRoom_checkout());
              psmt.setString(3, vo.getRoom_address());
              
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
	   
	   //예약된거 제외한거 오름 필터
	   public List<HostPicVO> r_lowPrice(HostPicVO vo){  // 원하는거 검색창
           List<HostPicVO> list = new ArrayList<HostPicVO>();
           try {   
              psmt = conn.prepareStatement(R_LOWPRICE);         
              psmt.setDate(1, vo.getRoom_checkin());
              psmt.setDate(2, vo.getRoom_checkout());
              psmt.setString(3, vo.getRoom_address());
              
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
	   
	   //test 함수
	   public int TEST(HostPicVO vo) {
		   List<reserVO> list = new ArrayList<reserVO>();
	         int n = 0;
	         try {
	            psmt = conn.prepareStatement(TEST);
	            psmt.setDate(1, vo.getRoom_checkin());
	            psmt.setDate(2, vo.getRoom_checkout());
	            psmt.setString(3, vo.getRoom_address());
	            rs=psmt.executeQuery();
	            while(rs.next()) {
		            reserVO vo1 = new reserVO(); 
		            vo1.setReserNum(rs.getInt("reser_num"));
		            vo1.setReserCheckIn(rs.getDate("reser_checkin"));
		            vo1.setReserCheckOut(rs.getDate("reser_checkout"));
		            vo1.setReserPrice(rs.getInt("reser_price"));
		            vo1.setReserMax(rs.getString("reser_max"));
		            vo1.setId(rs.getString("id"));
		            vo1.setRoomNum(rs.getInt("room_num"));
		            vo1.setReserToday(rs.getString("reser_today"));
		            vo1.setReserAddress(rs.getString("reser_address"));
		            list.add(vo1);            
		        }
	            try {
		            if(list.get(0).getReserNum()!=0) { //예약테이블에 존재
		            	n=0;//예약 테이블에 존재하면 0
		            } 
	            } catch(IndexOutOfBoundsException e) {
	            	n=1;//예약 테이블 존재 안하면 1
	            }
	         } catch(SQLException e) {
	            e.printStackTrace();
	         }
	         return n;
	      }
	   
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
	   
	   //가격 내림차순
	   public List<HostPicVO> lowPrice(HostPicVO vo){  // 원하는거 검색창
		      List<HostPicVO> list = new ArrayList<HostPicVO>();
		      try {   
		         psmt = conn.prepareStatement(LOWPRICE);         
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
	   
	   //가격 오름차순
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