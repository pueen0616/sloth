<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="mainPage/css/menu.css">
</head>
<body>
  <nav>
             
            <div class="logo" >
              <a href="main.do"><img src="logo/logo.png" width="100px" > </a>
            </div>
            <div class="menu" >
                <ul>
                    <li><a href="loginForm.do">로그인</a></li>
                <c:if test="${id ne null }">
                    <li><a href="#">호스트가 되기</a></li>
                    <li><a href="#">계정</a></li>
                    <li><a href="#">게시판</a></li>
                    <li><a href="#">예약관리</a></li>                
                	<c:if test="${userType ne null }">
                    	<li><a href="#">숙소관리</a></li>
	                </c:if>
                    <li><a href="#">관심숙소</a></li>
                    <li><a href="logout.do">로그아웃</a></li>
				</c:if>
                </ul>
            </div>
        </nav>
</body>
</html>