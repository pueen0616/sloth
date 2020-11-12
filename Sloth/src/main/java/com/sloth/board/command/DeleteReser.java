package com.sloth.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;
import com.sloth.board.vo.reserVO;

public class DeleteReser implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		AccountDao dao = new AccountDao();
		reserVO vo = new reserVO();
		int reserNum = Integer.parseInt(request.getParameter("reserNum"));
		String msg;
		try {
			vo = dao.reserDelete(reserNum);
			response.getWriter().print("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		//"reserM.do";
	}

}
