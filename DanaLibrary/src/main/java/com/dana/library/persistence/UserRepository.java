package com.dana.library.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.User;

@Repository

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUserid(String Userid);
	
	boolean existsByUserid(String userid);

	Optional<User> findByEmail(String email);
}
