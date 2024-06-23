package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.AdminStickyNote;
import com.youtube.jwt.entity.AdminStickNote;

@Service
public class AdminStickyNoteService {
    @Autowired
    private AdminStickyNote adminStickyNote;

    public AdminStickNote saveNote(AdminStickNote adminStickNote) {
        return adminStickyNote.save(adminStickNote);
    }

    public List<AdminStickNote> getAllNotes() {
        return adminStickyNote.findAll();
    }

    public Optional<AdminStickNote> getNoteById(Long id) {
        return adminStickyNote.findById(id);
    }

    public void deleteNoteById(Long stickyNoteId) {
        adminStickyNote.deleteById(stickyNoteId);
    }

    public AdminStickNote updateNoteById(Long stickyNoteId, AdminStickNote updatedNote) {
        return adminStickyNote.findById(stickyNoteId)
                .map(note -> {
                    note.setNoteColor(updatedNote.getNoteColor());
                    note.setSubject(updatedNote.getSubject());
                    note.setNote(updatedNote.getNote());
                    return adminStickyNote.save(note);
                })
                .orElseThrow(() -> new IllegalArgumentException("Note not found"));
    }
}
