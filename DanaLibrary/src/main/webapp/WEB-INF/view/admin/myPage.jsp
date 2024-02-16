<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/myPage.css">

<div class="container-page">
	<div class="container-page-content">
		<div class="myPage-title">
			<img class="myPage-icon" src="/image/icon/myPage-icon.png">
			<h5>
				<strong>나의 도서관</strong>
			</h5>
		</div>

		<div class="container-tab">
			<div class="tab">
				<button class="tablinks" onclick="openMenu(event, 'currentRent')">현재
					대출 도서</button>
				<button class="tablinks" onclick="openMenu(event, 'pastRent')">지난
					대출 도서</button>
				<button class="tablinks" onclick="openMenu(event, 'interestedBook')">관심
					도서</button>
				<button class="tablinks" onclick="openMenu(event, 'requestInfo')">도서
					신청</button>
				<button class="tablinks" onclick="openMenu(event, 'myInfo')">나의
					정보</button>
				<button class="tablinks" onclick="openMenu(event, 'boardInfo')">나의
					게시글</button>
			</div>

				<div id="home" class="tabcontent"></div>

				<div id="currentRent" class="tabcontent">
					<%@ include file="myPage/currentRent.jsp"%>
				</div>

				<div id="pastRent" class="tabcontent">
					<%@ include file="myPage/pastRent.jsp"%>
				</div>

				<div id="interestedBook" class="tabcontent">
					<%@ include file="myPage/interestedBook.jsp"%>
				</div>

				<div id="requestInfo" class="tabcontent">
					<%@ include file="myPage/bookRequest.jsp" %>
				</div>

				<div id="myInfo" class="tabcontent">
					<%@ include file="myPage/myInfo.jsp"%>
				</div>

				<div id="boardInfo" class="tabcontent">
					<%@ include file="myPage/myBoard.jsp" %>
				</div>

			</div>
		</div>
	</div>

	<script>
		function openMenu(evt, menu) {
			var i, tabcontent, tablinks;

			// 모든 탭 컨텐츠 감추기
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}

			// 모든 버튼에서 "active" 클래스 제거
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].classList.remove("active");
			}

			// 선택된 도시의 컨텐츠 표시 및 해당 버튼에 "active" 클래스 추가
			document.getElementById(menu).style.display = "flex";
			evt.currentTarget.classList.add("active");
		}
	</script>

	<script src="/js/book/renewalRent.js"></script>
	<script src="/js/book/book2.js"></script>
	<script src="/js/admin/myPage.js"></script>
	<%@ include file="../layout/footer.jsp"%>