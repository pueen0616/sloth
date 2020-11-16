package com.sloth.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sloth.board.vo.HostPicVO;
import com.sloth.board.vo.reviewVO;

public class HostDAO extends DAO{
	private PreparedStatement psmt; //sql 명령문 실행
	private ResultSet rs;	//select 후 결과셋 받기
	private HostPicVO vo;
	
	private final String SELECT_HOST_PIC_JOIN= "SELECT A.*, B.* FROM HOST A	"
								+ " INNER JOIN (select * from (select row_number() over (partition by room_num order by room_num , first_yn) as num,pic.* from pic)where num=1) B ON (A.ROOM_NUM = B.ROOM_NUM) ";
						
	private final String HOST_M = "SELECT A.*, B.* FROM HOST A"
			                     + "  INNER JOIN PIC B ON (A.ROOM_NUM = B.ROOM_NUM) WHERE FIRST_YN = 'Y' AND A.ID = ?";
	
	private final String SELECT_DETAIL = "SELECT * FROM HOST WHERE ROOM_NUM = ?";
	
	private final String SELECT_PIC = "SELECT * FROM PIC WHERE ROOM_NUM = ?";
	
	private final String HOSTMUPDATE = "UPDATE HOST SET ROOM_NAME=? , ROOM_ADDRESS=?, ROOM_MAX=? ,ROOM_PRICE=? "
			+ " ,ROOM_INFO=? ,ROOM_CHECKIN=?, ROOM_CHECKOUT=? WHERE ROOM_NUM=?";
	private final String PICUPDATE = "INSERT INTO PIC VALUES(SEQ_NUM.NEXTVAL, ?,NULL,?)";
	private final String PICDEL = "DELETE FROM PIC WHERE PIC_NUM=?";
	private final String MAINPIC = "UPDATE PIC SET FIRST_YN= NULL WHERE FIRST_YN='Y' AND ROOM_NUM=?";
	private final String CHANGEPIC = "UPDATE PIC SET FIRST_YN= 'Y' WHERE  PIC_NUM=?";
	//숙소삭제
	private final String DELETE_ROOM="DELETE FROM HOST WHERE ROOM_NUM=?";
	//리뷰조회
	private final String REVIEWSELECT = "select * from review where room_num in (\r\n" + 
			"select room_num from host where (room_name, id) in (select room_name, id from host where room_num=? )) ";
	//리뷰추가
	private final String REVIEWACTION = "INSERT INTO REVIEW VALUES(SQL_REVIEW.NEXTVAL,?,?,?,?,SYSDATE,?)";
	//평점
	private final String REVIEWSTAR = "select round(avg(review_star),2) as star from review where room_num in (\r\n" + 
			"select room_num from host where (room_name, id) in (select room_name, id from host where room_num=? ))";
	
	//평점
	public double reviewStar(reviewVO vo1) {
		double a =0;
		 try {
	           psmt = conn.prepareStatement(REVIEWSTAR);
	           psmt.setInt(1, vo1.getRoom_num());
	           rs = psmt.executeQuery();
	           while(rs.next()) {
	        	   a = rs.getDouble("star");
	           }
	        }catch(SQLException e) {
	           e.printStackTrace();
	        }finally {
	           close();// db 연결을 끊어준다.
	        }
	        return a;
	     }

	
	//리뷰추가
	public int reviewAction(reviewVO vo6){  //추가
           int n=0;
           try {   
              psmt = conn.prepareStatement(REVIEWACTION);         
              psmt.setString(1, vo6.getReview_area());
              psmt.setString(2, vo6.getRoom_name());
              psmt.setDouble(3, vo6.getReview_star());
              psmt.setString(4, vo6.getId());
              psmt.setInt(5, vo6.getRoom_num());
              
              n = psmt.executeUpdate();
           
           }catch(SQLException e) {
              e.printStackTrace();
           }finally {
              close();// db 연결을 끊어준다.
           }
           return n;
        }
	
	//리뷰조회
	public List<reviewVO> reviewselect(reviewVO re){   //전체검색
        List<reviewVO> list = new ArrayList<reviewVO>();
        try {
           psmt = conn.prepareStatement(REVIEWSELECT);
           psmt.setInt(1, re.getRoom_num());
           rs = psmt.executeQuery();
           while(rs.next()) {
              re = new reviewVO();
              re.setReview_num(rs.getInt("review_num"));
              re.setReview_area(rs.getString("review_area"));
              re.setRoom_name(rs.getString("room_name"));
              re.setReview_star(rs.getInt("review_star"));
              re.setId(rs.getString("id"));
              re.setToday(rs.getDate("today"));
              re.setRoom_num(rs.getInt("room_num"));
              
              list.add(re);            
           }
        }catch(SQLException e) {
           e.printStackTrace();
        }finally {
           close();// db 연결을 끊어준다.
        }
        return list;
     }
	
	//숙소삭제
    public int room_Delete(int roomNum) {
       int n = 0;
       try {
          psmt=conn.prepareStatement(DELETE_ROOM);
          psmt.setInt(1,roomNum);
          n = psmt.executeUpdate();
          System.out.println(roomNum);   
       } catch (SQLException e) {
          e.printStackTrace();
       }finally {
          close();
       }
       return n;
       
    }
	
	//대표사진1
	public int MAINPIC(HostPicVO vo) {
		int n = 0;
		try {
			psmt=conn.prepareStatement(MAINPIC);
			psmt.setInt(1, vo.getRoom_num());
			n=psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	//대표사진 
	public int CHANGEPIC(HostPicVO vo) {
		int n = 0;
		try {
			psmt=conn.prepareStatement(CHANGEPIC);
			psmt.setInt(1, vo.getPic_num());
			n=psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
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
		}finally {
			close();
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
		}finally {
			close();
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
				close();
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
				vo.setPic_num(rs.getInt("pic_num"));
				vo.setFirst_yn(rs.getString("first_yn"));
				vo.setRoom_num(rs.getInt("room_num"));

				list.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally{
			close();
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
			close();
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
