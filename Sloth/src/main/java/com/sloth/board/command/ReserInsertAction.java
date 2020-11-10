package com.sloth.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.HostPicVO;
import com.sloth.board.vo.reserVO;

public class ReserInsertAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		reserVO vo = new reserVO();
		AccountDao dao = new AccountDao();	
		
		 HttpSession session = request.getSession(false);
		
		 session.getAttribute("room_checkout");
		 session.getAttribute("room_max");
		return null;
	}
}
