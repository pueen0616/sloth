package com.sloth.Host.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import com.sloth.board.common.Action;
import com.sloth.board.common.FileRenamePolicy;
import com.sloth.board.common.FileUtil;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostPicVO;

import top.jfunc.json.impl.JSONObject;

public class picuploadAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HostPicVO vo = new HostPicVO();
		HostDAO dao = new HostDAO();
		HostPicVO pic = new HostPicVO();
		
		 String room_num =  request.getParameter("room_num");
		String appPath = request.getServletContext().getRealPath("/img");
		System.out.println(appPath);
		try {
			for (Part part : request.getParts()) {
				String fileName = FileUtil.extractFileName(part);
				if (!fileName.equals("")) {
					// 파일명 중복체크
					String uploadFile = appPath + File.separator + fileName;
					File renameFile = FileRenamePolicy.rename(new File(uploadFile));
					part.write(renameFile.getAbsolutePath());
					
					pic.setRoom_num(Integer.parseInt(room_num));
					pic.setPic(renameFile.getName());
						dao.picupdate(pic);
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	    try {
			response.getWriter().print(pic.getPic());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
