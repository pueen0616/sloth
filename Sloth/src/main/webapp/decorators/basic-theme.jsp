<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<decorator:head/>
<body>
   <h1>Header</h1>
    <p><b>Navigation</b><decorator:title/></p>
    <hr />
    <decorator:body />
    <hr />
    <h1>Footer</b></h1>
</body>
</html>