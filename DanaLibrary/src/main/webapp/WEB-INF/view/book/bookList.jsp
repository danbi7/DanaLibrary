<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="../layout/header1.jsp" %>

<title>도서 목록</title>
</head>
<body>
    <div class="jumbotron">
        <div class="container" align="center">
            <h2>도서 목록</h2>
            <c:forEach var="book" items="${bookList}">
        </div>
    </div>
    
    <div class="row">
        <div class="col-md-3" align="center">
            <img src="${book.image}" style="width: 50%">
        </div>
        <div class="col-md-7">
            <p><h5><b>${book.title}</b></h5>
            <p>${book.author} | ${book.publisher}
            <p> ${book.category}
            <p style="padding-top: 20px;">
                <c:choose>
                    <c:when test="${fn:length(book.info) <= 200}">
                        ${book.info}
                    </c:when>
                    <c:otherwise>
                        ${fn:substring(book.info, 0, 200)}...
                    </c:otherwise>
                </c:choose>
            </p>
        </div>
        <div class="col-md-2" style="padding-top: 70px">
            <a href="#" class="btn btn-secondary" type="button">상세정보 &raquo;</a>
            <br>
            <br>
            <a href="#" class="btn btn-primary" type="button">대출하기 &raquo;</a>
            <br>
            <br>
            <img src="/image/emptyheart.png" class="likeimg1 likeimg1-" alt="emptyheart">찜 1
        </div>
    </div>
    <hr>
</c:forEach>
</body>
</html>

<%@ include file="../layout/footer.jsp" %>