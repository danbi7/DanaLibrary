package com.dana.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
	ACTIVE("활성"), INACTIVE("비활성"), PENDING("대기"), ADMIN("관리자"); 
	
	private String status;
}
