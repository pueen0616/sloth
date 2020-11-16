<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"> --%>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">	
</script>
<style>
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
ul#roomlist li {
list-style:none; 
display:inline-block;
 margin: 0 0 0 0;
    padding: 0 0 0 0;
    border : 0;
    
}
</style>
<script type="text/javascript">
</script>
<script>
if(${a } == 0){
	alert("            😥 죄송합니다만 이 날짜는 빈방이 없어요    😥\n            😍그 대신 다른 날짜의 방들을 보여드릴께요 😍")
}
</script>
</head>
<body>
	
    <input id="tab1" type="button" name="tab1" onclick="location.href='${pageContext.request.contextPath}/highPrice.do'">
    <label for="tab1">높은가격순</label>

    <input id="tab2" type="button" name="tab2" onclick="location.href='${pageContext.request.contextPath}/lowPrice.do'">
    <label for="tab2">낮은가격순</label>

    <input id="tab3" type="button" name="tab3">
    <label for="tab3">평점순</label>
    
		<div class="fixed_img_col">
				<ul id="roomlist">
			<c:forEach items="${hosts }" var="host" varStatus="i">
					<li style="padding: 30px"><a href="./hostDetail.do?room_num=${host.room_num }&room_name=${host.room_name}"> 
						<div class="img-box" ">
							<img id="img" name="img"  alt="왜아무것도안나오지" src="${pageContext.request.contextPath}/img/${host.pic }" style="border-radius : 2px; width:400px; height:300px;"  >
						</div> 
					 	</a>
						<div style="padding: 20px" ><b>${host.room_name }</b>	
							<p>₩ ${host.room_price } /박</p>
							<p>${host.room_checkin } ${host.room_checkout }</p>
						</div>
					</li>
			</c:forEach>
				</ul>
		</div>
</body>
</html>