package com.sloth.board.command;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HomeDao;
import com.sloth.board.vo.HostVO;
import com.sloth.board.vo.RoomPicVO;

public class SearchAction implements Action {

	   @Override
	   public String exec(HttpServletRequest request, HttpServletResponse response) {
	      // TODO 회원리스트 보기 구현
	      
	      //response.setCharacterEncoding(arg0);
	      HomeDao dao = new HomeDao();      
	      RoomPicVO vo = new RoomPicVO();
	      List<RoomPicVO> list = new ArrayList<RoomPicVO>();
	      
	      vo.setLroom_address(request.getParameter("room_address"));
	      vo.setLroom_checkin(Date.valueOf(request.getParameter("room_checkin")));
	      vo.setLroom_checkout(Date.valueOf(request.getParameter("room_checkout")));
	      vo.setLroom_max(request.getParameter("room_max"));
//	      vo.setLroom_max(request.getParameter("room_max"));
	      
	      list = dao.wantselect(vo);
	      
	      request.setAttribute("hosts", list);
	      
	      return "room/roomlist.jsp";
	   }

	
}
