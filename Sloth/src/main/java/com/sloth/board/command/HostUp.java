package com.sloth.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.hostVO;

public class HostUp implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		AccountDao dao = new AccountDao();
		hostVO vo = new hostVO();
		
		vo.setRoomNum(Integer.parseInt(request.getParameter("roomNum")));
		vo.setRoomName(request.getParameter("roomName"));
		vo.setRoomAddress(request.getParameter("roomAddress"));
		vo.setRoomMax(Integer.parseInt(request.getParameter("roomMax")));
		vo.setRoomPrice(request.getParameter("roomPrice"));
		vo.setRoomCheckIn(Date.valueOf(request.getParameter("roomCheckIn")));
		vo.setRoomCheckOut(Date.valueOf(request.getParameter("roomCheckOut")));
		vo.setRoomInfo(request.getParameter("roomInfo"));
		
		int n = dao.host_insert(vo);
		String page;
		if(n !=0) {
			page = "login/insertSuccess.jsp";
		}else {
			page = "login/insertFail.jsp";
		}
		return page;
	}

}
