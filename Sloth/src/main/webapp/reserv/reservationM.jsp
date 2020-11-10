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
<script type="text/javascript">
$("#delete_btn").click(function(){
	if(confirm("정말 삭제하시겠습니까?")==true){
		String id= ${reserInfo2.id};
		int reserNum=${reserInfo2.reserNum};
		location.href="deleteReser.do?id=${reserInfo2.id}&reserNum=${reserInfo2.reserNum }";
		
		 alert("삭제되었습니다.");
			
	else{
		return;
	}

});




</script>
	<form id="frm" name="frm" method="post">
		<table class="table table-bordered table-dark"
			style="text-align: center">
			<thead>
				<tr>
					<th scope="col">예약번호</th>
					<th scope="col">숙소이름</th>
					<th scope="col">체크인 날짜</th>
					<th scope="col">체크아웃 날짜</th>
					<th scope="col">가격</th>
					<th scope="col">인원</th>
					<th scope="col">예약자 ID</th>
					<th scope="col">숙소 번호</th>
					<th scope="col">결제한 날짜</th>
					<th scope="col">수정</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${reserInfo2}" var="reserInfo2" varStatus="i">
					<tr>
						<td>${reserInfo2.reserNum }</td>
						<td>${reserInfo2.reserRoomName}</td>
						<td><input type="text" value="${reserInfo2.reserCheckIn}"></td>
						<td>${reserInfo2.reserCheckOut}</td>
						<td>${reserInfo2.reserPrice}</td>
						<td>${reserInfo2.reserMax}</td>
						<td>${reserInfo2.id}</td>
						<td>${reserInfo2.roomNum}</td>
						<td>${reserInfo2.reserToday}</td>
						<td><button type="button" onclick="doUpdate()" class="btn btn-light">수정</button>
							<button type="button" id = "delete_btn" class="btn btn-light">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>