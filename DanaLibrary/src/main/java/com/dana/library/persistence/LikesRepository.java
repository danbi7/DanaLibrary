package com.dana.library.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.Board;
import com.dana.library.domain.Likes;
import com.dana.library.domain.User;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer>{

	Optional<Likes> findByUserNumAndBoardNum(User userNum, Board boardNum);

	int countByBoardNum(Board boardNum);
}
