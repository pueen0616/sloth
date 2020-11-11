package com.sloth.Login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;

public class FindId implements Action {

   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      // TODO 아이디 찾기

      return "login/findId.jsp";
   }

}