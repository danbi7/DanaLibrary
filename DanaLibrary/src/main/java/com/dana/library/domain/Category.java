package com.dana.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
	QUESTION("질문글"), NOTICE("공지글"), FREE("자유글"), REQUEST("도서신청");

	private String category;
}
