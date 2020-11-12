package com.sloth.Login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;

public class LoginAction implements Action {

<<<<<<< HEAD
   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      // TODO 로그인 인증과정
      AccountDao dao = new AccountDao();
      AccountVO vo = new AccountVO();
      HttpSession session = request.getSession(false);
      vo.setId(request.getParameter("userid"));
      vo.setPassword(request.getParameter("password"));
      String msg;
         String page = null;
         AccountVO vo1 = dao.select(vo);
=======
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 인증과정
		AccountDao dao = new AccountDao();
		AccountVO vo = new AccountVO();
		HttpSession session = request.getSession(false);
		vo.setId(request.getParameter("userid"));
		vo.setPassword(request.getParameter("password"));
		
		String msg;
	      String page = null;
	      AccountVO vo1 = dao.select(vo);
>>>>>>> branch 'main' of https://github.com/pueen0616/sloth.git

<<<<<<< HEAD
      if(vo1 != null) {
            session.setAttribute("id", vo1.getId());
            session.setAttribute("name", vo1.getName());
            session.setAttribute("user_type",vo1.getUserType());
            request.setAttribute("vo", vo1);
      
            page = "redirect:main.do";
         }else {
            
            msg="아이디 / 비밀번호를 확인하세요";
            request.setAttribute("msg", msg);
         }
         System.out.println(vo1);
=======
		if(vo1 != null) {
	         session.setAttribute("id", vo1.getId());
	         session.setAttribute("name", vo1.getName());
	         session.setAttribute("user_type", vo1.getUserType());
	         request.setAttribute("vo", vo1);
	   
	         page = "redirect:main.do";
	      }else {
	         
	         msg="아이디 / 비밀번호를 확인하세요";
	         request.setAttribute("msg", msg);
	      }
	      System.out.println(vo1);
>>>>>>> branch 'main' of https://github.com/pueen0616/sloth.git

         return page;
      }
   }
