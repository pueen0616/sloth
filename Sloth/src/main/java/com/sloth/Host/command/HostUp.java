package com.sloth.Host.command;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.sloth.board.common.Action;
import com.sloth.board.common.FileRenamePolicy;
import com.sloth.board.common.FileUtil;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;
import com.sloth.board.vo.HostPicVO;

public class HostUp implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 숙소등록
		AccountDao dao = new AccountDao();
		HostPicVO vo = new HostPicVO();
		
		vo.setRoom_name(request.getParameter("room_name"));
		vo.setRoom_address(request.getParameter("room_address"));
		vo.setRoom_max(request.getParameter("room_max"));
		vo.setRoom_price(Integer.parseInt(request.getParameter("room_price")));
		vo.setRoom_info(request.getParameter("room_info"));
		vo.setId(request.getParameter("id"));
		vo.setRoom_checkin(Date.valueOf(request.getParameter("room_checkIn")));
		vo.setRoom_checkout(Date.valueOf(request.getParameter("room_checkOut")));
		
		int n = dao.host_insert(vo); //insert 해주고
		
		dao = new AccountDao(); //다시 생성하고
		AccountVO avo = new AccountVO();
		avo.setId(request.getParameter("id")); //id값 받아와서
		dao.admin_grant(avo); //update 해주기
		
		
		//-------------------------------------------------------------------------------//
//		사진등록코드
	
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
					
					HostPicVO pic = new HostPicVO();
					pic.setRoom_num(vo.getRoom_num());
					pic.setPic(renameFile.getName());
					if(part.getName().equals("img1") )
						dao.PIC_INSERT_YN(pic);
					else {
						dao.PIC_INSERT(pic);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	    
		
		String page;
		
		if(n !=0) {
						
			page = "login/insertSuccess.jsp";
		}else {
			page = "login/insertFail.jsp";
		}
		
		return page;
	}

}
