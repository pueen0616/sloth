<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/host/css/inputStyle.css">
</head>
<body>
<form id="reIdFrm" >
   <div id="idResultDiv" class="idResultDiv" align="center">
   <c:if test="${id.id ne null}">
      <div>
         아이디 : <input type="text" id="reId" name ="reId" value="${id.id}" readonly>
      </div><br>
      <button class="btn btn-primary" type="reset" value="취소"
            onclick="location.reload()">확인</button>
   </c:if>
   <c:if test="${empty id.id}">
      <div>
      <b> 존재하지 않는 사용자입니다</b>
      </div><br>
      <button class="btn btn-primary" type="reset" value="취소"
            onclick="location.reload()">확인</button>
   </c:if>
   </div>
</form>
</body>
</html>