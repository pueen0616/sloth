<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>로그인</title>
<link rel="stylesheet" href="mainPage/css/style.css">
<script type="text/javascript">
	function formCheck() {
		var f = document.frm;
		if(f.userid.value==""){
			alert("사용자 아이디를 입력하세요");
			f.userid.focus();
			return false;
		}
		if(f.password.value==""){
			alert("사용자 비밀번호 입력하세요");
			f.password.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<header>
<jsp:include page="/mainPage/mainMenu.jsp"></jsp:include>
	<div align="center">
		<form id="frm" name="frm" method="post" action="loginResult.do">
			<h1>로그인</h1>
			<div>
				<input type="text" id="userid" name="userid" placeholder="id을 입력하세요" />
			</div>
			<div>
				<input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" />
			</div>
			<br>
			<div align="center">
				<button type="submit" id="login-submit" onclick="return formCheck()">로그인</button>
				<hr>
			</div>
		</form>
			<span class='text-center'> 
				<a href="" class="find-id">아이디	찾기&nbsp;&nbsp;
				<a href="" class="find-password">비밀번호 찾기</a></span>
			<div class="form-group">
				<a href="registerForm.do">회원가입</a>
			</div>
	</div>
	</header>
</body>
</html>
