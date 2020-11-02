package com.sloth.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sloth.board.vo.AccountVO;

public class AccountDao extends DAO {
	private PreparedStatement psmt; //sql 명령문 실행
	private ResultSet rs;	//select 후 결과셋 받기
	private AccountVO vo;
	
	private final String SELECT_ALL = "SELECT * FROM ACCOUNT ORDER BY ID";
	private final String SELECT = "SELECT * FROM ACCOUNT WHERE ID = ? AND PASSWORD=?";
	private final String INSERT = "INSERT INTO ACCOUNT(ID,NAME,PASSWORD,BIRTH,EMAIL,TEL) VALUES(?,?,?,?,?,?)";
	private final String UPDATE = "UPDATE ACCOUNT SET NAME =?, PASSWORD=?, BIRTH=?, EMAIL=?, TEL=? WHERE ID=?";
	private final String USERTYPE = "UPDATE ACCOUNT SET USER_TYPE=? WHERE ID = ?";
	public List<AccountVO> SELECT_All() {
		List<AccountVO> list = new ArrayList<AccountVO>();
		try {
			psmt = conn.prepareStatement(SELECT_ALL);
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				vo = new AccountVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally{
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
			
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setBirth(rs.getString("birth"));
				vo.setEmail(rs.getString("email"));
				vo.setTel(rs.getString("tel"));
				vo.setUserType(rs.getString("user_type"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	public int insert(AccountVO vo) {
		int n = 0;
		try {
			psmt=conn.prepareStatement(INSERT);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPassword());
			psmt.setString(4, vo.getBirth());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getTel());
			
			n=psmt.executeUpdate();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	public int update(AccountVO vo) {
		int n=0;
		try {
			psmt = conn.prepareStatement(UPDATE);
			
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getBirth());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getTel());
			psmt.setString(6, vo.getId());
			n=psmt.executeUpdate();
			System.out.println(n+"건 입력됐습니다");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
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
