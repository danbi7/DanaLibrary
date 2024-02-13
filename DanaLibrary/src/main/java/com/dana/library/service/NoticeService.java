package com.dana.library.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Notice;
import com.dana.library.domain.Reserved_book;
import com.dana.library.domain.User;
import com.dana.library.persistence.NoticeRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;

	// 예약된 도서에서 예약한 사람을 찾아서 알림 테이블에 추가
	@Transactional
	public void addNotice(Reserved_book findReserve) {
		User noticeUser = findReserve.getUser();
		System.out.println("addNotice : noticeUser " + noticeUser );
		System.out.println("addNotice : noticeContent " + noticeUser );
		Notice notice = new Notice();

		notice.setUser(noticeUser);
		notice.setReserved_book(findReserve);
		System.out.println("addNotice : notice " + notice);
		noticeRepository.save(notice);
	}

	// 해당 회원 알림 검사
	@Transactional
	public Notice findNotice(User user) {
		System.out.println("findNotice의 user : " + user);
		Notice notice = noticeRepository.findByUser(user);
		return notice;
	}
	
	//알림 계속 보내기
	public void sendNotice(HttpSession session) {
		System.out.println("sendNotice 실행");
	
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser != null) {
			// 알림 테이블에서 해당 회원의 알림을 가져옴
			Notice notice = findNotice(loginUser);
			System.out.println("로그인 회원의 notice: " + notice);
			session.setAttribute("notice", notice);
		}
	}
	
	//알림 삭제
	@Transactional
	public void deleteNotice(User user){
		Notice notice = noticeRepository.findByUser(user);
		noticeRepository.deleteById(notice.getNoticeNum());
	}
	
	
}
