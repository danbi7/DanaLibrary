package com.dana.library.domain;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userNum;
	
	@Column(nullable = false, length = 20)
	private String username;
	
	@Column(nullable = false, length = 20, unique = true)
	private String userid;
	
	@Column(nullable = false, length = 20)
	private String password;
	
	@Column
	private String email;
	
	@Column
	private Date birthDate;
	
	@Column
	private String gender;
	
	@Enumerated(EnumType.STRING)
	private Status userStatus;
	
	@CreationTimestamp
	private Timestamp regDate;

}
