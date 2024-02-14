<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet" type="text/css" href="/css/myPage.css">
<div class="container-pastRent">
    <h5 class="my-4">
        <strong>지난 대출 도서 목록</strong>
    </h5>

        <c:if test="${empty pastRentList}">
            <p>지난 대출 도서 내역이 없습니다.</p>
        </c:if>

        <c:if test="${pastRentList ne null}">
            <c:set var="count" value="0"/>
            <c:forEach var="book" items="${pastRentList}">
                <c:if test="${count % 5 eq 0}">
    <div class="container-small">
                </c:if>
                <div class="pastRent-book">
                    <a href="/book/getBook/${book.book.bookNum}">
                        <img src="${book.book.image}" alt="Card image cap">
                    </a>
                        <p class="card-text"><a href="/book/getBook/${book.book.bookNum}"><strong>${book.book.title}</strong></a></p>
                    <p class="card-text-date">${book.rentDate } ~ ${book.dueDate }</p>
                </div>
                <c:set var="count" value="${count + 1}"/>
                <c:if test="${count % 5 eq 0 or count eq fn:length(pastRentList)}">
                    </div>
                </c:if>
            </c:forEach>
        </c:if>

</div>
