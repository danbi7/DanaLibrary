<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.dana.library.domain.*"%>

<div class="container-board">
	<h2>글 수정</h2>
		<div class="form-group">
			<label for="title">제목</label> 
			<input type="text" class="form-control"
				id="title" name="title" value="${board.title}">
		</div>
		<div class="form-group">
			<label for="category">카테고리</label> <select class="form-control"
				id="category" name="category">
					<c:if test="${loginUser.userStatus eq Status.ADMIN }">
					<option value="${Category.NOTICE }">공지글</option></c:if>
					<c:if test="${loginUser.userStatus eq Status.ACTIVE }">
					<option value="${Category.FREE}">자유글</option>
					<option value="${Category.QUESTION }">질문글</option></c:if>
			</select>
		</div>
		<input type="hidden"value="${board.boardNum }" id="boardNum" readonly>
		<div class="form-group">
			<label for="content">내용</label>
			  <textarea rows="5" id="content" name="content" class="form-control">${board.content }</textarea>
      
    </div>

    <script>
        $(document).ready(function() {
            $("#content").summernote({
                placeholder : '내용을 입력하세요',
                height : 300
            });
        });
    </script>
  
		 <div class="text-center mt-4">
		<button id="update-board" class="btn btn-primary">수정 완료</button>
		<a href="/board/view/getBoard/${board.boardNum}"
			class="btn btn-secondary">취소</a>
	</div>
	</div>

<%@ include file="../layout/footer.jsp"%>
<script src="/js/board/updateBoard.js"></script>