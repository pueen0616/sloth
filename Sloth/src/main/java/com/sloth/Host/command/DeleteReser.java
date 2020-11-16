package com.sloth.Host.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.board.common.Action;
import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.reserVO;

public class DeleteReser implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		AccountDao dao = new AccountDao();
		reserVO vo = new reserVO();

		int reserNum = Integer.parseInt(request.getParameter("reserNum"));
		String reserCheckIn2 = request.getParameter("reserCheckIn");
/////////////////////////////////////////////////////////////////////////////
		// 데이트포맷(일수로 구할거니깐 dd까지만 있으면됨)
		SimpleDateFormat todaySdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		// 한국기준날짜
		Calendar calender = Calendar.getInstance();
		Date date = new Date(calender.getTimeInMillis());
		todaySdf.setTimeZone(TimeZone.getTimeZone("Asiz/Seoul"));
		String todayDate = todaySdf.format(date);
		// 오늘 타임스탬프(데이트포맷으로 저장했다고 치고 그걸 타임스탬프로 바꿔보는 작업)
		long todayTimestamp = 0;
		try {
			todayTimestamp = todaySdf.parse(todayDate).getTime();
		} catch (ParseException e1) { // 오늘날짜 구햇음
			e1.printStackTrace();
		}
		Date date2 = new Date(todayTimestamp);
		String todayDate2 = todaySdf.format(date2);
		//////////
		long nextdayTimeStamp = 0;
		try {
			nextdayTimeStamp = todaySdf.parse(reserCheckIn2).getTime();
		} catch (ParseException e1) {
			e1.printStackTrace();
		} // nextdayTimeStamp-> 이게 체크인 날짜임
		long differenceTimeStamp = (nextdayTimeStamp - todayTimestamp);
		long betweenDay = (differenceTimeStamp / (24 * 60 * 60 * 1000));
		System.out.println("체크인날짜 : " + nextdayTimeStamp + "오늘 날짜 : " + todayTimestamp + "두날짜 간 차이 :" + betweenDay);
		try {
			response.getWriter().print(betweenDay);// 일수차이
			if (betweenDay >= 2) {
				vo = dao.reserDelete(reserNum);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		// "reserM.do";
	}

}