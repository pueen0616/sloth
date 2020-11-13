package com.sloth.Host.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.HostPicVO;
import com.sloth.board.vo.reserVO;

public class Reser implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//reser 폼
		HostPicVO vo2 = new HostPicVO();
		System.out.println(Date.valueOf(request.getParameter("realCheckIn")));
		vo2.setRoom_checkin(Date.valueOf(request.getParameter("realCheckIn")));
	    vo2.setRoom_checkout(Date.valueOf(request.getParameter("realCheckOut")));
	    vo2.setRoom_max(request.getParameter("realRoomMax"));
	    
	    HttpSession session2 = request.getSession();
	    session2.setAttribute("realReser", vo2);
		
		return "/reserv/reserv.jsp";
	}
}