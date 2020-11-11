package com.sloth.Login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;

public class Findidresult implements Action {

   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      
      AccountDao dao = new AccountDao();
      AccountVO vo = new AccountVO();

      System.out.println(request.getParameter("name"));
      System.out.println(request.getParameter("email"));
      
      vo.setName(request.getParameter("name"));
      vo.setEmail(request.getParameter("email"));
      
      
      AccountVO id = dao.select_id(vo);
      
      request.setAttribute("id", id);
      
      return "/login/Findidresult.jsp";
   }

}