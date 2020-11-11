package com.sloth.board.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sloth.board.vo.AccountVO;
import com.sloth.board.vo.HostPicVO;
import com.sloth.board.vo.reserVO;


public class AccountDao extends DAO {
	private PreparedStatement psmt; // sql 명령문 실행
	private ResultSet rs; // select 후 결과셋 받기
	private AccountVO vo;
	Statement stmt = null;

	private final String SELECT_ALL = "SELECT * FROM ACCOUNT ORDER BY ID";
	private final String SELECT = "SELECT * FROM ACCOUNT WHERE ID = ? AND PASSWORD=?";
	//계정등록
	private final String INSERT = "INSERT INTO ACCOUNT(ID,NAME,PASSWORD,BIRTH,EMAIL,TEL) VALUES(?,?,?,?,?,?)";
	//숙소등록
	   private final String HOST_INSERT = "INSERT INTO HOST(ROOM_NUM, ROOM_NAME, ROOM_ADDRESS, ROOM_MAX, ROOM_PRICE, ROOM_INFO, ID, ROOM_CHECKIN, ROOM_CHECKOUT)"
	                            + "VALUES(?,?,?,?,?,?,?,?,?)";
	//계정권한부여

	private final String UPDATE_ADMIN = "UPDATE ACCOUNT SET USER_TYPE = 'ADMIN' WHERE ID = ?";
	//대표사진
	private final String PIC_INSERT_YN = "INSERT INTO PIC VALUES((select max (pic_num)+1 from pic), ?, 'Y', ?)";
	private final String PIC_INSERT = "INSERT INTO PIC VALUES((select max (pic_num)+1 from pic), ?, NULL, ?)";

	String sql_seq = "select seq_num.nextval from dual";
	//private final String RESER_M = "select reser_num, (select room_name from host where room_num = ?) as room_name, reser_checkin, reser_checkout, reser_price, reser_max,id,room_num, reser_today from reser where id =?"; 
	private final String RESER_M = "SELECT A.RESER_NUM,B.ROOM_NAME,A.RESER_CHECKIN,A.RESER_CHECKOUT,A.RESER_PRICE,A.RESER_MAX,A.ID,A.ROOM_NUM,a.room_num as 호스트room_num,A.RESER_TODAY FROM RESER A,HOST B WHERE b.room_num=a.room_num and a.id=?";
	private final String delete_reser="DELETE FROM RESER WHERE RESER_NUM=?";


	String SQL_RESER_SEQ = "SELECT SEQ_RESER_NUM.NEXTVAL FROM DUAL";
	String SQL_SEQ = "SELECT SEQ_NUM.NEXTVAL FROM DUAL";
	//숙소예약등록
	private final String RESER_INSERT = "INSERT INTO (RESER_NUM, RESER_CHECKIN, RESER_CHECKOUT, RESER_PRICE, RESER_MAX, ID, ROOM_NUM, RESER_TODAY)  VALUES(seq_reser_num.nextval,?,?,?,?,?,?,SYSDATE)";
		
	//숙소예약
	public int reser_insert(reserVO vo) {
		int n = 0;
		try {
			psmt=conn.prepareStatement(RESER_INSERT);
			psmt.setInt(1, vo.getReserNum());
			psmt.setDate(2, vo.getReserCheckIn());
			psmt.setDate(3, vo.getReserCheckOut());
			psmt.setInt(4, vo.getReserPrice());
			psmt.setString(5, vo.getReserMax());
			psmt.setString(6, vo.getId());
			psmt.setInt(7, vo.getRoomNum());
			psmt.setString(8, vo.getReserToday());
			
			n=psmt.executeUpdate();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	
	public reserVO reserDelete(int reserNum) {//예약 삭제
		try {
			psmt=conn.prepareStatement(delete_reser);
			psmt.setInt(1, reserNum);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}	
		return null;
	}
	public List<reserVO> select_reser(reserVO vo) {
		List<reserVO> list = new ArrayList<reserVO>();
		try {
			psmt = conn.prepareStatement(RESER_M);
			psmt.setString(1,vo.getId());
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new reserVO();
				vo.setReserNum(Integer.parseInt(rs.getString("RESER_NUM")));
				vo.setReserRoomName(rs.getString("ROOM_NAME"));
				vo.setReserCheckIn(rs.getDate("RESER_CHECKIN"));
				vo.setReserCheckOut(rs.getDate("RESER_CHECKOUT"));
				vo.setReserPrice(rs.getInt("RESER_PRICE"));
				vo.setReserMax(rs.getString("RESER_MAX"));
				vo.setId(rs.getString("ID"));
				vo.setRoomNum(rs.getInt("ROOM_NUM"));
				vo.setReserToday(rs.getString("RESER_TODAY"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 대표사진
	public int PIC_INSERT_YN(HostPicVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(PIC_INSERT_YN);
			psmt.setString(1, vo.getPic());
			psmt.setInt(2, vo.getRoom_num());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	// 사진
	public int PIC_INSERT(HostPicVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(PIC_INSERT);
			psmt.setString(1, vo.getPic());
			psmt.setInt(2, vo.getRoom_num());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public List<AccountVO> SELECT_All() {
		List<AccountVO> list = new ArrayList<AccountVO>();
		try {
			psmt = conn.prepareStatement(SELECT_ALL);
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new AccountVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public AccountVO select(AccountVO vo) {
		try {
			psmt = conn.prepareStatement(SELECT);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();

			if (rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setBirth(rs.getString("birth"));
				vo.setEmail(rs.getString("email"));
				vo.setTel(rs.getString("tel"));
				vo.setUserType(rs.getString("user_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	// 계정 insert
	public int insert(AccountVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(INSERT);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPassword());
			psmt.setString(4, vo.getBirth());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getTel());

			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	// 숙소 insert
	   public int host_insert(HostPicVO vo) {
	      int n = 0;
	      try {
	         //시퀀스 조회
	         stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(SQL_SEQ);
	         if(rs.next())
	            vo.setRoom_num((rs.getInt(1)));
	            
	         psmt=conn.prepareStatement(HOST_INSERT);
	         psmt.setInt(1, vo.getRoom_num());
	         psmt.setString(2, vo.getRoom_name());
	         psmt.setString(3, vo.getRoom_address());
	         psmt.setString(4, vo.getRoom_max());
	         psmt.setInt(5, vo.getRoom_price());
	         psmt.setString(6, vo.getRoom_info());
	         psmt.setString(7, vo.getId());
	         psmt.setDate(8, vo.getRoom_checkin());
	         psmt.setDate(9, vo.getRoom_checkout());
	         n=psmt.executeUpdate();
	      } catch(SQLException e) {
	         e.printStackTrace();
	      }
	      return n;
	   }

	   // 계정 권한 부여
	   public int admin_grant(AccountVO vo) {
	      int n = 0;
	      try {
	         psmt = conn.prepareStatement(UPDATE_ADMIN);
	         psmt.setString(1, vo.getId()); //id값으로
	         n = psmt.executeUpdate();
	      } catch(SQLException e){
	         e.printStackTrace();
	      }
	      return n;
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