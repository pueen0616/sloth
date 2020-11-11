package com.sloth.board.command;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.reserVO;

public class ReserMAction implements Action {
	String aa = "SELECT A.RESER_NUM,B.ROOM_NAME,A.RESER_CHECKIN,"
			+ "A.RESER_CHECKOUT,A.RESER_PRICE,A.RESER_MAX,A.ID,"
			+ "A.ROOM_NUM,a.room_num as 호스트room_num,A.RESER_TODAY"
			+ " FROM RESER A,HOST B"
			+ " WHERE b.room_num=a.room_num and a.id=?";

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		AccountDao dao = new AccountDao();
		reserVO vo = new reserVO();
		vo.setId(request.getParameter("id"));
		List<reserVO> list = new ArrayList<reserVO>();

		System.out.println(vo);
		list = dao.select_reser(vo);
		// System.out.println(id);

		request.setAttribute("reserInfo2", list);
		return "/reserv/reservationM.jsp";
	}

}
