package com.sloth.Host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostPicVO;

public class RoomDelete implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HostPicVO vo = new HostPicVO();
		//vo.setRoom_num(Integer.parseInt(request.getParameter("room_num")));
		HostDAO dao = new HostDAO();
		int roomNum = Integer.parseInt(request.getParameter("room_num"));
		
		//dao.room_Delete(vo);
		System.out.println(roomNum);
		try {
			int n= dao.room_Delete(roomNum);
			response.getWriter().print(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
