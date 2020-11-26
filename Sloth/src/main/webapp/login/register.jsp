<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/host/css/inputStyle.css">
</head>
<body>
<script type="text/javascript">
function register(){
	alert("회원가입이 완료되었습니다");
}
</script>
<div align="center">
	<div><h1>회 원 가 입</h1></div>
	<hr/>
	<div>
		<form id="frm" name="frm" action="${pageContext.request.contextPath}/register.do" method="post">
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">아이디</div>	
			<div style="margin-bottom: 32px;"><input type="text" id="id" name="id" placeholder="아이디를 입력하세요"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">패스워드</div>
			<div style="margin-bottom: 32px;"><input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">이름</div>
			<div style="margin-bottom: 32px;"><input type="text" id="name" name="name" placeholder="ex> 홍길동"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">생일</div>
			<div style="margin-bottom: 32px;">
			<input type="date" id="birth" name="birth"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">전화번호</div>
			<div style="margin-bottom: 32px;"><input type="text" id="tel" name="tel" placeholder="ex> 010-0000-0000"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">이메일</div>
			<div style="margin-bottom: 32px;"><input type="text" id="email" name="email" placeholder="ex> yirBnB@co.kr"></div> <br><br>	
			
			
			
			<input type="submit" value="가입하기" class="btn btn-primary" onclick="return register()"> &nbsp;&nbsp;
			<input type="reset" value="취소" class="btn btn-primary">
		</form>
	</div>

</div>
</body>
</html>