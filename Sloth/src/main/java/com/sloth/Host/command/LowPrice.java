package com.sloth.Host.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HomeDao;
import com.sloth.board.vo.HostPicVO;

public class LowPrice implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HostPicVO vo1 = new HostPicVO();
		List<HostPicVO> list1 = new ArrayList<HostPicVO>();
		HomeDao dao = new HomeDao();
		
		HttpSession session = request.getSession();
	
		vo1 = (HostPicVO)session.getAttribute("selectVO");
		 int b = (int)session.getAttribute("a");
	      System.out.println(b);
	      if(b==0) {
	    	  list1 = dao.r_lowPrice(vo1);
	      } else {
	    	  list1 = dao.lowPrice(vo1);
	      }
				
		request.setAttribute("hosts", list1);
		
		return "/room/roomlist.jsp";
	}

}
