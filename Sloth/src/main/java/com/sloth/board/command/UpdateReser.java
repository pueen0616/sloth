package com.sloth.board.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.reserVO;

public class UpdateReser implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String reser_chkIn=request.getParameter("checkIn");
		String reser_chkOut=request.getParameter("checkout");
		String reser_max=request.getParameter("roomMax");
		int reser_num=Integer.parseInt(request.getParameter("reserNum"));
//		"checkIn" : $("#room_checkin").val(),
//		"checkout" : $("#room_checkout").val(),
//		"roomMax" : $("#room_max").val()
		reserVO vo=new reserVO();
		try {
		vo.setReserCheckIn(Date.valueOf(reser_chkIn));
		vo.setReserCheckOut(Date.valueOf(reser_chkOut));
		vo.setReserMax(reser_max);
		vo.setReserNum(reser_num);
		AccountDao dao=new AccountDao();
		dao.reserUpdate(vo);
		
		response.getWriter().print("OK");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(vo);
		return null;
	}

}
