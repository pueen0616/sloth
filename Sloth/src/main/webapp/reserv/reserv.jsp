<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
.pay{
	padding:20px 17px;
}

.no-border { border:0px; background:#ffffff; }
</style>
</head>
<body>
<script>
function reser(){
	if(${id == null}){
		alert('로그인 후 숙소 예약이 가능합니다');
		 return false;
	} else {
	alert('예약이 완료되었습니다');
	}
	  return true;
}
</script>
<form id="frm" name="frm" action="reser.do" method="post">
<fmt:parseDate value="${realReser.room_checkin }" var="strPlanDate" pattern="yyyy-MM-dd"/>
<fmt:parseNumber value="${strPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="strDate"></fmt:parseNumber>
<fmt:parseDate value="${realReser.room_checkout }" var="endPlanDate" pattern="yyyy-MM-dd"/>
<fmt:parseNumber value="${endPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="endDate"></fmt:parseNumber>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<div>
					<h3 style="font-weight: 700">확인 및 결제</h3>
				</div>
				<hr>
				<div>
					<h4>예약 정보</h4><br>
				</div>
				<div>
					<h6>날짜</h6>
				</div>
				
				<div style="font-weight: lighter;">체크인 ${realReser.room_checkin } 체크아웃 ${realReser.room_checkout }</div><br>
				<div>
					<h6>인원수</h6>
				<div style="font-weight: lighter;">${realReser.room_max } 명</div>
				</div>
			</div>
			<div class="col-6">
				<div class="box" style="border: 1px solid; width: 90%; border-radius: 25px; background-color: #ffffff" >
					<img style="width:100px; height:100px; padding:10px;  border-radius: 20px;" src="${pageContext.request.contextPath}/img/room1.jpeg">
					<a>${detail.room_name }</a>&nbsp;&nbsp;
					<a>${detail.room_address }</a>&nbsp;&nbsp;
					<a>★4.4</a>					
					<div style="padding: 20px;">
						<div><h4 style="font-weight: 700">요금 세부 정보 </h4></div>
						
						<span style="font-size: 20px;">
						₩&nbsp;${detail.room_price }&nbsp;/박 <br><br>
						총 ${endDate - strDate }박
						<input type="text" class="no-border" id="room_price1" name="room_price1" value="${detail.room_price*(endDate-strDate)}" readonly> 
						</span> 
					</div>
					<div class="pay"><button type="submit" class="btn btn-danger btn-lg active" onclick="reser()">결제</button></div>
				</div>
			</div>
		</div>
	</div>
	</form>
</body>
</html>