package com.sloth.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostPicVO;

public class HostmUpdateAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String room_name = request.getParameter("room_name");
		String  room_address= request.getParameter("room_address");
		String room_max = request.getParameter("room_max");
		String room_price = request.getParameter("room_price");
		String room_info = request.getParameter("room_info");
		String room_checkIn = request.getParameter("room_checkIn");
		String room_checkOut = request.getParameter("room_checkOut");
		Integer room_num=Integer.parseInt(request.getParameter("room_num"));
		
			HostPicVO vo = new HostPicVO();
			vo.setRoom_name(room_name);
			vo.setRoom_address(room_address);
			vo.setRoom_max(room_max);
			vo.setRoom_price(Integer.parseInt(room_price));
			vo.setRoom_info(room_info);
			vo.setRoom_checkin(Date.valueOf(room_checkIn));
			vo.setRoom_checkout(Date.valueOf(room_checkOut));
			vo.setRoom_num(room_num);
			HostDAO dao = new HostDAO();
			dao.hostmupdate(vo);		
			
		
			
		return "mainPage/main.jsp";
	}

}
