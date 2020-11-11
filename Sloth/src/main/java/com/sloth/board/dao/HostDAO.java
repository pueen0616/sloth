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
	
	private final String SELECT_HOST_PIC_JOIN= "SELECT A.*, B.* FROM HOST A	"
								+ " INNER JOIN PIC B ON (A.ROOM_NUM = B.ROOM_NUM) WHERE FIRST_YN = 'Y'";
	
	private final String HOST_M = "SELECT A.*, B.* FROM HOST A"
			                     + "  INNER JOIN PIC B ON (A.ROOM_NUM = B.ROOM_NUM) WHERE FIRST_YN = 'Y' AND A.ID = ?";
	
	private final String SELECT_DETAIL = "SELECT * FROM HOST WHERE ROOM_NUM = ?";
<<<<<<< HEAD
	
	private final String SELECT_PIC = "SELECT * FROM PIC WHERE ROOM_NUM = ?";
	
	private final String hostmupdate = "UPDATE HOST SET ROOM_NAME=? , ROOM_ADDRESS=?, ROOM_MAX=? ,ROOM_PRICE=? "
=======
	private final String SELECT_PIC = "SELECT * FROM PIC WHERE ROOM_NUM=?";
	private final String HOSTMUPDATE = "UPDATE HOST SET ROOM_NAME=? , ROOM_ADDRESS=?, ROOM_MAX=? ,ROOM_PRICE=? "
>>>>>>> branch 'main' of https://github.com/pueen0616/sloth.git
			+ " ,ROOM_INFO=? ,ROOM_CHECKIN=?, ROOM_CHECKOUT=? WHERE ROOM_NUM=?";
	private final String PICUPDATE = "INSERT INTO PIC VALUES(SEQ_NUM.NEXTVAL, ?,NULL,?)";
	private final String PICDEL = "DELETE FROM PIC WHERE PIC_NUM=?";
	
	//사진 삭제
	public int picdel(HostPicVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(PICDEL);
			psmt.setInt(1, vo.getPic_num());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	//사진 추가
	public int picupdate(HostPicVO vo) {
		int n = 0;
		try {
			psmt=conn.prepareStatement(PICUPDATE);
			psmt.setString(1, vo.getPic());
			psmt.setInt(2, vo.getRoom_num());
			n=psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	//host 수정
	public HostPicVO hostmupdate(HostPicVO vo){
		int n = 0;
		try {
			psmt = conn.prepareStatement(HOSTMUPDATE);
			psmt.setString(1, vo.getRoom_name());
			psmt.setString(2, vo.getRoom_address());
			psmt.setString(3, vo.getRoom_max());
			psmt.setInt(4, vo.getRoom_price());
			psmt.setString(5, vo.getRoom_info());
			psmt.setDate(6, vo.getRoom_checkin());
			psmt.setDate(7, vo.getRoom_checkout());
			psmt.setInt(8, vo.getRoom_num());
			
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
		
	}
	
	//숙소 관리
		public List<HostPicVO> Host_M(HostPicVO vo){
			HostPicVO hvo = null;
			List<HostPicVO> list = new ArrayList<HostPicVO>();
			try {
				psmt = conn.prepareStatement(HOST_M);
				psmt.setString(1, vo.getId());
				rs=psmt.executeQuery();
				
				while(rs.next()) {
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
					hvo.setPic(rs.getString("pic"));
					hvo.setPic_num(Integer.parseInt(rs.getString("pic_num")));
					hvo.setFirst_yn(rs.getString("first_yn"));
					list.add(hvo);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally{
				
			}
			return list;
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
				hvo.setRoom_price(Integer.parseInt(rs.getString("ROOM_PRICE")));
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
				vo.setRoom_price(Integer.parseInt(rs.getString("room_price")));
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
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
