<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="../layout/header1.jsp" %>
<%@ include file="../layout/header2.jsp" %>

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
      
            <a href="#" class="btn btn-outline-danger custom-button" type="button">상세정보</a>
            <a href="#" class="btn btn-outline-primary custom-button" type="button">대출하기</a>
           <a href="#"><img src="/image/emptyheart.png" class="likeimg1 likeimg1-" alt="emptyheart">찜</a>
    
        </div>
    </div>
    <hr>
</c:forEach>
</div>
</body>
</html>

<%@ include file="../layout/footer.jsp" %>