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
<!--             <th width="100">숙소번호</th> -->
            <th width="100">이름</th>
            <th width="200">주   소</th>
            <th width="150">최대인원</th>
            <th width="150">가격</th>
<!--             <th width="100">체크인</th> -->
<!--             <th width="100">체크아웃</th> -->
<!--             <th width="100">info</th> -->
<!--             <th width="100">아이디</th> -->
<!--             <th width="100">위치</th> -->
<!--             <th width="100">사진번호</th> -->
            <th width="100">사진</th>
<!--             <th width="100">대표사진</th> -->
            
         </tr>
         <c:forEach var="host" items="${hosts }">
            <tr>
<%--                <td>${host.lroom_num }</td> --%>
               <td>${host.lroom_name }</td>
               <td>${host.lroom_address }</td>
               <td>${host.lroom_max }</td>
               <td>${host.lprice }</td>
<%--                <td>${host.lroom_checkin}</td> --%>
<%--                <td>${host.lroom_checkout }</td> --%>
<%--                <td>${host.lroom_info }</td> --%>
<%--                <td>${host.lid }</td> --%>
<%--                <td>${host.llocation }</td> --%>
<%--                <td>${host.lpic_num }</td> --%>
               <td><img src="${pageContext.request.contextPath}/img/${host.lpic }"></td>
<%--                <td><img src="${pageContext.request.contextPath}/img/${host.lfirst_yn }"></td> --%>
            </tr>
         </c:forEach>
      </table>
      
   </div>
</div>
</body>
</html>