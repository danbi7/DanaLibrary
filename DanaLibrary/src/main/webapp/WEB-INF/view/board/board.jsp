<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>

<div class="container-board">
    <!-- 게시글 내용 -->
    <hr class="my-4">
    <div class="container-head">
        <div class="title">
            제목: <strong>예시글 어쩌고 저쩌고</strong>
        </div>
        <div class="writer">작성자: 홍길동</div>
    </div>
    <hr class="mt-4">

    <div class="container-body">
        <div class="category">카테고리: 공지글</div>
        <div class="regDate">작성일: 2024-01-01</div>
        <div class="cnt">조회수: 10</div>
        <div class="likes">추천수: 2</div>
    </div>

    <hr class="mt-3">
    
    <textarea rows="15" readonly="readonly">예시글 어쩌고 저쩌고 알아라아라아아아아ㅏ</textarea>
    <hr class="my-3">
    
    <!-- 댓글 -->
    <div class="comments">
        <h2>댓글</h2>
        <div class="comment">
            <div class="comment-author">댓글 작성자: 댓글 작성자명</div>
            <div class="comment-content">댓글 내용이 들어갈 자리입니다.</div>
            <div class="comment-date">댓글 작성일: 2024-01-01</div>
        </div>
        <!-- 다른 댓글들도 여기에 추가 -->
    </div>

    <!-- 댓글 작성 폼 -->
    <div class="comment-form">
        <h2>댓글 작성하기</h2>
        <form action="/comment/add" method="post">
            <div class="form-group">
                <label for="comment-author">작성자:</label>
                <input type="text" id="comment-author" name="author">
            </div>
            <div class="form-group">
                <label for="comment-content">내용:</label>
                <textarea id="comment-content" name="content" rows="5"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">댓글 작성</button>
        </form>
    </div>

    <hr class="my-3">
    
    <!-- 기타 버튼 등 -->
    <div class="buttons text-center">
        <button class="btn btn-secondary">뒤로가기</button>
        <button class="btn btn-secondary">글 수정</button>
        <button class="btn btn-secondary">글 삭제</button>
        <button class="btn btn-secondary">추천하기</button>
    </div>
</div>

<%@ include file="../layout/footer.jsp"%>