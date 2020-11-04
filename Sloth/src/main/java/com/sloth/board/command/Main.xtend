package com.sloth.board.command

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.sloth.board.common.Action

class Main implements Action {
	override String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "mainPage/main.jsp"
	}
}
