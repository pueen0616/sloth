<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
console.log("되제");
</script>
<div align="center">
   <div><h1>숙박지 리스트</h1></div>
   <div>
      <table border="1">
         <tr>
            <th width="100">숙소번호</th>
            <th width="100">이름</th>
            <th width="200">주   소</th>
            <th width="150">최대인원</th>
            <th width="150">가격</th>
            <th width="100">체크인</th>
            <th width="100">체크아웃</th>
            <th width="100">info</th>
            <th width="100">아이디</th>
            <th width="100">위치</th>
         </tr>
         <c:forEach var="host" items="${hosts }">
            <tr>
               <td>${host.roomNum }</td>
               <td>${host.roomName }</td>
               <td>${host.roomAddress }</td>
               <td>${host.roomMax }</td>
               <td>${host.roomPrice }</td>
               <td>${host.roomCheckIn}</td>
               <td>${host.roomCheckOut }</td>
               <td>${host.roomInfo }</td>
               <td>${host.id }</td>
               <td>${host.location }</td>
            </tr>
         </c:forEach>
      </table>
      
   </div>
</div>
</body>
</html>