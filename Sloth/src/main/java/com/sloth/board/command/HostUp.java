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
		// 숙소등록
		AccountDao dao = new AccountDao();
		hostVO vo = new hostVO();
		
		vo.setRoomNum(Integer.parseInt(request.getParameter("roomNum")));
		vo.setRoomName(request.getParameter("roomName"));
		vo.setRoomAddress(request.getParameter("roomAddress"));
		vo.setRoomMax(request.getParameter("roomMax"));
		vo.setRoomPrice(request.getParameter("roomPrice"));
		vo.setRoomInfo(request.getParameter("roomInfo"));
		vo.setId(request.getParameter("id"));
		vo.setFirstCheckIn(Date.valueOf(request.getParameter("FirstCheckIn")));
		vo.setLastCheckIn(Date.valueOf(request.getParameter("LastCheckIn")));
		
		dao = new AccountDao();
		int n = dao.host_insert(vo);
		System.out.println(n);
		String page;
		
		if(n !=0) {
			page = "login/insertSuccess.jsp";
		}else {
			page = "login/insertFail.jsp";
		}
		
		return page;
	}

}
