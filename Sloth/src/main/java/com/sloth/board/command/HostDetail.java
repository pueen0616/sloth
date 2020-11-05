package com.sloth.board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostPicVO;

public class HostDetail implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		HostPicVO vo = new HostPicVO();
		
		vo.setRoom_num(Integer.parseInt(request.getParameter("room_num")));	

		HostDAO dao = new HostDAO();
		
		HostPicVO dvo = dao.SELECT_DETAIL(vo);		
		request.setAttribute("detail", dvo);
//=-----------------------------------------------------------//		
		
		//이미지 조회
		//HostDAO pdao = new HostDAO();
		List<HostPicVO> piclist=dao.SELECT_PIC(vo);
		request.setAttribute("piclist", piclist);
		
		
		return "/host/hostDetail.jsp";
	}
}
