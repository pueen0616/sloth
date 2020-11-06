<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script>
	$(()=>{
		var s = document.getElementById("roomMax");
	    var roomMax = s.options[s.selectedIndex].value;
	});
</script>
<style>
input[type=text] {
    border : 2px solid skyblue;
    border-radius : 5px;
}
input[type=text]:hover {
    background : aliceblue;
}
._s1t1w0m{
	margin: 0px !important;
    word-wrap: break-word !important;
    font-family: Circular,-apple-system,BlinkMacSystemFont,Roboto,Helvetica Neue,sans-serif !important;
    font-size: 24px !important;
    font-weight: 800 !important;
    line-height: 1.25em !important;
    color: #484848 !important;
    padding-top: 2px !important;
    padding-bottom: 2px !important;
}
._s1t1w0{
	margin: 0px !important;
    word-wrap: break-word !important;
    font-family: Circular,-apple-system,BlinkMacSystemFont,Roboto,Helvetica Neue,sans-serif !important;
    font-size: 17px !important;
    font-weight: 800 !important;
    line-height: 1.25em !important;
    color: #484848 !important;
    padding-top: 2px !important;
    padding-bottom: 2px !important;
}
</style>
</head>
<body>
<div align="center">
	<div class="_s1t1w0m">숙소를 등록 해보세요</div>
	<hr style="margin-bottom: 32px;">
	<div>
		<form id="frm" name="frm" action="/Sloth/hostUp.do" method="post" enctype="multipart/form-data">
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">숙소 이름은 무엇인가요</div>	
			<div style="margin-bottom: 32px;"><input type="text" id="roomName" name="roomName"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">숙소 위치는 어디일까요</div>
			<div style="margin-bottom: 32px;"><input type="text" id="roomAddress" name="roomAddress"></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">최대 인원을 정해 주세요</div>
			<select style="margin-bottom: 32px;" id="roomMax" name="roomMax">
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
			<input type="date" id="FirstCheckIn" name="FirstCheckIn">
			<input type="date" id="LastCheckIn" name="LastCheckIn" style="margin-bottom: 32px;">
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">1박 가격은 얼마인가요</div>
			<div style="margin-bottom: 32px;"><input type="text" id="roomPrice" name="roomPrice" ></div>
			
			<div class="_s1t1w0" style="margin-bottom: 16px;">당신의 숙소를 자랑 해주세요</div>
			<textarea cols="30" rows="10" id="roomInfo" name="roomInfo"></textarea>
			
			<div style="margin-bottom: 32px;"><input type="hidden" id="id" name="id" value="${id}" readonly></div>
				<div style="margin-bottom: 32px;">대표사진<input type="file" id="img" name="img1"></div>
				<div style="margin-bottom: 32px;">사진<input type="file" id="img" name="img"></div>
			<div><input type="submit" value="다음">
 				 <input type="reset" value="취소"></div>
		</form>
	</div>
</div>
</body>
</html>