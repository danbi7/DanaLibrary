<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>

<!DOCTYPE html>
<html>
<head>

<style>

/* Style the tab */
.tab {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f2f2f2;
	margin-top: 10px;
}

.tab button {
	background-color: inherit;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 0; /* 필요에 따라 패딩 조절 */
	transition: 0.3s;
	font-size: 17px;
	width: 16.66%; /* 버튼의 너비를 100%를 버튼의 개수로 나눈 값으로 설정 */
	box-sizing: border-box;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 0; /* 필요에 따라 패딩 조절 */
	transition: 0.3s; /* 패딩과 테두리를 너비에 포함시킴 */
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
	display: none;
}

#home {
	display: flex;
}

.table-responsive {
	display: block;
	width: 100%;
	overflow-x: auto;
	-webkit-overflow-scrolling: touch;
	-ms-overflow-style: -ms-autohiding-scrollbar;
}


.table-bordered {
	border: 1px solid #dee2e6;
}

.table {
	width: 100%;
	margin-bottom: 1rem;
}

table {
	border-collapse: collapse;
}

.card-title h5 {
	margin-bottom: 15px;
}
.admin-title{
	margin-top: 20px;
	margin-bottom: 10px;
	margin-left: 15px;
}

.admin-icon{
float:left;
width: 30px;
margin-bottom: 15px;
margin-right: 10px;
}

.admin-edit{
display: flex;
justify-content: space-around;
}

.edit-btn{
width:20px;
}
.delete-btn{
width:20px;
}


</style>
</head>
<body>

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
				
<<<<<<< HEAD
=======
					<p>dd<p>
					
>>>>>>> 0c3070f2b3cd84c61e56737901619ab8d94e2dc8
				</div>

				<div id="userManage" class="tabcontent">
					
					<%@ include file="userManage.jsp"%>
					
				</div>

				<div id="rentManage" class="tabcontent">
					<%@ include file="rentManage.jsp"%>
				</div>

				<div id="reserveManage" class="tabcontent">
					<h3>예약 정보 내용</h3>
				</div>

				<div id="bookManage" class="tabcontent">
				<%@ include file="bookManage.jsp"%>
				</div>

				<div id="boardManage" class="tabcontent">
					<%@ include file="boardManage.jsp"%>
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
</body>
</html>

<%@ include file="../layout/footer.jsp"%>

