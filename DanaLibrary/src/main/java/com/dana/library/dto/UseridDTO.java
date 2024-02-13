package com.dana.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UseridDTO {
	
	@NotNull(message = "아이디는 입력은 필수입니다.")
	@NotBlank(message = "아이디는 필수 입력 항목입니다.")
	@Pattern(regexp = "^[a-zA-Z0-9]{1,20}$", message = "아이디는 영문 대 소문자, 숫자를 사용한 1~20자로 입력하세요. 공백은 허용되지 않습니다.")
	private String userid;

}
