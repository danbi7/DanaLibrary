package com.dana.library.domain;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "BOOK_REVIEW")
public class Book_review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewNum;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userNum")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)	@JoinColumn(name = "bookNum")
	private Book book;
	
	@Column(nullable = false, length = 200)
	private String content;
	
	@CreationTimestamp
	private Timestamp regDate;

}
