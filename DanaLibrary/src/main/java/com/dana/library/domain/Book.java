package com.dana.library.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOK")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookNum;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String author;
	
	@Column(nullable = false)
	private String publisher;

	
	@Column(nullable = false)
	private String category;
	
	@Column
	private String image;
	
<<<<<<< HEAD
	
	@Column(length = 3000)
	private String info;
	
=======
	@Column(length = 3000)
	private String info;
	
>>>>>>> cb3e5718e599db31ff2f0b41cbcd475963444e92
	@Column
	private int pages;
	
	@Column
	private Date publicationDate;
	
}
