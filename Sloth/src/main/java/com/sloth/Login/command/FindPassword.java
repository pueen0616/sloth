package com.sloth.Login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;

public class FindPassword implements Action {

   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      AccountDao dao = new AccountDao();
      AccountVO vo = new AccountVO();

      
      vo.setName(request.getParameter("uNa"));
      vo.setId(request.getParameter("userID"));
    
      AccountVO pw = dao.select_pw(vo);
     
         request.setAttribute("pw", pw.getPassword());         
      
      
         System.out.println(pw.getPassword());
      return "login/findPassword.jsp";
   }

}