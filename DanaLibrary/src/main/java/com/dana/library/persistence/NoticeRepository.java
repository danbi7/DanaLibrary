package com.dana.library.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dana.library.domain.Notice;
import com.dana.library.domain.User;

public interface NoticeRepository extends JpaRepository<Notice, Integer>{
	
	Notice findByUser(User user);

}
