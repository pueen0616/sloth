<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
	var room_num;
	$(function() {

		$(".btn-pic").on("click", function() {
			room_num = $(this).data("num");
		});
		$("#picupdate").on("show.bs.modal", function() {
			$(".modal-body").load("picupdate.do?room_num=" + room_num);
		});
		
		$("#picdelete").on("click", function(){
			$.ajax("picdelete.do",{
				data:$("#frm1").serialize(),
				success : function(result){
					  if (result=="OK") {
						 alert("삭제되었습니다.");
						 var chk= $("[name='picchk']:checked");
						for(var i=0; i<chk.length; i++){
							$(chk[i]).next().remove(); //이미지
							$(chk[i]).remove();  //체크박스
						}
			            } else{
			                alert("실패");
			            }
					}
				});
			});
	});
</script>
</head>
<body>
	<table class="table table-bordered table-dark">
		<thead>
			<tr>
				<th scope="col">숙소</th>
				<th scope="col">장소</th>
				<th scope="col">이름</th>
				<th scope="col">가격</th>
				<th scope="col">인원</th>
				<th scope="col">®</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${hostM}" var="host" varStatus="i">
				<tr>
					<td><img style="width: 200px; height: 200px;" alt="null"
						src="${pageContext.request.contextPath}/img/${host.pic }">
						<button type="button" class="btn btn-primary btn-pic"
							data-toggle="modal" data-num="${host.room_num }"
							data-target="#picupdate">사진 수정</button></td>
					<td>${host.room_name}</td>
					<td>${host.room_address}</td>
					<td>${host.room_price}</td>
					<td>${host.room_max}</td>
					<td>
						<button type="button" class="btn btn-light"
							onclick="location.href='hostmUpdateForm.do?room_num=${host.room_num }'">수정</button>
						<button type="button" class="btn btn-light">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="modal fade" id="picupdate" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">사진수정</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body"></div>
				
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="picupdate" onclick="location.href='#'">추가</button>
					<button type="button" class="btn btn-primary" id="picdelete">삭제</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>