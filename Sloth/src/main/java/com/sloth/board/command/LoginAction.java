package com.sloth.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;

public class LoginAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 인증과정
		AccountDao dao = new AccountDao();
		AccountVO vo = new AccountVO();
		HttpSession session = request.getSession(false);
		vo.setId(request.getParameter("userid"));
		vo.setPassword(request.getParameter("password"));
		
		vo = dao.select(vo);
		
		session.setAttribute("id", vo.getId());
		session.setAttribute("name", vo.getName());
		session.setAttribute("user_type", vo.getUserType());
		request.setAttribute("vo", vo);
		
		return "login/loginResult.jsp";
	}

}
