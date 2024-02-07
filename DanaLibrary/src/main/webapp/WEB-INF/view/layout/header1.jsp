<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANA LIBRARY</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
<link href="/webjars/summernote/0.8.10/summernote-bs4.css"
	rel="stylesheet">
<script src="/webjars/summernote/0.8.10/summernote-bs4.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/main.css">
<link rel="stylesheet" type="text/css" href="/css/result.css">
<link rel="stylesheet" type="text/css" href="/css/board.css">
<link rel="stylesheet" type="text/css" href="/css/book.css">
<script>
    function openNotificationWindow() {
        window.open('/view/notice', '_blank', 'width=500,height=300');
    }
</script>


<script>
    // SSE를 지원하는 브라우저에서만 실행되도록 체크
    if (EventSource) {
        const eventSource = new EventSource('/sse/subscribe');

        eventSource.onmessage = function (event) {
            // 이벤트가 발생할 때마다 실행될 코드
            const notificationContainer = document.getElementById('notification-container');
            const notificationNumber = document.getElementById('notification-number');

            // 알림이 있는지 여부에 따라 표시 여부 조절
            if (event.data && event.data.trim() !== "") {
                notificationContainer.innerHTML = `Received notification: ${event.data}`;
                // 알림이 있으면 알림 숫자 표시
                notificationNumber.style.display = 'block';
            } else {
                notificationContainer.innerHTML = ''; // 알림이 없으면 내용 초기화
                // 알림이 없으면 알림 숫자 숨김
                notificationNumber.style.display = 'none';
            }
        };
    } else {
        // SSE를 지원하지 않는 경우에 대한 처리
        console.log('Server-Sent Events (SSE) is not supported.');
    }
</script>

</head>
<body>

	<nav class="py-2 bg-body-tertiary border-bottom sticky-top">
		<div class="container d-flex flex-wrap">
			<ul class="nav me-auto">
				<li class="nav-item firstNav-left"><a href="/"
					onclick="window.location.href='/';" class="nav-link link-dark">
						<img src="/image/dana-removebg-preview.png"
						alt="DANA LIBRARY Logo"> DANA LIBRARY
				</a></li>
			</ul>

			<ul class="nav ms-auto">
				<c:if test="${sessionScope.loginUser != null }">
					<li class="noti-icon"><div class="notification-container">
            		<img src="/image/icon/notification.png" onclick="openNotificationWindow()">
            		
        			<span id="notification-number" class="notification-number">!</span>
    </div></li>

					<li class="nav-item firstNav-right"><a href="/user/logout"
						class="nav-link link-dark px-2">로그아웃</a></li>
				</c:if>
				<c:if test="${sessionScope.loginUser == null }">
					<li class="nav-item firstNav-right"><a href="/user/view/login"
						class="nav-link link-dark px-2">로그인</a></li>
					<li class="nav-item firstNav-right"><a
						href="/user/view/insertUser" class="nav-link link-dark px-2">회원가입</a></li>
				</c:if>
				<li><input type="search" class="form-control"
					placeholder="제목으로 검색하기" aria-label="Search"></li>
				<li><a href="#"><img src="/image/icon/search.png"></a></li>
			</ul>
		</div>
	</nav>
