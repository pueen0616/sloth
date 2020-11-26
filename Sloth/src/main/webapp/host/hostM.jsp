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
	margin-top: 30px;
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

.filebox {
	float: left;
	padding-right: 600px;
}

.img1 {
	padding: 3px;
	width: 200px;
	height: 200px;
}
</style>
<script>


function delHost(){
	if (confirm("정말 삭제하시겠습니까??") == true){    //확인
	
	    document.removefrm.submit();
	
	}else{   //취소
	
	    return false;
	}
}
function setThumbnail(event) {
    var sel_files = [];
    var files = event.target.files;
    var filesArr = Array.prototype.slice.call(files);
    filesArr.forEach(function(f){
       console.log(f.type);
       if(f.type.match('image/JPEG') || f.type.match('image/PNG')|| f.type.match('image/jpg')){
          alert("파일확장자를 바꿔주세요.");
          return;
       }
       sel_files.push(f);
       
    var reader = new FileReader();
    reader.onload = function(event) {
       var img = document.createElement("img");
       img.setAttribute("src", event.target.result);
       img.className = "img1"
       document.querySelector("#modal-body2").appendChild(img);
    };
    reader.readAsDataURL(f);
    });      
 }

	var room_num;
	$(function() {

		$(".btn-pic").on("click", function() {
			room_num = $(this).data("num");
			frmload.room_num.value = room_num;
		});
		$("#picupdate").on("show.bs.modal", function() {
			$("#modal-body2").load("picupdate.do?room_num=" + room_num);
		});
		
		$(".btn-reserlist").on("click", function() {
			room_num = $(this).data("num1");
		});
		$("#reserlist").on("show.bs.modal", function() {
			$("#modal-body3").load("hostMreserList.do?room_num=" + room_num);
		});
		$("#picdelete").on("click", function() {
			$.ajax("picdelete.do", {
				data : $("#frm3").serialize(),
				success : function(result) {
					if (result == "OK") {
						var chk = $("[name='pic_num']:checked");
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
		$("#mainpic").on("click", function() {
			$.ajax("mainpic.do", {
				data : $("#frm3").serialize(),
				success : function(result) {
					if (result == "OK") {
						alert("성공");
						location.reload();
					} 
				}, error : function(jqXHR) {
					alert(jqXHR.responseText);
				}
			});
		});
		
		$(document).on("click",".roomdel",function(){
	         var roomNum = $(this).closest('td').find('#roomnum1').val();
	      if(confirm("정말 삭제 하시겠습니까?")){
	         $.ajax("roomdel.do", {
	            data:{
	               "room_num" : roomNum
	            }, 
	            success : function(result){
	                if(result==1){
	                       $("td[class='bbb']").remove();
	                         location.reload();
	                }else{
	                   alert("예약자가 이미 있습니다.")   
	                }
	                }
	                })//여기까지맞음 ajax end
	      }else{return false;}
	            });//click function end 
	      });//end of function
	      
	function fn_submit() {
		var form = new FormData(frmload);
		
		$.ajax({
			url : "picupload.do",
			type : "POST",
			processData : false,
			contentType : false,
			data : form,
			success : function(response) {
				$("#modal-body2").load("picupdate.do?room_num=" +frmload.room_num.value);
				frmload.reset();
			},
			error : function(jqXHR) {
				alert(jqXHR.responseText);
			}
		});
	}
</script>
</head>
<body>
	<table class="table table-bordered table-hovers">
		<thead>
			<tr>
				<th scope="col" style="padding: 5px; text-align: center;">숙소</th>
				<th scope="col" style="padding: 10px; text-align: center;">이름</th>
				<th scope="col" style="padding: 10px; text-align: center;">장소</th>
				<th scope="col" style="padding: 10px; text-align: center;">가격</th>
				<th scope="col" style="padding: 10px; text-align: center;">인원</th>
				<th scope="col" style="padding: 10px; text-align: center;">수정/삭제</th>
				<th scope="col" style="padding: 5px; text-align: center;">예약 현황</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${hostM}" var="host" varStatus="i">
				<tr>
					<td class='bbb' style="padding: 10px; text-align: center;"><img
						style="width: 300px; height: 200px;" alt="null"
						src="${pageContext.request.contextPath}/img/${host.pic }">
						
						<button type="button" class="btn btn-light btn-pic"
							data-toggle="modal" data-num="${host.room_num }"
							data-target="#picupdate"><i class="fab fa-sistrix"></i></button></td>
							
							
							
					<td class='bbb' style="padding: 60px; text-align: center;">${host.room_name}</td>
					<td class='bbb' style="padding: 60px; text-align: center;">${host.room_address}</td>
					<td class='bbb' style="padding: 60px; text-align: center;">${host.room_price}</td>
					<td class='bbb' style="padding: 60px; text-align: center;">${host.room_max}</td>
					<td class='bbb' style="padding: 60px; text-align: center;">
						<button type="button" class="btn btn-light"
							onclick="location.href='hostmUpdateForm.do?room_num=${host.room_num }'">수정</button>
							
						<button type="button" class="btn btn-light roomdel">삭제</button>
						<input type="hidden" name="roomnum1" id="roomnum1" value="${host.room_num }">
						</td>
						
						<td class='bbb' style="padding: 60px; text-align: center;">
						<button type="button" class="btn btn-light btn-reserlist"
							data-toggle="modal" data-num1="${host.room_num }"
							data-target="#reserlist"><i class="fas fa-align-justify"></i></button>
						</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- 사진 수정 -->
	<div class="modal fade" id="picupdate" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">사진 목록</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" id="modal-body2" multiple></div>

				<div class="modal-footer" >
					<form id="frmload" name="frmload" action="picupload.do"
						method="post" enctype="multipart/form-data">
						<input type="hidden" name="room_num" value="">
						<div class="filebox">
							<label for="picupload" >업로드</label> <input
								type="file" id="picupload" name="picupload" multiple
								onchange="setThumbnail(event);">
						</div>
						<button type="button" class="btn btn-light"  onclick="fn_submit()">저장</button>
					</form>
					
				<span><button type="button" class="btn btn-light" id="picdelete">삭제</button></span> 
				<span><button type="button"	class="btn btn-light" id="mainpic">대표사진</button></span>
				</div>
			</div>
		</div>
	</div>
	<hr>
	
	
	<!-- 예약자 리스트 -->
	<div class="modal fade" id="reserlist" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
					
				<div class="modal-body" id="modal-body3" >
				<h2 >예약자 리스트</h2>
				</div>
				</div>
			</div>
		</div>
</body>
</html>
</span>