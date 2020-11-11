<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<form id="frm1" name="frm1" action="picdelete.do" method="post">
	<div id="ddd">
		<c:forEach items="${piclist}" var="list">
			<input type="checkbox" name="picchk"
				style="width: 38px; height: 38px;">
			<img class="img1"  id="img3"
				name="img3"
				src="${pageContext.request.contextPath}/img/${list.pic }">
			<input type="hidden" id="pic_num" name="pic_num"
				value="${list.pic_num}" readonly>
		</c:forEach>
	</div>
</form>


