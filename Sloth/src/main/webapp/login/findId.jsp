<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/host/css/inputStyle.css">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h3>아이디 찾기</h3>
		</div>
		<hr />
			<nav style="height: 120px;">
				<div style="float: left;" class="logo">
					<a href="main.do"><img
						src="${pageContext.request.contextPath}/logo/logo1.png"
						width="100px"></a>
				</div>
			</nav>
			<div class="modal fade" id="sampleModalPopup" role="dialog"
				tabindex="-1">
				<div
					class="modal-dialog modal-dialog-width1000 modal-dialog-height800">
					<div class="modal-header"></div>
					<div class="modal-body">
		<form id="idFrm" name="idFrm" method="post" action="findidresult.do">


						<div class="_s1t1w0" style="margin-bottom: 16px;">이름</div>
						<div style="margin-bottom: 32px;">
							<input type="text" id="uname" name="uname"
								placeholder="이름을 입력하세요">
						</div>

						<div class="_s1t1w0" style="margin-bottom: 16px;">이메일</div>
						<div style="margin-bottom: 32px;">
							<input type="text" id="useremail" name="useremail"
								placeholder="email을 입력하세요">
						</div>
						<button class="btn btn-primary" type="submit" id="findidresult"
							name="findidresult">아이디 찾기</button>

		</form>
					</div>
					<div class="modal-footer">

					</div>
				</div>
			</div>

	</div>
</body>
</html>