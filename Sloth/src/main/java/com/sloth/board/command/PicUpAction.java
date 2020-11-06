package com.sloth.board.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sloth.board.common.Action;
import com.sloth.board.common.FileRenamePolicy;
import com.sloth.board.common.FileUtil;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;
import com.sloth.board.vo.HostPicVO;
import com.sloth.board.vo.HostVO;

public class PicUpAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		return "/host/picUpForm.jsp";
	}

}
