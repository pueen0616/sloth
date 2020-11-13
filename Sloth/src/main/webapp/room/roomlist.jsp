<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">	
</script>
<style>
.test img, .test table, {
	 border: 1px
	 solid
	 black;
}
.test img {
	width: 120px;
	height: 150px;
}

test th, .test td {
	border: 1px solid black;
	width: 60px;
}
.picNum {
display: none;
}

a{
display : inline;
}

button {
background:none;
border:0;
outline:0;
cursor:pointer;
}
.tab_menu_container {
display:flex;
}
.tab_menu_btn {
width:80px;
height:40px;
transition:0.3s all;
}
.tab_menu_btn.on {
border-bottom:2px solid #df0000;
font-weight:700;
color:#df0000;
}
.tab_menu_btn:hover {
color:#df0000;
}
.tab_box {
display:none;
padding:20px;
}
.tab_box.on {
display:block;
}
.main {
    min-width: 320px;
    max-width: 800px;
    padding: 50px;
    margin: 0 auto;
    background: #ffffff;}

section {
    display: none;
    padding: 20px 0 0;
    border-top: 1px solid #ddd;}

/*라디오버튼 숨김*/
  input {
      display: none;}

label {
    display: inline-block;
    margin: 0 0 -1px;
    padding: 15px 25px;
    font-weight: 600;
    text-align: center;
    color: #bbb;
    border: 1px solid transparent;}

label:hover {
    color: #2e9cdf;
    cursor: pointer;}

/*input 클릭시, label 스타일*/
input:checked + label {
      color: #555;
      border: 1px solid #ddd;
      border-top: 2px solid #2e9cdf;
      border-bottom: 1px solid #ffffff;}

#tab1:checked ~ #content1,
#tab2:checked ~ #content2,
#tab3:checked ~ #content3,
#tab4:checked ~ #content4 {
    display: block;}
    
</style>
<script type="text/javascript">
</script>
</head>
<body>
<script>
if(${a } == 0){
	alert("            😥 죄송합니다만 이 날짜는 빈방이 없어요    😥\n            😍그 대신 다른 날짜의 방들을 보여드릴께요 😍")
}
</script>
    <input id="tab1" type="button" name="tab1" onclick="location.href='${pageContext.request.contextPath}/highPrice.do'">
    <label for="tab1">높은가격순</label>

    <input id="tab2" type="button" name="tab2" onclick="location.href='${pageContext.request.contextPath}/lowPrice.do'">
    <label for="tab2">낮은가격순</label>

    <input id="tab3" type="button" name="tab3">
    <label for="tab3">평점순</label>
    
		<div class="fixed_img_col">
				<ul id="roomlist">
			<c:forEach items="${hosts }" var="host" varStatus="i">
					<li>
					<a href="./hostDetail.do?room_num=${host.room_num }&room_name=${host.room_name}"> 
						<span class="thumb">
							<img id="img" name="img"  alt="왜아무것도안나오지" src="${pageContext.request.contextPath}/img/${host.pic }" style="padding:20px;" >
						</span> 
					 </a>
						<span><b>${host.room_name }</b></span>
						<p>₩ ${host.room_price } /박</p>
						<p>${host.room_checkin } ${host.room_checkout }</p>
					</li>
			</c:forEach>
				</ul>
		</div>
</body>
</html>