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
<c:if test="${pw ne null}">
      <div>
         비밀번호 : <input type="text" id="fipw" name ="fipw" value="${pw}" readonly>
      </div><br>
      <button class="btn btn-primary" type="reset" value="취소"
            onclick="location.reload()">확인</button>
   </c:if>
   <c:if test="${pw eq null}">
      <div>
      <b> 존재하지 않는 사용자입니다</b>
      </div><br>
      <button class="btn btn-primary" type="reset" value="취소"
            onclick="location.reload()">확인</button>
   </c:if>
</body>
</html>