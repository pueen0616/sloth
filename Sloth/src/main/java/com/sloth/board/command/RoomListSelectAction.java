package com.sloth.board.command;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostPicVO;

public class RoomListSelectAction implements Action {

	 @Override
	   public String exec(HttpServletRequest request, HttpServletResponse response) {
	      
	      //response.setCharacterEncoding(arg0);
	      HostDAO dao = new HostDAO();      
	      HostPicVO vo = new HostPicVO();
	      List<HostPicVO> list = new ArrayList<HostPicVO>();
	      
	      vo.setRoom_address(request.getParameter("room_address"));
	      vo.setRoom_checkin(Date.valueOf(request.getParameter("room_checkin")));
	      vo.setRoom_checkout(Date.valueOf(request.getParameter("room_checkout")));
	      vo.setRoom_max(request.getParameter("room_max"));
	      
	      list = dao.SELECT_HOST_PIC_JOIN(vo);
	       
	      HttpSession session = request.getSession();
	      session.setAttribute("selectVO", vo);
	         
	      request.setAttribute("hosts", list);
	      
	      return "/room/roomlist.jsp";
	   }


}
