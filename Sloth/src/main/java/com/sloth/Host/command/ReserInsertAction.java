package com.sloth.Host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.AccountVO;
import com.sloth.board.vo.HostPicVO;
import com.sloth.board.vo.reserVO;

public class ReserInsertAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		reserVO vo = new reserVO();
		AccountDao dao = new AccountDao();

		HttpSession session = request.getSession(false);

		// 검색화면 (주소)
		HostPicVO svo = (HostPicVO)session.getAttribute("selectVO"); //getAttribute(담은 객체명)
		vo.setReserAddress(svo.getRoom_address());
		
		// 숙소 (이름, 가격)
		HostPicVO dvo = (HostPicVO)session.getAttribute("detail");
		vo.setRoomNum(dvo.getRoom_num());
		vo.setReserPrice(Integer.parseInt(request.getParameter("room_price1")));

		// 최종예약일 (날짜, 인원 수)
		HostPicVO rvo = (HostPicVO)session.getAttribute("realReser");
		vo.setReserCheckIn(rvo.getRoom_checkin());
		vo.setReserCheckOut(rvo.getRoom_checkout());
		vo.setReserMax(rvo.getRoom_max());
		
		// 아이디
		String id = (String)session.getAttribute("id");
		
		vo.setId(id);
		
		dao.reser_insert(vo);
		return "/mainPage/main.jsp";
	}
}
