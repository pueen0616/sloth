package com.sloth.Login.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;

public class LoginAction implements Action {

   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      // TODO 로그인 인증과정
      AccountDao dao = new AccountDao();
      AccountVO vo = new AccountVO();
      HttpSession session = request.getSession(false);
      vo.setId(request.getParameter("userid"));
      vo.setPassword(request.getParameter("password"));

      AccountVO vo1 = dao.select(vo);

      if (vo1.getPassword() == null) {
         response.setContentType("text/html; charset=UTF-8");
         PrintWriter writer;
         try {
            writer = response.getWriter();
            writer.println("<script>alert(' 아이디 비밀번호를 확인하세요'); location.href='" + request.getContextPath()
                  + "/main.do';</script>");
            writer.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

         }

      }

      else if (vo1.getPassword().equals(request.getParameter("password")) && vo1.getPassword() != null) {
         session.setAttribute("id", vo1.getId());
         session.setAttribute("name", vo1.getName());
         session.setAttribute("user_type", vo1.getUserType());
         request.setAttribute("vo", vo1);

         System.out.println("디비값:" + vo1.getPassword() + "입력된 아이디의 비밀번호:" + request.getParameter("password"));
         response.setContentType("text/html; charset=UTF-8");
         PrintWriter writer;
         try {
            writer = response.getWriter();
            writer.println("<script>alert(' 환영합니다.'); location.href='" + request.getContextPath()
                  + "/main.do';</script>");
            writer.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

         }

      } else {
         response.setContentType("text/html; charset=UTF-8");
         PrintWriter writer;
         try {
            writer = response.getWriter();
            writer.println("<script>alert('로그인 실패! 아이디 비밀번호를 확인하세요'); location.href='" + request.getContextPath()
                  + "/main.do';</script>");
            
            writer.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

         }

      }

      return null;
   }
}