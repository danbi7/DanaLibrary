package com.dana.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Category {

	QUESTION("질문글"), NOTICE("공지사항"), FREE("자유글"), REQUEST("도서신청"),TOTAL("전체글");
	
	private String category;

}
