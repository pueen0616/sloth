
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/host/css/inputStyle.css">
</head>
<body>
<div align="center">
	<div class="_s1t1w0m">숙소 정보 변경</div>
	<hr style="margin-bottom: 32px;">
	<div>
		<form id="frm" name="frm" action="hostmUpdate.do" method="post" enctype="multipart/form-data">
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">숙소 이름</div>	
			<div style="margin-bottom: 32px;"><input type="text" id="room_name" name="room_name" value="${updateform.room_name }"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">숙소 위치</div>
			<div style="margin-bottom: 32px;"><input type="text" id="room_address" name="room_address" value="${updateform.room_address }"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">최대 인원</div>
			<select style="margin-bottom: 32px;" id="room_max" name="room_max" >
			    <option value="1">1</option>
			    <option value="2">2</option>
			    <option value="3">3</option>
			    <option value="4">4</option>
			    <option value="5">5</option>
			    <option value="6">6</option>
			    <option value="7">7</option>
			    <option value="8">8</option>
			</select>
			<script>
				$('#room_max').val('${updateform.room_max }');
			</script>
			
			<div class="_s1t1w0">운영 할 날</div>
			<input type="date" id="room_checkIn" name="room_checkIn" value="${updateform.room_checkin }">
			<input type="date" id="room_checkOut" name="room_checkOut" style="margin-bottom: 32px;" value="${updateform.room_checkout }">
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">1박 가격</div>
			<div style="margin-bottom: 32px;"><input type="text" id="room_price" name="room_price" value="${updateform.room_price }" ></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">Info</div>
			<textarea cols="30" rows="10" id="room_info" name="room_info">${updateform.room_info }</textarea>
			
				<div style="margin-bottom: 32px;">대표사진<input type="file" id="img1" name="img1"></div>
				
				<div style="margin-bottom: 32px;">사진<input type="file" id="img" name="img"></div>
				
			<div style="padding: 20px;" ><input type="submit" value="수정" class="btn btn-primary">
 				 <input type="reset" value="취소" class="btn btn-primary"></div>
 				 <input type="hidden" id="id" name="id" value="${id}" readonly>
			<input type="hidden" id="room_num" name="room_num" value="${updateform.room_num }" readonly>
		</form>
	</div>
</div>
</body>

</html>