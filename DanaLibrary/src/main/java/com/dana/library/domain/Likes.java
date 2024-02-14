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
@Table(name = "LIKES")
public class Likes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likesNum;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userNum")
	private User userNum;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "boardNum")
	private Board boardNum;
	
	
}