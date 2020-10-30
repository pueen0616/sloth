package com.sloth.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;


public class Register implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원가입 폼 호출
		
		AccountDao dao = new AccountDao();
		AccountVO vo = new AccountVO();
		
		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		vo.setBirth(request.getParameter("birth"));
		vo.setEmail(request.getParameter("email"));
		vo.setTel(request.getParameter("tel"));
		vo.setUser_type(request.getParameter("user_type"));
		
		int n = dao.insert(vo);
		String page;
		if(n !=0) {
			page = "login/member/insertSuccess.jsp";
		}else {
			page = "login/member/insertFail.jsp";
		}
		return page;
	}
}