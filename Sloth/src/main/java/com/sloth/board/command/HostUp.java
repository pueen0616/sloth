package com.sloth.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;
import com.sloth.board.vo.HostVO;

public class HostUp implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 숙소등록
		AccountDao dao = new AccountDao();
		HostVO vo = new HostVO();
		
		vo.setRoomName(request.getParameter("roomName"));
		vo.setRoomAddress(request.getParameter("roomAddress"));
		vo.setRoomMax(request.getParameter("roomMax"));
		vo.setRoomPrice(request.getParameter("roomPrice"));
		vo.setRoomInfo(request.getParameter("roomInfo"));
		vo.setId(request.getParameter("id"));
		vo.setRoomCheckIn(Date.valueOf(request.getParameter("FirstCheckIn")));
		vo.setRoomCheckOut(Date.valueOf(request.getParameter("LastCheckIn")));
		
		dao = new AccountDao();
		int n = dao.host_insert(vo); //insert 해주고
		
		dao = new AccountDao(); //다시 생성하고
		AccountVO avo = new AccountVO();
		avo.setId(request.getParameter("id")); //id값 받아와서
		dao.admin_grant(avo); //update 해주기
		String page;
		
		if(n !=0) {
			page = "login/insertSuccess.jsp";
		}else {
			page = "login/insertFail.jsp";
		}
		
		return page;
	}

}
