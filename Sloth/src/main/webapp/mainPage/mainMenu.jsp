<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/mainPage/css/menu.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/mainPage/css/all.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>

</head>
<body>
asdfaf
	<nav style="height: 120px;">

		<div style="float: left;" class="logo">
			<a href="main.do"><img src="${pageContext.request.contextPath}/logo/logo.png" width="150px"></a>
		</div>

		<div style="float: right;" class="dropdown">
			<a class="btn btn-secondary dropdown-toggle" href="#" role="button"
				id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"><i class="fas fa-user"></i></a>

			<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
				<c:if test="${id eq null }">
					<a class="loginForm" href="loginForm.do">로그인</a>
				</c:if>
				<c:if test="${id ne null }">
					<a href="hostUpForm.do">호스트가 되기</a>
					<a class="dropdown-item" href="#">계정</a>
					<a class="dropdown-item" href="#">게시판</a>
					<a class="dropdown-item" href="#">예약관리</a>
					<c:if test="${userType ne null }">
						<a class="dropdown-item" href="#">숙소관리</a>
					</c:if>
					<a class="dropdown-item" href="#">관심숙소</a>
					<a class="dropdown-item" href="logout.do">로그아웃</a>
				</c:if>
			</div>
		</div>
	</nav>
</body>
</html>