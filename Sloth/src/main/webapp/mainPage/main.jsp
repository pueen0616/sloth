<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="mainPage/css/style.css">
    <link rel="shortcut icon" sizes="76x76" type="image/x-icon"
        href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">
    <script src="http://code.jquery.com/jquery-1.7.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
   
</head>

<body>
    <header>
  	   <nav>     
            <div class="logo">
                    <img src="logo/logo.png" width="250px">
            </div>
            <div class="menu">
                <ul>
                    <li><a href="#">호스트가 되기</a></li>
                    <li><a href="loginForm.do">로그인</a></li>
                    <li><a href="#">계정</a></li>
                    <li><a href="#">게시판</a></li>
                    <li><a href="#">예약관리</a></li>
                    <li><a href="#">숙소관리</a></li>
                    <li><a href="#">관심숙소</a></li>
                    <li><a href="#">로그아웃</a></li>
                </ul>
            </div>
        </nav> 
        <section>
            <div class="search__box">
                <div class="search__title">특색 있는 숙소와 즐길<br /> 거리를 예약하세요.</div>
                <table>
                    <tr>
                        <td colspan="2" class="search__sub__title">목적지</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input class="search__input" type="text" placeholder=" 모든 위치"></td>
                    </tr>
                    <tr>
                        <td class="search__sub__title">체크인</td>
                        <td class="search__sub__title">체크아웃</td>
                    </tr>
                    <tr>
                        <td><input class="search__input"  type="date" /></td>
                        <td><input class="search__input"  type="date" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="search__sub__title">인원</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select class="search__input" >
                                <option>인원</option>
                                
                            </select>
                        </td>
                    </tr>
                </table>
                <div class="search__button"><button>검색</button></div>
            </div>
        </section>
    </header>
</body>

</html>