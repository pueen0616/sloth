<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 필요한 CSS, JS 로드 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/mainPage/css/menu.css">
	
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>

<body>
<jsp:include page="/mainPage/mainMenu.jsp"></jsp:include><br>
<p></p>
<decorator:body />
<div style="background-color: #F7F7F7">
<hr/>
<br><br><br><br>
© 2020 Yirbnb, Inc. All rights reserved<br>
개인정보 처리방침 · 이용약관 · 사이트맵 · 한국의 변경된 환불 정책
<img src="${pageContext.request.contextPath}/img/aaa.png" style="float: right;    margin-right: 0px; margin-bottom: 0px;" >
<br><br>
</div>
</body>
</html>