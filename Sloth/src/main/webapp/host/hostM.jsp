<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<table class="table table-bordered table-dark">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">숙소</th>
      <th scope="col">장소</th>
      <th scope="col">가격</th>
      <th scope="col">인원</th>
      <th scope="col">®</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${hostM}" var="hostM" varStatus="i">
    <tr>
      <th scope="row"></th>
      <td>${hostM.pic}, ${hostM.name }</td>
      <td>${hostM.room_name}</td>
      <td>${hostM.room_address}</td>
      <td>${hostM.room_price}</td>
      <td>${hostM.room_max}</td>
      <td><button type="button" class="btn btn-light">수정</button></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>