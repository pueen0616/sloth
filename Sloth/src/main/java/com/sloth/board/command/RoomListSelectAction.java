package com.sloth.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostVO;

public class RoomListSelectAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//숙소 리스트에서 클릭시 숙소 상세보기 페이지로 넘어가는 액션
		HostDAO dao = new HostDAO();
		HostVO vo = new HostVO();
		List<HostVO> list = new ArrayList<HostVO>();//넘어온 select_all -> list 리턴값을 받아오기위해서 HostVo list형객체만듬
		list = dao.SELECT_All(vo);
		request.setAttribute("roomlist",list);
		
		return "/room/roomlist.jsp";
	}

}
