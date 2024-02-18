package com.dana.library.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOK_REQUEST")
public class Book_request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestNum;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String author;

	@Column
	private String publisher;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userNum")
	private User user;
	
	@Enumerated(EnumType.STRING)
	private Status requestStatus = Status.PENDING;
}
