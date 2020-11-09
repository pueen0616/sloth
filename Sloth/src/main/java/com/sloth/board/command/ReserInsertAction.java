package com.sloth.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.HostPicVO;

public class ReserInsertAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		AccountDao dao = new AccountDao();
		HostPicVO vo = new HostPicVO();
				
		return null;
	}
}
