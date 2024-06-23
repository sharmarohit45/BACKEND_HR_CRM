package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.NoticeBoardDao;
import com.youtube.jwt.entity.Designations;
import com.youtube.jwt.entity.NoticeBoard;

@Service
public class NoticeBoardService {
@Autowired
private NoticeBoardDao noticeBoardDao;

public NoticeBoard postNotice(NoticeBoard noticeBoard) {
    return noticeBoardDao.save(noticeBoard);
}
public List<NoticeBoard> getAllNotice() {
    return noticeBoardDao.findAll(); 
}
public Optional<NoticeBoard> findNoticeById(Long id) {
    return noticeBoardDao.findById(id);
}
}
