<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본정보수정</title>
</head>
<body>
회원 정보 수정
   <div>
      <form id="frm" name="frm" action="AccountUpdate.do" method="post">
         <table border="1">
            <tr>
               <th width="150">아이디</th>
               <td width = "500"><input type="text" id="id" name="id" value="${id}" readonly></td>
            </tr>
            <tr>
               <th width="150">패스워드</th>
               <td><input type="password" id="password" name="password" value="${user.password}"></td>
            </tr>
            <tr>
               <th width="150">이름</th>
               <td><input type="text" id="name" name="name" value="${user.name}"></td>
            </tr>
            <tr>
               <th width="150">생일</th>
               <td><input type="text" id="birth" name="birth" value="${user.birth}" readonly></td>
            </tr>
            <tr>
               <th width="150">전화번호</th>
               <td><input type="text" id="tel" name="tel" value="${user.tel }" ></td>
            </tr>
            <tr>
               <th width="150">이메일</th>
               <td><input type="text" id="email" name="email" value="${user.email}"></td>
            </tr>
            <tr>
               <td colspan="2" align="center">
                  <input type="submit" value="수정하기"> &nbsp;&nbsp;
                  <input type="submit" value="탈퇴하기" onclick="location.href='deleteAccountAction.do'">
                  <input type="reset" value="취소">
               </td>
            </tr>
         </table>
      </form>
   </div>
<script>

</script>

</body>
</html>