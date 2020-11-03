<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/mainPage/css/menu.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/mainPage/css/all.css">



</head>
<body>
	<nav style="height: 120px;">

		<div style="float:left;" class="logo">
			<img src="../logo/logo.png" width="150px">
		</div>
		
		<div style="float:right;" class="dropdown" >
			<a class="btn btn-secondary dropdown-toggle" href="#" role="button"
				id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"><i class="fas fa-user"></i></a>

			<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
			<a class="dropdown-item" href="../loginForm.do">로그인</a> 
				<a class="dropdown-item" href="#">계정</a> 
				<a class="dropdown-item" href="#">게시판</a> 
				<a class="dropdown-item" href="#">예약관리</a>
				<a class="dropdown-item" href="#">숙소관리</a> 
				<a class="dropdown-item" href="#">관심숙소</a> 
				<a class="dropdown-item" href="#">로그아웃</a> 
			</div>
		<div style="float:right;" class="menu">
			<ul>
				<li><a href="hostUpForm.do">호스트가 되기</a></li>
			</ul>
		</div>
		</div>
	</nav>
</body>
</html>