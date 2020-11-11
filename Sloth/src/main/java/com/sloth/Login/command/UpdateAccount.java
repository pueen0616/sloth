package com.sloth.Login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;

public class UpdateAccount implements Action {

   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      AccountDao dao = new AccountDao();
      AccountVO vo = new AccountVO();
      int n = 0;
      
      HttpSession session = request.getSession();
      
      vo.setId(request.getParameter("id"));
      vo.setPassword(request.getParameter("password"));
      vo.setName(request.getParameter("name"));
      vo.setTel(request.getParameter("tel"));
      vo.setEmail(request.getParameter("email"));
      
      n = dao.updateAccount(vo); // 변경된 정보 값을 n에 담음
      
      String page;
      
      if(n != 0) {         
         session.setAttribute("user",n);//수정이 성공하면 main으로 이동
         page = "redirect:main.do";
      }else {
         page = "login/updateResult.jsp"; //실패시 현재 페이지에서 경고창 뜨고 리셋
      }
      return page;
   }
}