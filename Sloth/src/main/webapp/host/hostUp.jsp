<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>숙 소 등 록</h1></div>
	<div>
		<form id="frm" name="frm" action="${pageContext.request.contextPath}/main.do" method="post">
			<table border="1">
				<tr>
					<th width="150">숙소 이름</th>
					<td width = "500"><input type="text" id="room_name" name="room_name"></td>
				</tr>
				<tr>
					<th width="150">숙소 주소</th>
					<td><input type="text" id="room_address" name="room_address"></td>
				</tr>
				<tr>
					<th width="150">최대 인원 수</th>
					<td><input type="text" id="room_max" name="room_max"></td>
				</tr>
				<tr>
					<th width="150">숙소 가격</th>
					<td><input type="text" id="room_price" name="room_price" ></td>
				</tr>
				<tr>
					<th width="150">입실 : 퇴실</th>
					<td><input type="text" id="room_checkin" name="room_checkin">
						<input type="text" id="room_checkout" name="room_checkout"></td>
				</tr>
				<tr>
					<th width="150">숙소 정보</th>
					<td><p><textarea cols="50" rows="10"></textarea></p></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="등록하기"> &nbsp;&nbsp;
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>