package com.dana.library.dto;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	@NotNull(message = "아이디 입력은 필수입니다.")
	@NotBlank(message = "아이디 필수 입력 항목입니다.")
	@Size(min = 1, max = 20, message = "아이디는 한 글자 이상 20자 미만으로 입력하세요")
	private String userid;
	
	
	@NotNull(message = "Email이 전달되지 않았습니다.")
	@NotBlank(message = "Email은 필수 입력 항목입니다.")
	@Email(message = "이메일 형식이 아닙니다.")
	private String email;
	
	@NotNull(message = "이름은 필수 입력 항목입니다")
	@NotBlank(message = "이름은 필수 입력 항목입니다")
	private String username;
	
	
	@NotNull(message = "비밀번호를 입력해주세요.")
	@NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
	private String password;
	
	@NotNull(message = "생년월일 입력은 필수입니다.")
	@Past(message = "생년월일은 현재 날짜보다 이전이어야 합니다.")
	private Date birthDate;
}
