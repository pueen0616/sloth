<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<nav style="height: 120px;">
		<div style="float: left;" class="logo">
			<a href="main.do"><img src="${pageContext.request.contextPath}/logo/logo1.png" width="180px"></a>
		</div>

		<div style="float: right;" class="btn-group dropleft">
			<a class="btn btn-secondary dropdown-toggle" href="#" role="button"
				id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"><i class="fas fa-user"></i></a>

			<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
				<c:if test="${name eq null }">
					<a class="dropdown-item" href="#" data-toggle="modal"
               data-target="#exampleModal">로그인</a>

				</c:if>
				<c:if test="${name ne null }">
					<a class="dropdown-item" href="hostUpForm.do">호스트가 되기</a>
					<a class="dropdown-item" href="#">계정</a>
					<a class="dropdown-item" href="#">게시판</a>
					<a class="dropdown-item" href="#">예약관리</a>
					<c:if test="${user_type ne null }">
						<a class="dropdown-item" href="./hostM.do">숙소관리</a>
					</c:if>
					<a class="dropdown-item" href="#">관심숙소</a>
					<a class="dropdown-item" href="logout.do">로그아웃</a>
				</c:if>
			</div>
		</div>
	</nav>

<div class="modal fade" id="exampleModal" tabindex="-1"
   aria-labelledby="exampleModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <form id="frm" name="frm" method="post" action="loginResult.do">
         <div class="modal-content">
            <div class="modal-body">
               <nav style="height: 120px;">
                  <div style="float: left;" class="logo">
                     <a href="main.do"><img
                        src="${pageContext.request.contextPath}/logo/logo.png"
                        width="50px"></a>
                  </div>
               </nav>
               <div align="center">
                  <h1>로그인</h1>
                  <div>
                     <input type="text" id="userid" name="userid"
                        placeholder="아이디" />
                  </div>
                  <div>
                     <input type="password" id="password" name="password" placeholder="비밀번호" />
                  </div>
                  <br>

               </div>
               <div class="modal-footer">
                  <span class='text-center'> <a href="findId.do"
                     class="find-id">아이디 찾기</a>&nbsp;&nbsp; <a href="findpwform.do"
                     class="find-password">비밀번호 찾기</a></span>
                  <div class="form-group"></div>
               </div>
            </div>
            <button type="submit" id="login-submit" onclick="return formCheck()"
               class="btn btn-primary">로그인</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary"
               onclick="location.href='registerForm.do'">회원가입</button>
         </div>
      </form>
   </div>
</div>

<script type="text/javascript">
   function formCheck() {
      var f = document.frm;
      if (f.userid.value == "") {
         alert("사용자 아이디를 입력하세요");
         f.userid.focus();
         return false;
      }
      if (f.password.value == "") {
         alert("사용자 비밀번호 입력하세요");
         f.password.focus();
         return false;
      }
      return true;
   }
</script>