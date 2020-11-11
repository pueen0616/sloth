package com.sloth.Host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.reserVO;

public class Reser implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//reser 폼
		
		
		return "/reserv/reserv.jsp";
	}

}