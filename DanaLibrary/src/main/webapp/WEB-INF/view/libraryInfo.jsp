<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./layout/header1.jsp"%>
<%@ include file="./layout/header2.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/libraryInfo.css">

<div class="container">
	<h3>다나 도서관 이용안내</h3>
	<hr class="my-4">

	<div class="container-box my-4">
		<div class="container-left mb-4">
			<h4>▶ 다나 도서관 메인 페이지</h4>
			<p>
				1. 최근 공지사항 다섯개를 확인할 수 있습니다.<br>2. 다른 회원들이 남긴 게시글 다섯개를 볼 수 있습니다.<br>3.
				도서관의 추천 전자책 10권을 볼 수 있습니다.
			</p>
		</div>

		<div class="container-right mb-4">
			<div id="carouselExampleIndicators1" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/image/libraryInfo/main-board.png" class="d-block w-100"
							alt="...">
					</div>
					<div class="carousel-item">
						<img src="/image/main-recBook.png" class="d-block w-100" alt="...">
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container-box my-4">
		<div class="container-left mb-4">
			<h4>▶ 전체 도서 목록 및 인기 도서 목록</h4>
			<p>
				1. 도서 카테고리 및 검색어를 통해 도서 검색이 가능합니다.<br>2. 도서 이미지, 제목, 상세보기 버튼을
				통해 도서의 상세정보 페이지로 넘어갈 수 있습니다.<br>3. 도서 대출 및 반납이 가능합니다.<br>4.
				이미 대출중인 도서의 예약 및 예약 취소가 가능합니다.<br>5. 마음에 드는 도서의 관심도서 등록이 가능합니다.
			</p>
		</div>

		<div class="container-right mb-4">
			<div id="carouselExampleIndicators2" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/image/libraryInfo/bookList-1.png" class="d-block w-100"
							alt="...">
					</div>
					<div class="carousel-item">
						<img src="/image/libraryInfo/bookList-2.png" class="d-block w-100"
							alt="...">
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container-box my-4">
		<div class="container-left mb-4">
			<h4>▶ 나의 도서관</h4>
			<p>
				1. 현재 대출중인 도서 목록, 반납예정일, 예약 도서의 리스트를 확인할 수 있습니다.<br>2. 도서 반납,
				예약 취소 및 연장이 가능합니다. 단, 다른 회원이 예약중인 경우 연장이 불가하며, 연장은 최대 1회까지 가능합니다.<br>3.
				지난 대출 목록 및 대출 날짜를 확인할 수 있습니다<br>4. 관심 도서 목록 확인 및 관심 도서 등록 취소가
				가능합니다.<br>5. 희망도서 신청이 가능합니다. 희망도서 신청 리스트를 통해 이미 신청된 도서와 진행상태를
				확인해 주세요.<br>6. 나의 개인정보 확인 및 수정이 가능합니다.<br>7. 나의 게시글 리스트를 볼
				수 있습니다.
			</p>
		</div>

		<div class="container-right mb-4">
			<div id="carouselExampleIndicators3" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators3"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators3"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators3"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators3"
						data-bs-slide-to="3" aria-label="Slide 4"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators3"
						data-bs-slide-to="4" aria-label="Slide 5"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators3"
						data-bs-slide-to="5" aria-label="Slide 6"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators3"
						data-bs-slide-to="6" aria-label="Slide 7"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/image/libraryInfo/myPage-1.png" class="d-block w-100"
							alt="Slide 1">
					</div>
					<div class="carousel-item">
						<img src="/image/libraryInfo/myPage-2.png" class="d-block w-100"
							alt="Slide 2">
					</div>
					<div class="carousel-item">
						<img src="/image/libraryInfo/myPage-3.png" class="d-block w-100"
							alt="Slide 3">
					</div>
					<div class="carousel-item">
						<img src="/image/libraryInfo/myPage-4.png" class="d-block w-100"
							alt="Slide 4">
					</div>
					<div class="carousel-item">
						<img src="/image/libraryInfo/myPage-5.png" class="d-block w-100"
							alt="Slide 5">
					</div>
					<div class="carousel-item">
						<img src="/image/libraryInfo/myPage-6.png" class="d-block w-100"
							alt="Slide 6">
					</div>
					<div class="carousel-item">
						<img src="/image/libraryInfo/myPage-7.png" class="d-block w-100"
							alt="Slide 7">
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="container-box my-4">
		<div class="container-left mb-4">
			<h4>▶ 열린 마당</h4>
			<p>
				1. 질문 및 자유글 등록이 가능합니다.<br>2. 다른 회원이 남긴 게시글 및 관리자의 공지글을 확인할 수
				있습니다.<br>3. 게시글 카테고리 및 검색어를 통해 게시글 검색이 가능합니다.<br>4. 게시글 추천
				및 댓글 달기가 가능합니다.<br>5. 질문글의 경우 도서관 관리자만 답글을 달 수 있습니다.<br>6.
				게시글 및 댓글 삭제는 작성자만 할 수 있습니다.
			</p>
		</div>

		<div class="container-right mb-4">
			<div id="carouselExampleIndicators4" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators3"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators3"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators3"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/image/libraryInfo/boardList-1.png"
							class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="/image/libraryInfo/boardList-2.png"
							class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="/image/libraryInfo/boardList-3.png"
							class="d-block w-100" alt="...">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="./layout/footer.jsp"%>