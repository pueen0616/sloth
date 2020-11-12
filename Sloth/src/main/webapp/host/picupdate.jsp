<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<form id="frm3" name="frm3" action="picdelete.do" method="post">
	<c:forEach items="${piclist}" var="list">
		<input type="checkbox" name="pic_num" value="${list.pic_num}"
			style="width: 38px; height: 38px;">
		<img class="img1" id="img3" name="img3"
			src="${pageContext.request.contextPath}/img/${list.pic }">
	</c:forEach>
	<input type="hidden" name ="room_num" value="${hostM.room_num }">
</form>


