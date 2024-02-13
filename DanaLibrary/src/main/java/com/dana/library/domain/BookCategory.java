package com.dana.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookCategory {
	TOTAL("전체"),
	GENERAL("총류"), 
	PHILOSOPHY("철학"),
	RELIGION("종교"),
	SOCIAL_SCIENCES("사회과학"),
	LANGUAGE("언어"), 
	SCIENCE("자연과학"),
	TECHNOLOGY("기술과학"), 
	ARTS("예술"),
	LITERATURE("문학"), 
	HISTROY("역사");
	
	private String bookCategory;

}
