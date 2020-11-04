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
					<td width = "500"><input type="text" id="roomNum" name="roomNum"></td>
				</tr>
				<tr>
					<th width="150">숙소 이름</th>
					<td width = "500"><input type="text" id="roomName" name="roomName"></td>
				</tr>
				<tr>
					<th width="150">숙소 주소</th>
					<td><input type="text" id="roomAddress" name="roomAddress"></td>
				</tr>
				<tr>
					<th width="150">최대 인원 수</th>
					<td><input type="text" id="roomMax" name="roomMax"></td>
				</tr>
				<tr>
					<th width="150">숙소 가격</th>
					<td><input type="text" id="roomPrice" name="roomPrice" ></td>
				</tr>
				<tr>
					<th width="150">입실 가능 첫날</th>
					<td><input type="date" id="checkIn" name="roomCheckIn"></td>
					<th width="150">입실 가능 마지막날</th>
					<td><input type="date" id="checkOut" name="roomCheckOut"></td>
				</tr>
				<tr>
					<th width="150">숙소 정보</th>
					<td><p><textarea cols="50" rows="10" id="roomInfo" name="roomInfo"></textarea></p></td>
				</tr>
				<tr>
					<th width="150">숙소 가격</th>
					<td><input type="text" id="id" name="id" ></td>
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