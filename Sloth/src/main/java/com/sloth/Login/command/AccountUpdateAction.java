package com.sloth.Login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;
public class AccountUpdateAction implements Action {
   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      AccountDao dao = new AccountDao();
      HttpSession session = request.getSession();
      AccountVO user = new AccountVO();
      String id = (String)session.getAttribute("id");
      user.setId(id);
      user = dao.userInfo(user);
      request.setAttribute("user",user);
      return "login/accountUpdate.jsp";   
   }
}