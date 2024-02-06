package com.dana.library.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.dana.library.domain.Notice;
import com.dana.library.domain.Reserved_book;
import com.dana.library.domain.User;
import com.dana.library.persistence.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;

	// 예약된 도서에서 예약한 사람을 찾아서 알림 테이블에 추가
	public void addNotice(Reserved_book findReserve) {
		User noticeUser = findReserve.getUser();
		Notice notice = new Notice();

		notice.setUser(noticeUser);
		noticeRepository.save(notice);
	}

	// 해당 회원 알림 검사
	@Transactional
	public Notice findNotice(User user) {
		Notice notice = noticeRepository.findByUser(user);
		return notice;
	}
	
	//public SseEmitter subscribe(User user) {
		
	//}
	
	
	

}
