package com.sloth.Host.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostPicVO;

public class picupdateAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HostPicVO vo = new HostPicVO();
		vo.setRoom_num(Integer.parseInt(request.getParameter("room_num")));
		
		HostDAO dao = new HostDAO();
		List<HostPicVO> dvo= dao.SELECT_PIC(vo);
		request.setAttribute("piclist", dvo);
	//-----이미지
		
		return "/host/picupdate.jsp";
	}

}
