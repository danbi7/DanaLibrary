<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.dana.library.domain.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="../layout/header1.jsp" %>

<title>도서 목록</title>
</head>
<body>
<div class="container-page-content-book">
    <div class="jumbotron">
        <div class="container" align="center">
            <h2>도서 목록</h2>
            
        </div>
    </div>
    
    <c:forEach var="book" items="${bookList}">
    <div class="row">

        <div class="col-md-3" align="center" style="display: flex; justify-content: center;">   
            <img src="${book.image}" style="width: 130px; height: 180px;">

        </div>
        
        <div class="col-md-7">
            <p><h6><b>${book.title}</b></h6>
            <p>${book.author} &nbsp | &nbsp  ${book.publisher} &nbsp | &nbsp ${book.category}
            
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
        
	<div class="col-md-2 buttons" >
    <input id="bookNum" value="${book.bookNum }">
    <a href="/book/getBook/${book.bookNum }" class="btn btn-outline-danger custom-button" type="button">상세정보</a> 
    
	
	
	<a href="#" class="btn btn-outline-success custom-button" id="btn-reserve">예약하기</a>

	<a href="#" class="btn btn-outline-primary custom-button" id="btn-rent2">대출하기</a>
	<script src="/js/rentBook2.js"></script>
	
	<a href="#" class="btn btn-outline-info custom-button" id="btn-returnBook2">반납하기</a>
	<script src="/js/returnBook2.js"></script>
	
	
	
	<a href="#"><img src="/image/emptyheart.png" class="likeimg1 likeimg1-" alt="emptyheart">찜</a>
	</div>

    </div>
    </div>
    <hr>
    
</c:forEach>
</div>

</body>
</html>

<%@ include file="../layout/footer.jsp" %>