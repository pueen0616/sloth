<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1 align="center">예약자 리스트 </h1>
	<table class="table table-bordered table-hovers">
		<thead>
			<tr>
				<th scope="col" style="padding: 5px; text-align: center;">예약 번호</th>
				<th scope="col" style="padding: 5px; text-align: center;">아이디</th>
				<th scope="col" style="padding: 5px; text-align: center;">체크인</th>
				<th scope="col" style="padding: 5px; text-align: center;">체크아웃</th>
				<th scope="col" style="padding: 5px; text-align: center;">예약한날</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${hostMreserList}" var="reser">
				<tr>
					<td class='bbb' style="padding: 5px; text-align: center;">${reser.reserNum }</td>
					<td class='bbb' style="padding: 5px; text-align: center;">${reser.id }</td>
					<td class='bbb' style="padding: 5px; text-align: center;">${reser.reserCheckIn }</td>
					<td class='bbb' style="padding: 5px; text-align: center;">${reser.reserCheckOut }</td>
					<td class='bbb' style="padding: 5px; text-align: center;">${reser.reserToday }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>