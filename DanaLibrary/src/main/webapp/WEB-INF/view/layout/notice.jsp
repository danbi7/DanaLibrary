<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>

<div class="container" style="width: 700px; height: 300px; margin-top:50px;">

    <c:choose>
        <c:when test="${not empty notice}">
            <div style="display: flex; justify-content: space-between;">
                <img src="${notice.reserved_book.book.image}" class="img-thumbnail" alt="책 이미지" style="width: 140px; height: 190px;">
                <table class="table" style="width: 70%;">
                    <tbody>
                    <tr>
                        <td colspan="2"><strong>제목 </strong>${notice.reserved_book.book.title}</td>
                    </tr>
                    <tr>
                        <td colspan="2"><strong>저자 </strong> ${notice.reserved_book.book.author}</td>
                    </tr>
                    <tr>
                        <td colspan="2"><strong>출판사 </strong> ${notice.reserved_book.book.publisher}</td>
                    </tr>
                    <tr>
                        <td colspan="2"><strong>분류 </strong>  ${notice.reserved_book.book.category}</td>
                    </tr>
                    <tr>
                        <td colspan="2"><strong>페이지 </strong> ${notice.reserved_book.book.pages}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            
            <button class="btn-rent btn btn-outline-primary custom-button" type="button" 
                    data-book-num="${notice.reserved_book.book.bookNum}">대출하기</button>
                    
            <button class="btn-cancel btn btn-outline-danger custom-button" type="button"
                    data-book-num="${notice.reserved_book.book.bookNum}">예약취소</button>
            
        </c:when>
        <c:otherwise>
            <p>알림이 존재하지 않습니다.</p>
        </c:otherwise>
    </c:choose>

</div>

<script src="/js/user/notice.js"></script>

</body>
</html>
