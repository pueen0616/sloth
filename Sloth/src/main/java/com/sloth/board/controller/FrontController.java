package com.sloth.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sloth.Host.command.HighPrice;
import com.sloth.Host.command.HostDetail;
import com.sloth.Host.command.HostMAction;
import com.sloth.Host.command.HostUp;
import com.sloth.Host.command.HostUpFormAction;
import com.sloth.Host.command.LowPrice;
import com.sloth.Host.command.Reser;
import com.sloth.Host.command.ReserInsertAction;
import com.sloth.Host.command.picdeleteAction;
import com.sloth.Host.command.picupdateAction;
import com.sloth.Login.command.AccountUpdateAction;
import com.sloth.Login.command.FindId;
import com.sloth.Login.command.FindPassword;
import com.sloth.Login.command.Findidresult;
import com.sloth.Login.command.FindpwAction;
import com.sloth.Login.command.LoginAction;
import com.sloth.Login.command.LoginFormAction;
import com.sloth.Login.command.LogoutAction;
import com.sloth.Login.command.Register;
import com.sloth.Login.command.RegisterFormAction;
import com.sloth.Login.command.UpdateAccount;
import com.sloth.board.command.DeleteReser;
import com.sloth.board.command.HostmUpdateAction;
import com.sloth.board.command.HostmUpdateFormAction;
import com.sloth.board.command.Main;
import com.sloth.board.command.ReserMAction;
import com.sloth.board.command.RoomListSelectAction;
import com.sloth.board.command.SearchAction;
import com.sloth.board.command.UpdateReser;
import com.sloth.board.common.Action;
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Action> map = new HashMap<String, Action>();
	
    public FrontController() {
        super();
        
    }

    public void init(ServletConfig config) throws ServletException {
		// 요청들을 정의함
    	map.put("/main.do", new Main()); 				 	  //처음 들어오는 페이지 처리 index.jsp
    	map.put("/loginForm.do", new LoginFormAction());	  //로그인페이지 이동
    	map.put("/loginResult.do",new LoginAction()); 
    	map.put("/logout.do",new LogoutAction());			  //로그아웃 처리
    	map.put("/registerForm.do", new RegisterFormAction());//회원가입페이지 이동
		map.put("/register.do",new Register());  			  //회원가입등록처리
		map.put("/hostDetail.do",new HostDetail());			  //상세보기
		map.put("/roomlist.do",new RoomListSelectAction());	  //검색결과화면 출력
		map.put("/hostUpForm.do", new HostUpFormAction());    //숙소등록 폼
		map.put("/search.do", new SearchAction());			  //검색처리 
		map.put("/hostUp.do", new HostUp()); 				  //숙소등록 처리
		map.put("/search.do", new SearchAction());			  //숙소 검색
		map.put("/findId.do", new FindId());				  //아이디 찾기
		map.put("/findidresult.do", new Findidresult());   
		map.put("/findPassword.do", new FindPassword());	  //비밀번호 찾기
		
		map.put("/highPrice.do", new HighPrice()); 			  //높은 가격 필터
		map.put("/hostM.do", new HostMAction());		      //숙소조회
		map.put("/reserM.do",new ReserMAction());			  //예약조회
		map.put("/deleteReser.do",new DeleteReser()); 		  //예약삭제
		map.put("/updateReser.do",new UpdateReser());
		map.put("/findpwform.do", new FindpwAction());        //비밀번호 찾기 이동
		map.put("/Account.do", new AccountUpdateAction());	  //회원정보 수정이동
		map.put("/AccountUpdate.do", new UpdateAccount());    //회원정보수정 처리
		
		map.put("/hostmUpdate.do", new HostmUpdateAction());
		map.put("/hostmUpdateForm.do", new HostmUpdateFormAction());
		map.put("/picdelete.do", new picdeleteAction());
    	
    
		map.put("/highPrice.do", new HighPrice()); 			  //가격 내림차순
		map.put("/lowPrice.do", new LowPrice()); 			  //가격 내림차순
		map.put("/reserv.do", new Reser());		      		  //숙소예약화면
		map.put("/reser.do", new ReserInsertAction());		  //숙소예약처리
		map.put("/hostM.do", new HostMAction());			  //숙소관리화면

		map.put("/hostmUpdate.do", new HostmUpdateAction()); //숙소관리 수정
		map.put("/hostmUpdateForm.do", new HostmUpdateFormAction()); //숙소관리 리스트
		map.put("/picdelete.do", new picdeleteAction()); //호스트사진수정에서 사진 삭제
//		map.put("/picdeleteForm.do", new picdeleteFormAction()); // 호스트 수정에서 사진 리스트
		map.put("/picupdate.do",new picupdateAction()); //호스트 사진수정에서 사진 리스트
		map.put("/picupload.do", new picuploadAction()); //호스트사진수정애서 사진등록
	
		map.put("/reserM.do",new ReserMAction()); 			  //예약관리처리
		map.put("/highPrice.do", new HighPrice()); 			  //높은 가격 필터
		map.put("/hostM.do", new HostMAction());		      //숙소조회
		map.put("/reserM.do",new ReserMAction());			  //예약조회
		map.put("/deleteReser.do",new DeleteReser()); 		  //예약삭제
		map.put("/updateReser.do",new UpdateReser());
		
		map.put("/hostmUpdate.do", new HostmUpdateAction());
		map.put("/hostmUpdateForm.do", new HostmUpdateFormAction());
		map.put("/picdelete.do", new picdeleteAction());
    	}
    
    	
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수행할 명령을 정리
		  request.setCharacterEncoding("utf-8"); //한글깨짐 방지!
	      String uri = request.getRequestURI();
	      String contextPath = request.getContextPath();
	      String path = uri.substring(contextPath.length()); //실제 들어오는 요청페이지를 찾음(uri에서 contextPath를 지움)
	      
	      Action command = map.get(path);
	      
		      String viewPage = command.exec(request, response); //명령어가 수행되고 나서 보여줄 페이지 선택
	      
	      if(viewPage !=null) {
		    	 if(viewPage.startsWith("redirect")) {
		    		 response.sendRedirect(viewPage.substring(9));
		    	 }else {
		      RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); //선택한 페이지로 가기
		      dispatcher.forward(request, response);   
		      }
		  }
	}
}
