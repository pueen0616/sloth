package com.sloth.Host.command;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.dao.HomeDao;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostPicVO;

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
		piclist = dao.SELECT_PIC(vo);
		request.setAttribute("piclist", piclist);
//=-----------------------------------------------------------//			
		List<HostPicVO> list1 = new ArrayList<HostPicVO>();
		
		HttpSession session = request.getSession();
		vo = (HostPicVO)session.getAttribute("selectVO");
//=-----------------------------------------------------------//
		
	    
		HostDAO dao1 = new HostDAO();
		list1 = dao1.SELECT_HOST_PIC_JOIN(vo);
		
		request.setAttribute("hostss", list1);
	
		return "/host/hostDetail.jsp";
	}
}
