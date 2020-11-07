<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-6">
				<div>
					<h3 style="font-weight: 700">확인 및 결제</h1>
				</div>
				<hr>
				<div>
					<h4>예약 정보</h4>
				</div>
				<div>
					<h6>날짜</h6>
				</div>
				<div style="font-weight: lighter;">${selectVO.room_checkin } - ${selectVO.room_checkout }</div>
				<div>
					<h6>인원수</h6>
				</div>
				<div style="font-weight: lighter;">${selectVO.room_max } 명</div>
			</div>
			<div class="col-6">
				<div class="box" style="border: 1px solid; position: fixed; width: 30%; border-radius: 25px;">
					<img style="width:100px; height:100px; padding:10px;  border-radius: 20px;" src="${pageContext.request.contextPath}/img/room1.jpeg">
					<a>${detail.room_name }</a>&nbsp;&nbsp;
					<a>${detail.room_address }</a>&nbsp;&nbsp;
					<a>★4.4</a>					
					<div style="padding: 20px;">
						<div><h4 style="font-weight: 700">요금 세부 정보 </h4></div>
						<span style="font-size: 20px;">${detail.room_price }</span> 
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>