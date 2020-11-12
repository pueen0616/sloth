package com.sloth.board.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostPicVO;

public class mainpicAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HostPicVO vo = new HostPicVO();
		
		vo.setRoom_num(Integer.parseInt(request.getParameter("room_num")));
		vo.setPic_num(Integer.parseInt(request.getParameter("pic_num")));
		
		HostDAO dao1= new HostDAO();
		dao1.MAINPIC(vo);
		
		HostDAO dao= new HostDAO();
		dao.CHANGEPIC(vo);
		
		
		
		try {
			response.getWriter().print("OK");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
