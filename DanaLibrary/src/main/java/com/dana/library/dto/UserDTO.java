package com.dana.library.dto;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	@NotNull(message = "아이디는 입력은 필수입니다.")
	@NotBlank(message = "아이디는 필수 입력 항목입니다.")
	@Pattern(regexp = "^[a-zA-Z0-9]{1,20}$", message = "아이디는 영문 대 소문자, 숫자를 사용한 1~20자로 입력하세요. 공백은 허용되지 않습니다.")
	private String userid;
	
	
	@NotNull(message = "Email이 전달되지 않았습니다.")
	@NotBlank(message = "Email은 필수 입력 항목입니다.")
	@Email(message = "이메일 형식이 아닙니다.")
	private String email;
	
	@NotNull(message = "이름은 필수 입력 항목입니다")
	@NotBlank(message = "이름은 필수 입력 항목입니다")
	@Pattern(regexp = "^[가-힣]{1,20}$", message = "이름은 한글만 입력 가능합니다. 공백은 허용되지 않습니다.")
	private String username;
	
	
	@NotNull(message = "비밀번호를 입력해주세요.")
	@NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
	@Pattern(regexp = "^(?!.*\\s)[a-zA-Z0-9\\W]{8,16}$", message = "비밀번호는 영문 대 소문자, 숫자, 특수문자를 사용한 8~16자로 입력하세요. 공백은 허용되지 않습니다.")
	private String password;
	
	@NotNull(message = "생년월일 입력은 필수입니다.")
	@Past(message = "생년월일은 현재 날짜보다 이전이어야 합니다.")
	private Date birthDate;
}
