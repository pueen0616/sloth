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
      
      vo.setName(request.getParameter("name"));
      vo.setId(request.getParameter("id"));
      
      vo = dao.select_pw(vo);
      
      request.setAttribute("pw", vo);
      
      return "login/findPassword.jsp";
   }

}