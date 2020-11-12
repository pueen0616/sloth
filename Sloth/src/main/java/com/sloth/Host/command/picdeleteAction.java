package com.sloth.Host.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostPicVO;


public class picdeleteAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//파라미터를 DTO에 담기
		
			String[] pic_num = request.getParameterValues("pic_num");
			
				HostPicVO vo= new HostPicVO();
				for(int i=0; i<pic_num.length; i++) {					
					vo.setPic_num(Integer.parseInt(pic_num[i]));
					HostDAO dao = new HostDAO();
					dao.picdel(vo);
				}
				try {
					response.getWriter().print("OK");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
	}

}
