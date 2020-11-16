package asda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;

import com.sloth.board.dao.AccountDao;
import com.sloth.board.vo.reserVO;

public class sss {
	public static void main(String[] args) {

	}

	@Test
	public void aaa() {
		AccountDao dao = new AccountDao();
		reserVO vo = new reserVO();
//		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
//		SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
//				
//		Calendar time = Calendar.getInstance();
//		       
//		String format_time1 = format1.format(time.getTime());
//		String format_time2 = format2.format(time.getTime());
//		        
//		System.out.println(format_time1);
//		System.out.println(format_time2);

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
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// TODO Auto-generated catch block
		Date date2 = new Date(todayTimestamp);
		String todayDate2 = todaySdf.format(date2);
		System.out.println(todayDate2);
		///////////////////////////////////////
		long nextdayTimeStamp = 0;
		try {
			String differenceDate="2020-11-14";
			nextdayTimeStamp = todaySdf.parse(differenceDate).getTime();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		long differenceTimeStamp = (nextdayTimeStamp - todayTimestamp );
		System.out.println(nextdayTimeStamp);
		long betweenDay = (differenceTimeStamp / (24 * 60 * 60 * 1000));
		List<reserVO> list = new ArrayList<reserVO>();

		list = dao.select_reser(vo);
		System.out.println(vo);
		System.out.println("-----------");
		System.out.println(betweenDay);
	}
}
