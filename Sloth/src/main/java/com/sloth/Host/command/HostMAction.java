package com.sloth.Host.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.AccountVO;
import com.sloth.board.vo.HostPicVO;

public class HostMAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HostPicVO vo = new HostPicVO();
		vo.setId((String)request.getSession().getAttribute("id"));  //
//		vo.setRoom_num(Integer.parseInt(request.getParameter("room_num")));
		List<HostPicVO> list =null;
		
		HostDAO dao = new HostDAO();
		
		list = dao.Host_M(vo);
		request.setAttribute("hostM", list);
		
//		HostPicVO dvo1 = new HostPicVO();
//		List<HostPicVO> list1 = null;
//		HostDAO dao1 = new HostDAO();
//		List<HostPicVO> piclist =  dao1.SELECT_PIC(dvo1);
//		request.setAttribute("piclist", piclist );
		
//-------------------------------------------이미지
//		List<HostPicVO> piclist = dao.SELECT_PIC(vo);
//		request.setAttribute("piclist", piclist);
//
//		List<HostPicVO> list1 = new ArrayList<HostPicVO>();
//
//		HttpSession session = request.getSession();
//		vo = (HostPicVO) session.getAttribute("selectVO");
//
//		List<HostPicVO> list2 = new ArrayList<HostPicVO>();
//
//		list1 = dao.SELECT_HOST_PIC_JOIN(vo);
//
//		request.setAttribute("hostss", list1);
		return "/host/hostM.jsp";
	}

}
