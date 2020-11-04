<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

</head>
<body>

	<nav style="height: 120px;">
		<div style="float: left;" class="logo">
			<a href="main.do"><img src="${pageContext.request.contextPath}/logo/logo.png" width="150px"></a>
		</div>

		<div style="float: right;" class="btn-group dropleft">
			<a class="btn btn-secondary dropdown-toggle" href="#" role="button"
				id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"><i class="fas fa-user"></i></a>

			<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
				<c:if test="${name eq null }">
					<a class="dropdown-item" href="loginForm.do">로그인</a>
				</c:if>
				<c:if test="${name ne null }">
					<a class="dropdown-item" href="hostUpForm.do">호스트가 되기</a>
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