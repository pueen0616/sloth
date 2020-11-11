package com.sloth.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;

public class Main implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "mainPage/main.jsp";
	}
}
