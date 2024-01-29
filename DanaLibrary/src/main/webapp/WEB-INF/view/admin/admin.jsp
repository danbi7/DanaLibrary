<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/admin.css">

	<div class="container-page">
		<div class="container-page-content">
			<div class="admin-title"><img class="admin-icon" src="/image/icon/admin-icon.png" ><h5><strong>관리자 페이지</strong></h5></div>

			<div class="container-tab">
				<div class="tab">
					<button class="tablinks" onclick="openMenu(event, 'home')">관리자
						홈</button>
					<button class="tablinks" onclick="openMenu(event, 'userManage')">회원
						정보</button>
					<button class="tablinks" onclick="openMenu(event, 'rentManage')">대출
						정보</button>
					<button class="tablinks" onclick="openMenu(event, 'reserveManage')">예약
						정보</button>
					<button class="tablinks" onclick="openMenu(event, 'bookManage')">도서
						정보</button>
					<button class="tablinks" onclick="openMenu(event, 'boardManage')">게시판</button>
				</div>

				<div id="home" class="tabcontent">
				
					
					
				</div>

				<div id="userManage" class="tabcontent">
					
					<%@ include file="userManage.jsp"%>
					
				</div>

				<div id="rentManage" class="tabcontent">
					<h3>대출 정보 내용</h3>
				</div>

				<div id="reserveManage" class="tabcontent">
					<h3>예약 정보 내용</h3>
				</div>

				<div id="bookManage" class="tabcontent">
					<h3>도서 정보 내용</h3>
				</div>

				<div id="boardManage" class="tabcontent">
					<h3>게시판 내용</h3>
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

<%@ include file="../layout/footer.jsp"%>

