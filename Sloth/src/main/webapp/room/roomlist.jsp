<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/common.css">
<script type="text/javascript">
	
</script>
<style>
.test img, .test table, {
	 border: 1px
 
	 solid
 
	 black;
}
.test img {
	width: 120px;
	height: 150px;
}

test th, .test td {
	border: 1px solid black;
	width: 60px;
}
.picNum {
display: none;
}
</style>
</head>
<body>
	<!-- 테스트1 -->
	<div class="test">
		<img src="${pageContext.request.contextPath}/img/asd.jpg"></img>
		<table>
			<tr>
				<th>제목</th>
				<td>DBVALUE</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>DBVALUE</td>
			</tr>
		</table>
	</div>
	<!-- 테스트 끝 -->
	<!-- 테스트2 -->
	<div class="wrap">
		<h1>숙소 리스트</h1>
		<table border="1">
			<thead>
				<tr>
					<td>제목</td>
					<td>가격</td>
					<td>사진번호</td>
					<td>사진이름</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${roomlist }" var="item" varStatus="i">
					<tr>
						<td><c:out value="${item.roomName}" /></td>
						<td><c:out value="${item.roomPrice}" /></td>
						<td><c:out value="${item.picNum}" /></td>
						<td><img
							src="${pageContext.request.contextPath}/img/${item.pic}"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 테스트2 ㅌ -->

		<div class="fixed_img_col">
			<c:forEach items="${roomlist }" var="item" varStatus="i">
				<ul id="roomlist">
					<li><a href="./host/hostDetail.html"> <span class="thumb">
								<img alt="왜아무것도안나오지"
								src="${pageContext.request.contextPath}/img/${item.pic}">
								<em>-</em>
						</span> <Strong>${item.roomName}</Strong>
					</a>
						<p>${item.roomPrice}</p></li>
				</ul>
				<div class="picNum">${item.picNum}</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>