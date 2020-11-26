package com.sloth.Login.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;

public class UpdateAccount implements Action {

   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      String page;
      AccountDao dao = new AccountDao();
      AccountVO vo = new AccountVO();
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter writer1;

      
//      HttpSession session = request.getSession();
      String a = request.getParameter("password"); //1234
      System.out.println(request.getParameter("password"));
      String b = request.getParameter("pwreview");//1234
      System.out.println(request.getParameter("pwreview"));
      
      vo.setId(request.getParameter("id"));
      vo.setPassword(request.getParameter("password"));
      vo.setName(request.getParameter("name"));
      vo.setTel(request.getParameter("tel"));
      vo.setEmail(request.getParameter("email"));

      if(a.equals(b)) {
         dao.updateAccount(vo); 
         try {
            writer1 = response.getWriter();
            writer1.println("<script>alert(' 수정 되었습니다.'); location.href='"+ request.getContextPath() + 
                  "/main.do';</script>");
            writer1.close();
            
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

         }

       
      } else {
         
         try {
            writer1 = response.getWriter();
            writer1.println("<script>alert(' 비밀번호를 확인하세요.'); history.back();</script>");
            writer1.close();
            
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

         }

      }  
      
      return null;
   }
}