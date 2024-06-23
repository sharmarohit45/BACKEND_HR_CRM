package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.NoticeBoard;

@Repository
public interface NoticeBoardDao extends JpaRepository<NoticeBoard, Long> {

}
