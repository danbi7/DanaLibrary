package com.dana.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {
	
	@NotNull(message = "제목은 필수 입력 항목입니다.")
	@NotBlank(message = "제목은 필수 입력 항목입니다.")
	private String title;
	
	@NotNull(message = "저자는 필수 입력 항목입니다.")
	@NotBlank(message = "저자는 필수 입력 항목입니다.")
	private String author;

}
