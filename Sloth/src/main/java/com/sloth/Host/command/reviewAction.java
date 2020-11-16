package com.sloth.Host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostPicVO;
import com.sloth.board.vo.reviewVO;

public class reviewAction implements Action {

   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      // TODO 회원리스트 보기 구현
      HostDAO dao3 = new HostDAO();
      reviewVO vo4 = new reviewVO();
      
      HttpSession session = request.getSession();
      String a = (String) session.getAttribute("review_room_name");
      
      HttpSession session1 = request.getSession();
      String b = (String)session1.getAttribute("id");
      vo4.setRoom_name(a);
      vo4.setId(b);
      vo4.setReview_area(request.getParameter("board_area"));
      vo4.setReview_star(Integer.parseInt(request.getParameter("review_star")));
      
      HostPicVO rrvo = (HostPicVO)session.getAttribute("detail");
      vo4.setRoom_num(rrvo.getRoom_num());
      
      dao3.reviewAction(vo4);
      
      return "hostDetail.do";
//      return "/host/hostDetail.jsp";
   }
}