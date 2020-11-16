package com.sloth.Host.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostPicVO;
import com.sloth.board.vo.reviewVO;

public class HostDetail implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		HostPicVO vo = new HostPicVO();
		vo.setRoom_num(Integer.parseInt(request.getParameter("room_num")));	
		HostDAO dao = new HostDAO();
		HostPicVO dvo = dao.SELECT_DETAIL(vo);		
		
		HttpSession session1 = request.getSession();
		session1.setAttribute("detail", dvo);
//=-----------------------------------------------------------//		
		//이미지 조회
		List<HostPicVO> piclist = new ArrayList<HostPicVO>();
		HostDAO dao3 = new HostDAO();
		piclist = dao3.SELECT_PIC(vo);
		request.setAttribute("piclist", piclist);
//=-----------------------------------------------------------//			
		List<HostPicVO> list1 = new ArrayList<HostPicVO>();
		
		HttpSession session = request.getSession();
		vo = (HostPicVO)session.getAttribute("selectVO");
//=-----------------------------------------------------------//
		HostDAO dao1 = new HostDAO();
		list1 = dao1.SELECT_HOST_PIC_JOIN(vo);
		
		request.setAttribute("hostss", list1);
	
		  reviewVO re = new reviewVO();
	      List<reviewVO> list2 = new ArrayList<reviewVO>();
	      re.setRoom_num(Integer.parseInt(request.getParameter("room_num")));
	      
	      String a = request.getParameter("room_num");
	      
	      HttpSession session2 = request.getSession();
	      session2.setAttribute("review_room_name", a);
	     
	      String id = (String)session.getAttribute("id");
	      
	      HttpSession session3 = request.getSession();
	      session3.setAttribute("id", id);
	      
	      int d = Integer.parseInt(request.getParameter("room_num"));
	      HttpSession session4 = request.getSession();
	      session4.setAttribute("room_num", d);
	      
	      HostDAO dao2 = new HostDAO();
	      list2 = dao2.reviewselect(re);
	      
	     request.setAttribute("reviews", list2);      	
//=-----------------------------------------------------------//
	     //평점 보기	
	     reviewVO vo5 = new reviewVO();
	     HostDAO dao4 = new HostDAO();
	     vo5.setRoom_num(Integer.parseInt(request.getParameter("room_num")));
	     System.out.println(Integer.parseInt(request.getParameter("room_num")));
	     
	     double star = 0.0;
	     star = dao4.reviewStar(vo5);
	     System.out.println("star"+star);
	     
	     HttpSession session5 = request.getSession();
	     session5.setAttribute("star", star);
	     
		return "/host/hostDetail.jsp";
	}
}
