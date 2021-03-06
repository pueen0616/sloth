package com.sloth.MyPage.command;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.reserVO;

public class ReserMAction implements Action {

   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      AccountDao dao = new AccountDao();
      reserVO vo = new reserVO();
      vo.setId(request.getParameter("id"));
      List<reserVO> list = new ArrayList<reserVO>();

      System.out.println(vo);
      list = dao.select_reser(vo);
      // System.out.println(id);

      request.setAttribute("reserInfo2", list);
      return "/reserv/reservationM.jsp";
   }

}