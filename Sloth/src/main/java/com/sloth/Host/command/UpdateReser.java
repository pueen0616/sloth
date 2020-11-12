package com.sloth.Host.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.reserVO;

public class UpdateReser implements Action {

   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      String reser_chkIn=request.getParameter("checkIn");
      String reser_chkOut=request.getParameter("checkout");
      String reser_max=request.getParameter("roomMax");
      int reser_num=Integer.parseInt(request.getParameter("reserNum"));

      reserVO vo=new reserVO();
      try {
	      vo.setReserCheckIn(Date.valueOf(reser_chkIn));
	      vo.setReserCheckOut(Date.valueOf(reser_chkOut));
	      vo.setReserMax(reser_max);
	      vo.setReserNum(reser_num);
	      AccountDao dao=new AccountDao();
	      try {
	    	  dao.reserUpdate(vo);
	      
	      response.getWriter().print("OK");
      } catch (IOException e) {
    	  e.printStackTrace();
      }
      } catch (IllegalArgumentException e) {
    	  PrintWriter out;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	  


      }
      System.out.println(vo);
      return null;
   }

}