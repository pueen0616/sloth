package com.sloth.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sloth.board.vo.HostPicVO;

public class HostDAO extends DAO{
	private PreparedStatement psmt; //sql 명령문 실행
	private ResultSet rs;	//select 후 결과셋 받기
	private HostPicVO vo;
	
	//private final String SELECT_ALL = "SELECT A.ROOM_NAME,B.PIC_NUM,B.PIC FROM HOST A INNER JOIN PIC B ON A.ROOM_NUM = B.ROOM_NUM ";
	//private final String SELECT_ALL= "SELECT ROOM_NAME,ROOM_PRICE FROM HOST ORDER BY ROOM_NUM DESC";
	//
	private final String SELECT_HOST_PIC_JOIN="SELECT A.ROOM_NUM, A.ROOM_NAME, A.ROOM_PRICE, B.PIC_NUM, B.PIC FROM HOST A"
			+ "	 INNER JOIN PIC B ON (A.ROOM_NUM = B.ROOM_NUM) WHERE FIRST_YN = 'Y'";
	private final String HOST_M = "SELECT * FROM HOST WHERE ID = ?";
	private final String SELECT_DETAIL = "SELECT * FROM HOST WHERE ROOM_NUM = ?";
	private final String SELECT_PIC = "SELECT * FROM PIC WHERE ROOM_NUM = ?";
	
	//숙소 관리
	public HostPicVO Host_M(HostPicVO vo){
		HostPicVO hvo = null;
		try {
			psmt = conn.prepareStatement(HOST_M);
			psmt.setString(1, vo.getId());
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				hvo = new HostPicVO();
				hvo.setId(rs.getString("id"));
				hvo.setRoom_name(rs.getString("room_name"));
				hvo.setLocation(rs.getString("location"));
				hvo.setRoom_price(Integer.parseInt(rs.getString("room_price")));
				hvo.setRoom_num(rs.getInt("room_num"));
				hvo.setRoom_address(rs.getString("room_address"));
				hvo.setRoom_max(rs.getString("room_max"));
				hvo.setRoom_info(rs.getString("room_info"));
				hvo.setRoom_checkin(rs.getDate("room_checkIn"));
				hvo.setRoom_checkout(rs.getDate("room_checkOut"));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally{
			
		}
		return hvo;
	}	
	
	//상세 페이지
	public HostPicVO SELECT_DETAIL(HostPicVO vo){
		HostPicVO hvo = null;
		try {
			psmt = conn.prepareStatement(SELECT_DETAIL);
			psmt.setInt(1, vo.getRoom_num());
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				hvo = new HostPicVO();
				hvo.setRoom_name(rs.getString("room_name"));
				hvo.setLocation(rs.getString("location"));
				hvo.setRoom_price(Integer.parseInt(rs.getString("room_price")));
				hvo.setRoom_num(rs.getInt("room_num"));
				hvo.setRoom_address(rs.getString("room_address"));
				hvo.setRoom_max(rs.getString("room_max"));
				hvo.setRoom_info(rs.getString("room_info"));
				hvo.setRoom_checkin(rs.getDate("room_checkIn"));
				hvo.setRoom_checkout(rs.getDate("room_checkOut"));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally{
			
		}
		return hvo;
	}	
	
	public List<HostPicVO> SELECT_PIC(HostPicVO vo) {
		List<HostPicVO> list = new ArrayList<HostPicVO>();
		try {
			psmt = conn.prepareStatement(SELECT_PIC);
			psmt.setInt(1, vo.getRoom_num());
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				vo = new HostPicVO();
				vo.setPic(rs.getString("pic"));
				
				list.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally{
			
		}
		
		return list;
	}
	
	// 리스트 화면
	public List<HostPicVO> SELECT_HOST_PIC_JOIN(HostPicVO vo) {
		List<HostPicVO> list = new ArrayList<HostPicVO>();
		try {
			psmt = conn.prepareStatement(SELECT_HOST_PIC_JOIN);
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				vo = new HostPicVO();
				vo.setRoom_name(rs.getString("room_name"));
				vo.setRoom_price(Integer.parseInt(rs.getString("ROOM_PRICE")));
				vo.setPic(rs.getString("pic"));
				vo.setRoom_num(rs.getInt("room_num"));
				
				list.add(vo);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally{
			
		}
		
		return list;
	}
	
}
