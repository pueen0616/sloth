package com.sloth.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.vo.RoomPicVO;

public class HostDetail implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		RoomPicVO vo = new RoomPicVO();
		
		
		
		return "host/hostDetail-123.jsp";
	}

}
