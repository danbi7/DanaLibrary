package com.dana.library.domain;

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
@Table(name = "RESERVED_BOOK")
public class Reserved_book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reserveNum;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userNum")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookNum")
	private Book book;

}
