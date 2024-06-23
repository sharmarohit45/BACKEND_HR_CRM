package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.AdminStickNote;
import com.youtube.jwt.service.AdminStickyNoteService;

@RestController
public class AdminStickyNoteController {

	 @Autowired
	    private AdminStickyNoteService adminStickyNoteService;

	    @PostMapping("/stickynote")
	    public ResponseEntity<AdminStickNote> createNote(@RequestBody AdminStickNote adminStickNote) {
	        AdminStickNote savedNote = adminStickyNoteService.saveNote(adminStickNote);
	        return ResponseEntity.ok(savedNote);
	    }

	    @GetMapping("/stickynote")
	    public ResponseEntity<List<AdminStickNote>> getAllNotes() {
	        List<AdminStickNote> notes = adminStickyNoteService.getAllNotes();
	        return ResponseEntity.ok(notes);
	    }
	    @GetMapping("/stickynote/{stickyNoteId}")
	    public ResponseEntity<AdminStickNote> getNoteById(@PathVariable Long stickyNoteId) {
	        return adminStickyNoteService.getNoteById(stickyNoteId)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/stickynote/{stickyNoteId}")
	    public ResponseEntity<Void> deleteNoteById(@PathVariable Long stickyNoteId) {
	        adminStickyNoteService.deleteNoteById(stickyNoteId);
	        return ResponseEntity.noContent().build();
	    }

	    @PutMapping("/stickynote/{stickyNoteId}")
	    public ResponseEntity<AdminStickNote> updateNoteById(@PathVariable Long stickyNoteId, @RequestBody AdminStickNote updatedNote) {
	        try {
	            AdminStickNote updated = adminStickyNoteService.updateNoteById(stickyNoteId, updatedNote);
	            return ResponseEntity.ok(updated);
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
