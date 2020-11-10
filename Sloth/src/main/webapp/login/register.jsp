<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
input[type=text] {
    border : 2px solid skyblue;
    border-radius : 5px;
}
input[type=text]:hover {
    background : aliceblue;
}
._s1t1w0m{
	margin: 0px !important;
    word-wrap: break-word !important;
    font-family: Circular,-apple-system,BlinkMacSystemFont,Roboto,Helvetica Neue,sans-serif !important;
    font-size: 24px !important;
    font-weight: 800 !important;
    line-height: 1.25em !important;
    color: #484848 !important;
    padding-top: 2px !important;
    padding-bottom: 2px !important;
}
._s1t1w0{
	margin: 0px !important;
    word-wrap: break-word !important;
    font-family: Circular,-apple-system,BlinkMacSystemFont,Roboto,Helvetica Neue,sans-serif !important;
    font-size: 17px !important;
    font-weight: 800 !important;
    line-height: 1.25em !important;
    color: #484848 !important;
    padding-top: 2px !important;
    padding-bottom: 2px !important;
}
</style>
</head>
<body>
<div align="center">
	<div><h1>회 원 가 입</h1></div>
	<div>
		<form id="frm" name="frm" action="${pageContext.request.contextPath}/register.do" method="post">
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">아이디</div>	
			<div style="margin-bottom: 32px;"><input type="text" id="id" name="id"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">패스워드</div>
			<div style="margin-bottom: 32px;"><input type="password" id="password" name="password"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">이름</div>
			<div style="margin-bottom: 32px;"><input type="text" id="name" name="name"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">생일</div>
			<div style="margin-bottom: 32px;"><input type="text" id="birth" name="birth" ></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">전화번호</div>
			<div style="margin-bottom: 32px;"><input type="text" id="tel" name="tel" ></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">이메일</div>
			<div style="margin-bottom: 32px;"><input type="text" id="email" name="email"></div> <br><br>	
			
			<input type="submit" value="가입하기"> &nbsp;&nbsp;
			<input type="reset" value="취소">
		</form>
	</div>

</div>
</body>
</html>