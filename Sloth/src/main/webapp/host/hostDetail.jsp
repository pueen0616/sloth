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
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
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
    $(document).ready(function(){
      $('.slider').bxSlider();
    });
  </script>
</head>
<body>
	<main class="images">
		<div class="container" >
			<div id="name" name="name">
				<h1>${detail.room_name }</h1>평점 ❤ ${star}<input type="hidden" id="star" name="star" readonly>
				<h5>${detail.room_address }</h5>
			</div>
			<div id="address" name="address">
				<h4>슈퍼 호스트</h4>
				<hr>
				<h6>이 펜션은  체크인:${detail.room_checkin },  체크아웃:${detail.room_checkout } 사이에 예약이 가능합니다</h6>
				<button type="button" class="btn btn-outline-secondary" style="float: right;">♡저장</button>
			</div>
			
			
					    <div class="slider ">
					  <c:forEach items="${piclist }" var="pic" >
					      <img src="img/${pic.pic }" class="img" alt="ro">
  					</c:forEach> 
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
					<br><br>
<!-- 리뷰창 -->
					<div>
					   <div>
					      <table class="table table-bordered table-hovers">
					         <tr>
					            <th width="200">작 성 일</th>
					            <th width="200">아 이 디</th>
					            <th width="1200">내 용</th>
					            <th width="100">평 점</th>
					         </tr>
					         <c:forEach var="review" items="${reviews }">
					            <tr>
					               <td>${review.today}</td>
					               <td>${review.id}</td>
					               <td>${review.review_area}</td>
					               <td>${review.review_star}</td>               
					            </tr>
					         </c:forEach>
					      </table>
					   </div>   
					    <form id="frm4" name="frm4" action="reviewAction.do">
					              내용&nbsp;&nbsp;<input  id="board_area" name="board_area" placeholder="내용을 작성하세요" >
					          <input type="hidden" name="room_num" value="${param.room_num}"><br/>
					    <button id="btn7" class="btn btn-primary" style="float:right" >등록 </button><br>
					    
					              평점&nbsp;&nbsp;<select id="review_star" name="review_star" >
					                     <option>1</option>
					                     <option>2</option>
					                     <option>3</option>
					                     <option>4</option>
					                     <option>5</option>
					            </select> 
					   </form>
					   </div>   
				</div>
<!--예약박스 -->
				<form id="frm" name="frm" action="reserv.do" method="post">
				<div class="col-md-4">
					<div class="box" style="border: 1px solid; position: fixed; width: 30%; border-radius: 25px; bottom: 10px; background-color: #ffffff">
						<div style="padding: 20px;">
							<span style="font-size: 20px;">${detail.room_price }</span> <span>/박</span> <span
								style="float: right;">❤${star }</span>
						</div>
						<div class='row' style="padding: 20px;">
							<input class="search__input" type="date" value="${selectVO.room_checkin }" id="realCheckIn" name="realCheckIn"/>체크인 날짜
							 <input class="search__input" type="date" value="${selectVO.room_checkout }" id="realCheckOut" name="realCheckOut"/>체크아웃 날짜
							<div class="col-6" style="border: 1px solid;">
								인원 
								<select class="search__input" id="realRoomMax" name="realRoomMax">
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
						<Button type="submit" class="btn btn-danger btn-lg active" >예약하기</Button>
						</div>
					</div>
				</div>
				</form>
			</div>

		</div>
	</main>


</body>

</html>
