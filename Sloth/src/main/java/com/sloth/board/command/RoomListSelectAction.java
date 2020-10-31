package com.sloth.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;

public class RoomListSelectAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//숙소 리스트에서 클릭시 숙소 상세보기 페이지로 넘어가는 액션
		
		
		return "../mainPage/main.jsp";
	}

}
