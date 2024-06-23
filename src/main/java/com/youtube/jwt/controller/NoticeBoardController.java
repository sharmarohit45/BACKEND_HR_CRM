package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.Designations;
import com.youtube.jwt.entity.NoticeBoard;
import com.youtube.jwt.service.NoticeBoardService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class NoticeBoardController {
@Autowired
private NoticeBoardService noticeBoardService;
 @PostMapping("/notice")
 public ResponseEntity<NoticeBoard> postNotice(@RequestBody NoticeBoard noticeBoard) {
     NoticeBoard saveNotice = noticeBoardService.postNotice(noticeBoard);
     return ResponseEntity.ok(saveNotice);
 }
 @GetMapping("/notice")
 public List<NoticeBoard> getAllNotice() {
     return noticeBoardService.getAllNotice();
 }
 
}
