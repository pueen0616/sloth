package com.sloth.board.command;

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
		vo.setId(request.getParameter("id"));			
		
		HostDAO dao = new HostDAO();
		HostPicVO dvo = dao.Host_M(vo);	
		
		request.setAttribute("hostM", dvo);
		
		return "/host/hostM.jsp";
	}

}
