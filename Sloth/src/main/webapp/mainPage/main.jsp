<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="shortcut icon" sizes="76x76" type="image/x-icon"
        href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">
</head>

<body>
	<!-- 검색란 -->
    <header>
        <nav>
            <div class="logo">
                <svg viewBox="0 0 1000 1000" role="presentation" aria-hidden="true" focusable="false"
                    style="height: 1em; width: 1em; display: inline-block; fill: currentcolor;">
                    <path
                        d="m499.3 736.7c-51-64-81-120.1-91-168.1-10-39-6-70 11-93 18-27 45-40 80-40s62 13 80 40c17 23 21 54 11 93-11 49-41 105-91 168.1zm362.2 43c-7 47-39 86-83 105-85 37-169.1-22-241.1-102 119.1-149.1 141.1-265.1 90-340.2-30-43-73-64-128.1-64-111 0-172.1 94-148.1 203.1 14 59 51 126.1 110 201.1-37 41-72 70-103 88-24 13-47 21-69 23-101 15-180.1-83-144.1-184.1 5-13 15-37 32-74l1-2c55-120.1 122.1-256.1 199.1-407.2l2-5 22-42c17-31 24-45 51-62 13-8 29-12 47-12 36 0 64 21 76 38 6 9 13 21 22 36l21 41 3 6c77 151.1 144.1 287.1 199.1 407.2l1 1 20 46 12 29c9.2 23.1 11.2 46.1 8.2 70.1zm46-90.1c-7-22-19-48-34-79v-1c-71-151.1-137.1-287.1-200.1-409.2l-4-6c-45-92-77-147.1-170.1-147.1-92 0-131.1 64-171.1 147.1l-3 6c-63 122.1-129.1 258.1-200.1 409.2v2l-21 46c-8 19-12 29-13 32-51 140.1 54 263.1 181.1 263.1 1 0 5 0 10-1h14c66-8 134.1-50 203.1-125.1 69 75 137.1 117.1 203.1 125.1h14c5 1 9 1 10 1 127.1.1 232.1-123 181.1-263.1z">
                    </path>
                </svg>
            </div>
            <div class="menu">
                <ul>
                    <li><a href="#">호스트가 되기</a></li>
                    <li><a href="#">로그인</a></li>
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
                        <td colspan="2"><input class="search__input" type="text" placeholder="위치"></td>
                    </tr>
                    <!-- 체크인, 아웃 -->
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
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                                
                            </select>
                        </td>
                    </tr>
                </table>
                <!-- 검색버튼 -->
                <div class="search__button"><button>검색</button></div>
            </div>
        </section>
    </header>
    <!-- 게시판 -->
	<main>
	
	</main>

</body>

</html>