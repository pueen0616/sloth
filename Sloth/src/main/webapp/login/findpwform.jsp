<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/host/css/inputStyle.css">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<div><h3>비밀번호 찾기</h3></div>
<hr/>
<form id="frm" name="frm" action="findPassword.do" method="post">
<div class="_s1t1w0" style="margin-bottom: 16px;">이름</div>	
<div style="margin-bottom: 32px;"><input type="text" id="name" name="name" placeholder="이름을 입력하세요"></div>

<div class="_s1t1w0" style="margin-bottom: 16px;">이메일</div>
<div style="margin-bottom: 32px;"><input type="text" id="id" name="id" placeholder="아이디를 입력하세요"></div>

<button class="btn btn-primary" type="submit">비밀번호 찾기</button>

</form>
</div>
</body>
</html>