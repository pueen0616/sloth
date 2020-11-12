<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/host/css/inputStyle.css">
</head>
<body>

	<div class="container" align="center">
		<h1>회원 정보 수정</h1>
		<hr/>
		<form id="frm" name="frm" action="AccountUpdate.do" method="post">
			<div class="_s1t1w0" style="margin-bottom: 16px;">아이디</div>	
			<div style="margin-bottom: 32px;"><input type="text" id="id" name="id" value="${id}" readonly></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">비밀번호를 입력하세요</div>
			<div style="margin-bottom: 32px;">
				<input type="password" id="password" name="password" value="${user.password}">
			</div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">이름을 입력하세요</div>
			<div style="margin-bottom: 32px;"><input type="text" id="name" name="name" value="${user.name}"></div>
						
			<div class="_s1t1w0" style="margin-bottom: 16px;">생일</div>
			<div style="margin-bottom: 32px;"><input type="text" id="birth" name="birth" value="${user.birth}" readonly>
			</div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">전화번호를 입력하세요</div>
			<div style="margin-bottom: 32px;"><input type="text" id="tel" name="tel" value="${user.tel}"></div>

			<div class="_s1t1w0" style="margin-bottom: 16px;">이메일을 입력하세요</div>
			<div style="margin-bottom: 32px;"><input type="text" id="email" name="email" value="${user.email}"></div>



			<div>
				<input class="btn btn-primary" type="submit" value="수정하기"> &nbsp;&nbsp; 
				<input class="btn btn-primary" type="submit" value="탈퇴하기" onclick="location.href='deleteAccountAction.do'">&nbsp;&nbsp; 
				<input class="btn btn-primary" type="reset" value="취소">
			</div>
		</form>
	</div>
	<script>
		
	</script>

</body>
</html>