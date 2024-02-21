package com.dana.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Category {

	TOTAL("전체글"), NOTICE("공지사항"), QUESTION("질문글"), FREE("자유글");
	
	private String category;

}
