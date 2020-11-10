<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/mainPage/css/style.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- 필요한 CSS, JS 로드 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/mainPage/css/menu.css">
	
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
      <header>
		<jsp:include page="/mainPage/mainMenu.jsp"></jsp:include>
	<section>
      <form name="searchForm" action ="search.do">
         <div class="search__box">
            <table>               
                  <td colspan="2" class="search__sub__title" align="center">목적지</td>
                  <td colspan="2">
                  <select class="search__input" id="room_address" name="room_address">
                        <option>대구</option>
                        <option>사울</option>
                        <option>부샹</option>
                  </select></td>
               
                  <td class="search__sub__title" align="center">체크인</td>             
                  <td><input class="search__input" type="date" id="room_checkin" name="room_checkin"/></td>
                  <td class="search__sub__title" align="center">체크아웃</td>
                  <td><input class="search__input" type="date" id="room_checkout" name="room_checkout"/></td>
                  <td colspan="2" class="search__sub__title"></td>
                  <td class="search__sub__title" align="center">인원수</td>
                  <td colspan="2">
                  <select class="search__input" id="room_max" name="room_max">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                  </select></td>
               </tr>
            </table>
            <div class="search__button">
               <button type="submit">검색</button>
            </div>
         </div>
         </form>
      </section>
	</header>

</body>

</html>