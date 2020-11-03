package com.sloth.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sloth.board.vo.AccountVO;
import com.sloth.board.vo.HostVO;

public class HostDAO extends DAO{
	private PreparedStatement psmt; //sql 명령문 실행
	private ResultSet rs;	//select 후 결과셋 받기
	private HostVO vo;
	
	//private final String SELECT_ALL = "SELECT A.ROOM_NAME,B.PIC_NUM,B.PIC FROM HOST A INNER JOIN PIC B ON A.ROOM_NUM = B.ROOM_NUM ";
	//private final String SELECT_ALL= "SELECT ROOM_NAME,ROOM_PRICE FROM HOST ORDER BY ROOM_NUM DESC";
	private final String SELECT_ALL="SELECT A.ROOM_NAME, A.ROOM_PRICE, B.PIC_NUM, B.PIC FROM HOST A INNER JOIN PIC B ON (A.ROOM_NUM = B.ROOM_NUM)";
	
	public List<HostVO> SELECT_All(HostVO vo) {
		List<HostVO> list = new ArrayList<HostVO>();
		try {
			psmt = conn.prepareStatement(SELECT_ALL);
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				vo = new HostVO();
				vo.setRoomName(rs.getString("room_name"));
				vo.setRoomPrice(rs.getString("room_price"));
				vo.setPicNum(rs.getInt("pic_num"));
				vo.setPic(rs.getString("pic"));
				
				list.add(vo);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally{
			
		}
		
		return list;
	}
	
}
