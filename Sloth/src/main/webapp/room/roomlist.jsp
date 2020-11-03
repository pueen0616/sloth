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
</head>
<body>
	<div class="wrap">
		<h1>숙소 리스트 </h1>
		<table border="1">
			<thead>
				<tr>
					<td>제목</td>
					<td>가격</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${roomlist }" var="item" varStatus="i">
					<tr>
						<td><c:out value="${item.roomName}" /></td>
						<td><c:out value="${item.roomPrice}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="fixed_img_col">
			<ul id="roomlist">
				<li><a href="./host/hostDetail.html"> <span class="thumb">
							<img alt="왜아무것도안나오지" src="./img/img_list1.png"> <em>Category</em>
					</span> <Strong>이미지 제목</Strong>
				</a>
					<p>숙소 내용들?머이런거 쓰면 될려나 날짜??</p></li>
			</ul>
			<ul id="roomlist">
				<li><a href="../host/hostDetail.html"> <span class="thumb">
							<img alt="왜아무것도안나오지" src="./img/img_list1.png"> <em>Category</em>
					</span> <Strong>이미지 제목</Strong>
				</a>
					<p>숙소 내용들?머이런거 쓰면 될려나 날짜??</p></li>
			</ul>
		</div>
	</div>
</body>
</html>