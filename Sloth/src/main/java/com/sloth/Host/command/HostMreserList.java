package com.sloth.Host.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.reserVO;

public class HostMreserList implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		AccountDao dao = new AccountDao();
		reserVO vo = new reserVO();
		vo.setRoomNum(Integer.parseInt(request.getParameter("room_num")));
		List<reserVO> list = new ArrayList<reserVO>();
		
		list = dao.hostM_reserList(vo);
		
		request.setAttribute("hostMreserList", list);
		return "/host/reservelist.jsp";
	}

}
