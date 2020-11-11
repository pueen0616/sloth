<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.filebox label {
	display: inline-block;
	padding: .5em .75em;
	color: #999;
	font-size: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #fdfdfd;
	cursor: pointer;
	border: 1px solid #ebebeb;
	border-bottom-color: #e2e2e2;
	border-radius: .25em;
}

.filebox input[type="file"] { /* 파일 필드 숨기기 */
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}

.img1 {
	padding: 3px;
	width: 200px;
	height: 200px;
}
</style>
<script>
	function setThumbnail(event) {
		var reader = new FileReader();
		reader.onload = function(event) {
			var img = document.createElement("img");
			img.setAttribute("src", event.target.result);
			img.className = "img1"
			document.querySelector("#modal-body2").appendChild(img);
		};
		reader.readAsDataURL(event.target.files[0]);
	}

	var room_num;
	$(function() {

		$(".btn-pic").on("click", function() {
			room_num = $(this).data("num");
			frmload.room_num.value = room_num;
		});
		$("#picupdate").on("show.bs.modal", function() {
			$(".modal-body").load("picupdate.do?room_num=" + room_num);
		});

		$("#picdelete").on("click", function() {
			$.ajax("picdelete.do", {
				data : $("#frm1").serialize(),
				success : function(result) {
					if (result == "OK") {
						alert("삭제되었습니다.");
						var chk = $("[name='picchk']:checked");
						for (var i = 0; i < chk.length; i++) {
							$(chk[i]).next().remove(); //이미지
							$(chk[i]).remove(); //체크박스
						}
					} else {
						alert("실패");
					}
				}
			});
		});

	});
	function fn_submit() {
		var form = new FormData(frmload);
		//for (var i = 0; i < $("#picupload")[0].files.length; i++)
		//	form.append("img3", $("#picupload")[0].files[i]);

		$.ajax({
			url : "picupload.do",
			type : "POST",
			processData : false,
			contentType : false,
			data : form,
			success : function(response) {
				alert("성공하였습니다.");
				console.log(response);
			},
			error : function(jqXHR) {
				alert(jqXHR.responseText);
			}
		});
	}
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
				<div class="modal-body" id="modal-body2"></div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>


					<form id="frmload" name="frmload" action="picupload.do"
						method="post" enctype="multipart/form-data">
						<input type="hidden" name="room_num" value="">
						<div class="filebox">
							<label for="picupload">업로드</label> <input type="file"
								id="picupload" name="picupload" multiple
								onchange="setThumbnail(event);">
						</div>
						<button type="button" class="btn btn-primary"
							onclick="fn_submit()">저장</button>
					</form>
					<button type="button" class="btn btn-primary" id="picdelete">삭제</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>