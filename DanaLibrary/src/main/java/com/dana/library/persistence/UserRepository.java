package com.dana.library.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserid(String userid);

	User findByEmail(String email);
}
