<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/host/css/inputStyle.css">
</head>
<body>
<div align="center">
	<div class="_s1t1w0m">숙소를 등록 해보세요</div>
	<hr style="margin-bottom: 32px;">
	<div>
		<form id="frm" name="frm" action="hostUp.do" method="post" enctype="multipart/form-data">
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">숙소 이름은 무엇인가요</div>	
			<div style="margin-bottom: 32px;"><input type="text" id="room_name" name="room_name"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">숙소 위치는 어디일까요</div>
			<div style="margin-bottom: 32px;"><input type="text" id="room_address" name="room_address"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">최대 인원을 정해 주세요</div>
			<select style="margin-bottom: 32px;" id="room_max" name="room_max">
			    <option value="1">1</option>
			    <option value="2">2</option>
			    <option value="3">3</option>
			    <option value="4">4</option>
			    <option value="5">5</option>
			    <option value="6">6</option>
			    <option value="7">7</option>
			    <option value="8">8</option>
			</select>
			
			<div class="_s1t1w0">운영 할 날을 지정하세요</div>
			<input type="date" id="room_checkIn" name="room_checkIn">
			<input type="date" id="room_checkOut" name="room_checkOut" style="margin-bottom: 32px;">
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">1박 가격은 얼마인가요</div>
			<div style="margin-bottom: 32px;"><input type="text" id="room_price" name="room_price" ></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">당신의 숙소를 자랑 해주세요</div>
			<textarea cols="70" rows="10" id="room_info" name="room_info"></textarea>
			
			<div style="margin-bottom: 32px;"><input type="hidden" id="id" name="id" value="${id}" readonly></div>
			<div style="margin-bottom: 32px;">대표사진<input type="file" id="img1" name="img1"></div>
			<div style="margin-bottom: 32px;">사진<input type="file" id="img" name="img"></div>
			<div><input type="submit" value="다음" class="btn btn-primary">
 				 <input type="reset" value="취소" class="btn btn-primary"></div>
		</form>
	</div>
</div>
</body>
</html>