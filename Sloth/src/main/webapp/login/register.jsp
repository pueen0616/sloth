<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>회 원 가 입</h1></div>
	<div>
		<form id="frm" name="frm" action="${pageContext.request.contextPath}/register.do" method="post">
			<table border="1">
				<tr>
					<th width="150">아이디</th>
					<td width = "500"><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<th width="150">패스워드</th>
					<td><input type="password" id="password" name="password"></td>
				</tr>
				<tr>
					<th width="150">이름</th>
					<td><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
					<th width="150">생일</th>
					<td><input type="text" id="tel" name="tel" ></td>
				</tr>
				<tr>
					<th width="150">전화번호</th>
					<td><input type="text" id="tel" name="tel" ></td>
				</tr>
				<tr>
					<th width="150">이메일</th>
					<td><input type="text" id="email" name="email"></td>
				</tr>
				<tr>
					<th width="150">권한</th>
					<td><input type="text" id="admin" name="admin"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="가입하기"> &nbsp;&nbsp;
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</div>

</div>
</body>
</html>