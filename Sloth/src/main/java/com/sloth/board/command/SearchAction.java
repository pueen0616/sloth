package com.sloth.board.command;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HomeDao;
import com.sloth.board.vo.HostVO;

public class SearchAction implements Action {

	   @Override
	   public String exec(HttpServletRequest request, HttpServletResponse response) {
	      // TODO 회원리스트 보기 구현
	      
	      
	      
	      //response.setCharacterEncoding(arg0);
	      HomeDao dao = new HomeDao();      
	      HostVO vo = new HostVO();
	      List<HostVO> list = new ArrayList<HostVO>();
	      
	      vo.setRoomAddress(request.getParameter("room_address"));
	      vo.setRoomCheckIn(Date.valueOf(request.getParameter("room_checkin")));
	      vo.setRoomCheckOut(Date.valueOf(request.getParameter("room_checkout")));
	      //vo.setRoom_max(Integer.parseInt(request.getParameter("room_max")));
	      vo.setRoomMax(request.getParameter("room_max"));
	      
	      System.out.println("주소"+(request.getParameter("room_address")));
	      System.out.println("체크인"+Date.valueOf(request.getParameter("room_checkin")));
	      System.out.println("체크아웃"+Date.valueOf(request.getParameter("room_checkout")));
	      System.out.println("인원"+(request.getParameter("room_max")));
	      
	      list = dao.wantselect(vo);
	      
	      request.setAttribute("hosts", list);
	      
	      return "mainPage/search.jsp";
	   }

	
}
