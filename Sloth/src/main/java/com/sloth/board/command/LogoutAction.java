package com.sloth.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;

public class LogoutAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그아웃실행

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		session.invalidate();
		request.setAttribute("name", name); 		
		
		
		return "redirect:main.do";
	}
 
}
