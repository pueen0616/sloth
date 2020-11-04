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
<!-- 탭 로고 <link rel="shortcut icon" sizes="76x76" type="image/x-icon"
	href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>
	
      <header>
		<jsp:include page="/mainPage/mainMenu.jsp"></jsp:include>
	<section>
      <form name="searchForm" action ="search.do">
         <div class="search__box">
            <table>               
                  <td colspan="2" class="search__sub__title">목적지</td>
                  <td colspan="2"><select class="search__input" id="room_address" name="room_address">
                        <option>대구</option>
                        <option>사울</option>
                        <option>부샹</option>
                  </select></td>
                  <td class="search__sub__title">체크인</td>
                  <td><input class="search__input" type="date" id="room_checkin" name="room_checkin" /></td>
                  <td class="search__sub__title">체크아웃</td>
                  <td><input class="search__input" type="date" id="room_checkout" name="room_checkout"/></td>
                  <td colspan="2" class="search__sub__title"></td>
                  <td colspan="2"><select class="search__input" id="room_max" name="room_max">
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                  </select></td>
               </tr>
            </table>
            <div class="search__button">
               <button>검색</button>
            </div>
         </div>
         </form>
      </section>
	</header>

</body>

</html>