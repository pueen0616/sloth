package com.sloth.Host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostPicVO;

public class RoomDelete implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HostDAO dao = new HostDAO();
		HostPicVO vo = new HostPicVO();
		int roomNum= Integer.parseInt(request.getParameter("roomNum"));
//		vo = dao.room_Delete(roomNum);
		
		try {
			response.getWriter().print("result");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
