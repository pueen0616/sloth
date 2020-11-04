<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<<<<<<< HEAD
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/mainPage/css/menu.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/mainPage/css/all.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
=======
<<<<<<< HEAD
<link rel="stylesheet" href="mainPage/css/menu.css">
<!-- 필요한 CSS, JS 로드 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- 저 같은 경우는 webapp 안에 resouces 폴더 안에 js 안에 plugin 안에 hangul 안에 hangul.js 이 있습니다. -->
<script type="text/javascript" src="hangul/hangul.js"></script>
=======
<link rel="stylesheet" href="${pageContext.request.contextPath}/mainPage/css/menu.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/mainPage/css/all.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
>>>>>>> branch 'main' of https://github.com/pueen0616/sloth.git

<<<<<<< HEAD
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>

=======

>>>>>>> branch 'main' of https://github.com/pueen0616/sloth.git
>>>>>>> branch 'main' of https://github.com/pueen0616/sloth.git
</head>
<body>
<<<<<<< HEAD
asdfaf
=======
<<<<<<< HEAD
  <nav>
             
            <div class="logo">
              <!--   <svg viewBox="0 0 1000 1000" role="presentation" aria-hidden="true" focusable="false"
                    style="height: 1em; width: 1em; display: inline-block; fill: currentcolor;">
                    <path
                        d="m499.3 736.7c-51-64-81-120.1-91-168.1-10-39-6-70 11-93 18-27 45-40 80-40s62 13 80 40c17 23 21 54 11 93-11 49-41 105-91 168.1zm362.2 43c-7 47-39 86-83 105-85 37-169.1-22-241.1-102 119.1-149.1 141.1-265.1 90-340.2-30-43-73-64-128.1-64-111 0-172.1 94-148.1 203.1 14 59 51 126.1 110 201.1-37 41-72 70-103 88-24 13-47 21-69 23-101 15-180.1-83-144.1-184.1 5-13 15-37 32-74l1-2c55-120.1 122.1-256.1 199.1-407.2l2-5 22-42c17-31 24-45 51-62 13-8 29-12 47-12 36 0 64 21 76 38 6 9 13 21 22 36l21 41 3 6c77 151.1 144.1 287.1 199.1 407.2l1 1 20 46 12 29c9.2 23.1 11.2 46.1 8.2 70.1zm46-90.1c-7-22-19-48-34-79v-1c-71-151.1-137.1-287.1-200.1-409.2l-4-6c-45-92-77-147.1-170.1-147.1-92 0-131.1 64-171.1 147.1l-3 6c-63 122.1-129.1 258.1-200.1 409.2v2l-21 46c-8 19-12 29-13 32-51 140.1 54 263.1 181.1 263.1 1 0 5 0 10-1h14c66-8 134.1-50 203.1-125.1 69 75 137.1 117.1 203.1 125.1h14c5 1 9 1 10 1 127.1.1 232.1-123 181.1-263.1z">
                    </path>
                </svg> -->
            </div>
            
            <div class="menu">
                <ul>
                    <li><a href="#">호스트가 되기</a></li>
                    <li><a href="loginForm.do">로그인</a></li>
                    <li><a href="#">계정</a></li>
                    <li><a href="#">게시판</a></li>
                    <li><a href="#">예약관리</a></li>
                    <li><a href="#">숙소관리</a></li>
                    <li><a href="#">관심숙소</a></li>
                    <li><a href="#">로그아웃</a></li>
                </ul>
            </div>
        </nav>
=======
>>>>>>> branch 'main' of https://github.com/pueen0616/sloth.git
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
>>>>>>> branch 'main' of https://github.com/pueen0616/sloth.git
</body>
</html>