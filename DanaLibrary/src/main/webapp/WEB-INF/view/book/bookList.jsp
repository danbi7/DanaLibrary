<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dana.library.domain.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>

<input type="hidden" value="${loginUser.userid }" id="userid">
<div class="container-bookList mt-4" align="center">

    <div class="row justify-content-between">
        <div class="bookList-icon text-center">
            <img src="/image/icon/icon-book.png"><h5><strong>도서 목록</strong></h5></div>
        <div class="col-md-6 text-center">

            <form action="/public/book/view/getBookList">
                <div class="d-flex">
                    <div class="dropdown">
                        <select name="category"
                                class="btn btn-outline-primary dropdown-toggle"
                                aria-label="Dropdown" id="bookCategory" style="height: 100%">
                            <option value="전체">전체</option>
                            <option value="총류">총류</option>
                            <option value="철학">철학</option>
                            <option value="종교">종교</option>
                            <option value="사회과학">사회과학</option>
                            <option value="언어">언어</option>
                            <option value="자연과학">자연과학</option>
                            <option value="기술과학">기술과학</option>
                            <option value="예술">예술</option>
                            <option value="문학">문학</option>
                            <option value="역사">역사</option>
                        </select>
                    </div>
                    <input class="form-control me-2" type="text"
                           placeholder="책 제목을 입력하세요" name="bookTitle">
                    <button type="submit" class="btn" type="button" style="padding: 0px"><img src="/image/icon/search.png"></button>

                </div>
            </form>
        </div>

        <div style="width: 150px"></div>
    </div>
  
    <div class="mt-3" style="border-top: 7px solid #205295; padding-top: 20px">
     <nav aria-label="breadcrumb">
    <ol class="breadcrumb breadcrumb-chevron bg-body-tertiary mx-4">
      <li class="breadcrumb-item">
		전체 도서 목록
      </li>
      <li class="breadcrumb-item">
<c:if test="${category == null || category == ''}">전체</c:if>
      		 <c:if test="${category ne null }">${category }</c:if>
		</li>
    </ol>
  </nav>
 <hr>
        <c:forEach var="book" items="${bookStatusMap.keySet()}">
            <div class="row">
                <div class="col-md-3" align="center"
                     style="display: flex; justify-content: center;">
                    <a href="/book/getBook/${ book.bookNum }"><img src="${book.image}" style="width: 130px; height: 180px;"></a>
                </div>

                <div class="col-md-7" style="text-align: left">
                    <h6 class="mt-3">
                       <a href="/book/getBook/${ book.bookNum }"><b>${book.title}</b></a>
                    </h6>
                    <p>${book.author}&nbsp|&nbsp ${book.publisher} &nbsp | &nbsp
                        ${book.category}
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

                <div class="col-md-2 buttons">
                    <a href="/book/getBook/${ book.bookNum }"
                       class="btn btn-outline-danger custom-button" type="button">상세정보</a>

                    <c:set var="status" value="${bookStatusMap[book].status}"/>
                    <c:choose>
                        <c:when test="${status eq 1}">
                            <button class="btn-reserve-cancel btn btn-outline-secondary custom-button"
                                    type="button" data-booknum="${book.bookNum }">예약취소</button>
                        </c:when>
                        <c:when test="${status eq 2}">
                            <button class="btn-returnBook btn btn-outline-info custom-button"
                                    type="button" data-booknum="${book.bookNum }">반납하기</button>
                        </c:when>
                        <c:when test="${status eq 3}">
                            <button class="btn-reserve btn btn-outline-success custom-button"
                                    type="button" data-booknum="${book.bookNum }">예약하기</button>
                        </c:when>
                        <c:when test="${status eq 4}">
                            <button class="btn-rent btn btn-outline-primary custom-button"
                                    type="button" data-booknum="${book.bookNum }">대출하기</button>
                        </c:when>
                    </c:choose>

                    <c:choose>
                        <c:when test="${bookStatusMap[book].interested}">
                            <button class="btn-removeInterest btn btn-outline-secondary custom-button"
                                    style="font-size: 11px; width: 90px; height: 33.2px; padding: 4.1px 6px;"
                                    data-booknum="${book.bookNum }"><img src="/image/fillheart.png"
                                                                           style="width: 25px; height: 25px">
                            </button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn-addInterest btn btn-outline-secondary custom-button"
                                    style="font-size: 11px; width: 90px; height: 33.2px; padding: 4.1px 6px;"
                                    data-booknum="${book.bookNum }"><img src="/image/emptyheart.png"
                                                                           style="width: 25px; height: 25px">
                            </button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <hr>
        </c:forEach>
    </div>
  <div class="mt-4">
    <ul class="pagination justify-content-center">
  <c:choose>
	<c:when test="${bookList.first }">
		<a class="btn btn-secondary">이전</a>
	</c:when>
	<c:otherwise>
	<c:url value="/public/book/view/getBookList" var="encodedUrl">
    <c:param name="category" value="${category}" />
    <c:param name="bookTitle" value="${title}" />
    <c:param name="page" value="${bookList.number - 1}" />
</c:url>
		<a href="${encodedUrl}" class="btn btn-primary">이전</a>
	</c:otherwise>
</c:choose>
  
<c:forEach begin="${startPage }" end="${endPage }" var="i">
<c:choose>
<c:when test="${nowPage == i }">
<c:url value="/public/book/view/getBookList" var="encodedUrl">
    <c:param name="category" value="${category}" />
    <c:param name="bookTitle" value="${title}" />
    <c:param name="page" value="${i - 1}" />
</c:url>

<li class="page-item"><a href="${encodedUrl}" class="page-link"><strong>${i}</strong></a></li></c:when>
<c:otherwise>

<c:url value="/public/book/view/getBookList" var="encodedUrl">
    <c:param name="category" value="${category}" />
    <c:param name="bookTitle" value="${title}" />
    <c:param name="page" value="${i - 1}" />
</c:url>

<li class="page-item"><a href="${encodedUrl}" class="page-link">${i}</a></li>
</c:otherwise>
</c:choose>
</c:forEach>

<c:choose>
	<c:when test="${bookList.last }">
		<a class="btn btn-secondary">다음</a>
	</c:when>
	<c:otherwise>
<c:url value="/public/book/view/getBookList" var="encodedUrl">
    <c:param name="category" value="${category}" />
    <c:param name="bookTitle" value="${title}" />
    <c:param name="page" value="${bookList.number + 1}" />
</c:url>

<a href="${encodedUrl}" class="btn btn-primary">다음</a>
	</c:otherwise>
</c:choose>
</ul>
</div>
</div>
<script src="/js/book/book2.js"></script>

<%@ include file="../layout/footer.jsp"%>