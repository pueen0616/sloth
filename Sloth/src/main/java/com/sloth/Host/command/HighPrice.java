package com.sloth.Host.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HomeDao;
import com.sloth.board.vo.HostPicVO;

public class HighPrice implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HostPicVO vo1 = new HostPicVO();
		List<HostPicVO> list1 = new ArrayList<HostPicVO>();
		HomeDao dao = new HomeDao();
		
		HttpSession session = request.getSession();
	
		vo1 = (HostPicVO)session.getAttribute("selectVO");
		
		 int a = dao.TEST(vo1);
	     
	      if(a==0) {
	    	  list1 = dao.r_highPrice(vo1);
	      } else {
	    	  list1 = dao.highPrice(vo1);
	      }
	    
	      HttpSession session2 = request.getSession();
	      session2.setAttribute("a", a);
	      
		request.setAttribute("hosts", list1);
		
		return "/room/roomlist.jsp";
	}
}
