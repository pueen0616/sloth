<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title></title>

<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<style>
img{
	width: auto; height: auto;
    max-width: 1000px;
    max-height: 500px;
}
.box{
box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
</style>
<script>

</script>
</head>
<body>
	<main class="images">
		<div class="container" >
			<div id="name" name="name">
				<h1>${detail.room_name }</h1>
				<h5>${detail.room_address }</h5>
			</div>
			<div id="address" name="address">
				<h4>슈퍼 호스트</h4>
				<hr>
				<button type="button" class="btn btn-outline-secondary" style="float: right;">♡저장</button>
			</div>

			<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					  <c:forEach items="${piclist }" var="pic" >
					    <div class="carousel-item active">
					      <img src="img/${pic.pic }" class="d-block w-100" alt="ro">
					    </div>
  					</c:forEach>
				</div>
			  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
		  </div>
			<div style="display: flex; height: 1200px;">
				<div class="col-md-8">
					<div style="display: flex;">
						<div>
							<div>
								<h5></h5>
							</div>
							<div>
								<h6>최대 ${detail.room_max }명 인원이 숙박 가능합니다</h6>
							</div>
						</div>
					</div>
					<hr>
					<h3>Info</h3>
					<div id="info" name="info">${detail.room_info }</div>
				</div>
<!--예약박스 -->
				<form id="frm" name="frm" action="reserv.do" method="post">
				<div class="col-md-4">
					<div class="box" style="border: 1px solid; position: fixed; width: 30%; border-radius: 25px; bottom: 10px; ">
						<div style="padding: 20px;">
							<span style="font-size: 20px;">${detail.room_price }</span> <span>/박</span> <span
								style="float: right;">★4.84</span>
						</div>
						<div class='row' style="padding: 20px;">
							<input class="search__input" type="date" value="${selectVO.room_checkin }"/>체크인 날짜
							 <input class="search__input" type="date" value="${selectVO.room_checkout }"/>체크아웃 날짜
							<div class="col-6" style="border: 1px solid;">
								인원 
								<select class="search__input" id="room_max" name="room_max">
									<option>${selectVO.room_max }</option>
			                        <option>1</option>
			                        <option>2</option>
			                        <option>3</option>
			                        <option>4</option>
			                        <option>5</option>
			                        <option>6</option>
			                        <option>7</option>
			                        <option>8</option>
				                  </select>
							</div>
						</div>
						<div align="center">
							<a href="reserv.do" class="btn btn-danger btn-lg active" role="button"
								aria-pressed="true">예약하기</a>
						</div>
					</div>
				</div>
				</form>
			</div>

		</div>
	</main>


</body>

</html>
