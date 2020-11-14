<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">


<script type="text/javascript">
   function formCheck() {
      var f = document.login;
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
   
   
   function loginDiv() {
      $("#loginDiv").show();
      $("#idDiv").hide();
      $("#pwDiv").hide();
   }
   function idFind() {
      $("#idDiv").show();
      $("#loginDiv").hide();
      $("#pwDiv").hide();
   }
   function pwFind() {
      $("#pwDiv").show();
      $("#loginDiv").hide();
      $("#idDiv").hide();
   }
   
</script>

<nav style="height: 120px;">
   <div style="float: left;" class="logo">
      <a href="main.do"><img
         src="${pageContext.request.contextPath}/logo/logo1.png" width="180px"></a>
   </div>

   <div style="float: right;" class="btn-group dropleft">
      <a class="btn btn-secondary dropdown-toggle" href="#" role="button"
         id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
         aria-expanded="false"><i class="fas fa-user"></i></a>

      <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
         <c:if test="${name eq null }">
            <a class="dropdown-item" data-toggle="modal"
               data-target="#exampleModal" onclick="loginDiv()">로그인</a>
         </c:if>
         
         <c:if test="${name ne null }">
         	<c:choose>
         		<c:when test="${empty user_type }">  
    		        <a class="dropdown-item" href="hostUpForm.do">호스트가 되기</a>
         		</c:when>
				<c:otherwise>
					<a class="dropdown-item" href="hostUpForm.do">숙소추가하기</a>
				</c:otherwise>         		
         	</c:choose>
         	
            <a class="dropdown-item" href="Account.do">계정</a>
            <a class="dropdown-item" href="#">게시판</a>
            <a class="dropdown-item" href="reserM.do?id=${id }">예약관리</a>
            <c:if test="${!empty user_type}">
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
      <div class="modal-content">
         <nav style="height: 30px;">
            <div style="float: left;" class="logo">
               <a href="main.do"><img
                  src="${pageContext.request.contextPath}/logo/logo1.png"
                  width="100px"></a>
            </div>
         </nav>
         <div class="modal-body">
            <div id="loginDiv">
               <form id="login" name="login" method="post" action="loginResult.do">
                  <div align="center">
                     <h1>로그인</h1><br>
                     <div>
                        <input type="text" id="userid" name="userid" placeholder="아이디" style="display: inline-block;"/><br><br>
                     
                        <input type="password" id="password" name="password"
                           placeholder="비밀번호" style="display: inline-block;"/>
                     </div>
                     <br> <span class='text-center'> <a href="#"
                        class="find-id" onclick="idFind()">아이디 찾기</a>&nbsp;&nbsp; <a
                        href="#" onclick="pwFind()" class="find-password">비밀번호 찾기</a></span>
                     <div class="form-group"></div>
                     <button type="submit" id="login-submit"
                        onclick="return formCheck()" class="btn btn-primary">로그인</button>
                     <button type="button" class="btn btn-primary"
                        onclick="location.href='registerForm.do'">회원가입</button>

                  </div>
               </form>
            </div>
            <div id="idDiv" style="display: none" align="center">
               <form id="idFrm" name="idFrm" method="post"
                  action="findidresult.do">
                  <div>
                     <h3>아이디 찾기</h3>
                  </div>

                  <div class="_s1t1w0" style="margin-bottom: 16px;">이름</div>
                  <div style="margin-bottom: 32px;">
                     <input type="text" id="uname" name="uname"
                        placeholder="이름을 입력하세요">
                  </div>

                  <div class="_s1t1w0" style="margin-bottom: 16px;">이메일</div>
                  <div style="margin-bottom: 32px;">
                     <input type="text" id="useremail" name="useremail"
                        placeholder="email을 입력하세요">
                  </div>
                  <button class="btn btn-primary" type="submit" id="findidresult"
                     name="findidresult" onclick="location.href='findidresult.do'">아이디 찾기</button>
               </form>

            </div>
            <div id="pwDiv" style="display: none" align="center">
               <form id="pwFrm" name="pwFrm" method="post"
                  action="findpwresult.do">
                  <div>
                     <h3>비밀번호 찾기</h3>
                  </div>

                  <div class="_s1t1w0" style="margin-bottom: 16px;">이름</div>
                  <div style="margin-bottom: 32px;">
                     <input type="text" id="uNa" name="uNa"
                        placeholder="이름을 입력하세요">
                  </div>

                  <div class="_s1t1w0" style="margin-bottom: 16px;">아이디</div>
                  <div style="margin-bottom: 32px;">
                     <input type="text" id="userID" name="userID"
                        placeholder="아이디을 입력하세요">
                  </div>
                  <button class="btn btn-primary" type="submit" id="findPWresult"
                     name="findPWresult" >비밀번호 찾기</button>
               </form>
            </div>
         </div>
      </div>
   </div>
</div>