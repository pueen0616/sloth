<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Blog Post - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/blog-post.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<style>
img{
	width: auto; height: auto;
    max-width: 1000px;
    max-height: 500px;
}
.box{
box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
</style>
<script>

</script>
</head>
<body>
	<main class="images">
		<div class="container" >
			<div id="name" name="name">
				<h1 >영래의 이쁜 집</h1>
			</div>
			<div id="address" name="address">
				<h6>슈퍼 호스트</h6>
				<a href="#">위치입니다</a>
				<button type="button" class="btn btn-outline-secondary" style="float: right;">♡저장</button>
				<button type="button" class="btn btn-outline-secondary" style="float: right;">공유하기</button>
			</div>

			<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/room1.jpeg" class="d-block w-100" alt="ro">
    </div>
    <div class="carousel-item">
      <img src="images/room1.jpeg" class="d-block w-100" alt="ro">
    </div>
    <div class="carousel-item">
      <img src="images/room1.jpeg" class="d-block w-100" alt="ro">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
			<div style="display: flex; height: 1200px;">
				<div class="col-md-8">
					<div style="display: flex;">
						<div>
							<div>
								<h5>Jessi 님이 호스팅하는 아파트 전체</h5>
							</div>
							<div>
								<h6>최대 인원 2명 * 침실 1개 * 욕실 1개</h6>
							</div>
						</div>
						<div class="float-left">
							<a href="#"><i class="far fa-address-book"
								style="font-size: 36px; float: right;"></i></a>
						</div>
					</div>
					<hr>
					<div id="info" name="info">숙소 소개 적는 란입니다 2020년 8월에 신축 오픈한 레지던스 광안 지웰 더테라스입니다. 광안리
						백사장 10초 거리로 코로나 및 대인 접촉 걱정을 덜고 테라스에서 광안대교 바다 및 해변 전망을 내려다보면서 음악과 차
						한잔 할수 있는 최적의 휴양지 입니다 파도와 함께 힐링을 ~~~ 바다위에 자는듯 파도소리를 바로 들을수 있으면며 탁
						트인 시원한 오션뷰를 즐기며 힐링 할 수 있는 최적의 숙소이며, 백사장과 광안대교의 정경이 눈앞에 그림처럼 펼쳐지는
						아름다운 곳입니다. 넷플릭스 설치 및 인테넷 유튜브 시청등 휴식하면서 무제한 영화 및 동영상 등을 시청하실수 있습니다

						광안리 바닷가 해변을 따라 맛집 카페 편의점 등이 즐비하며 숙소 테라스에서 식사하면 맛집이 되고, 커피를 마시면 최고의
						카페가 되는 힐링 장소 입니다. 인근 수영강에서는 낚시도 가능하며 올림픽 요트 경기장, 남천 마리나 선착장에서 요트를
						탈 수도 있습니다. 해외 휴양지 부럽지 않은 오션 파노라마 뷰를 테라스에서 만끽 할수 있습니다. 숙소 실내 공간이
						게스트의 마음을 녹여드릴 것입니다. 거실과 침실에서 바라보는 광안리 바닷가… 더 읽기</div>
				</div>
				<div class="col-md-4">
					<div class="box" style="border: 1px solid; position: fixed; width: 30%; border-radius: 25px; bottom: 10px; ">
						<div style="padding: 20px;">
							<span style="font-size: 20px;">$90,000</span> <span>/박</span> <span
								style="float: right;">★4.84</span>
						</div>
						<div class='row' style="padding: 20px;">
							<input class="search__input" type="date" />체크인 날짜 <input
								class="search__input" type="date" />체크아웃 날짜
							<div class="col-6" style="border: 1px solid;">
								인원 <br>인원수
							</div>
						</div>
						<div align="center">
							<a href="#" class="btn btn-danger btn-lg active" role="button"
								aria-pressed="true">예약하기</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</main>


	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
