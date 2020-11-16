package com.sloth.Login.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;


public class Register implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원가입
		
		AccountDao dao = new AccountDao();
		AccountVO vo = new AccountVO();
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setBirth(Date.valueOf(request.getParameter("birth")));
		vo.setTel(request.getParameter("tel"));
		vo.setEmail(request.getParameter("email"));
		
		int n = dao.insert(vo);
		
		String page;
		
		if(n !=0) {
			page = "login/insertSuccess.jsp";
		}else {
			page = "login/insertFail.jsp";
		}
		return page;
	}
}