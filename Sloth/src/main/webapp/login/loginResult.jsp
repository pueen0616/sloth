<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../mainPage/mainMenu.jsp"></jsp:include>


<hr>
	<div align="center">
	<c:if test="${vo.name eq null }">
		<h1> 로그인 실패!</h1><br>
		<h1> 아이디, 패스워드 확인요망</h1>
	</c:if>	
	
	<c:if test="${vo.name ne null }">
		<h1>${vo.name } 님 로그인</h1>
  <%response.sendRedirect("main.do"); %>
	</c:if>
	</div>
</body>
</html>