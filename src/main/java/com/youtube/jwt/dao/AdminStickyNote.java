package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.youtube.jwt.entity.AdminStickNote;
@Repository
public interface AdminStickyNote extends JpaRepository<AdminStickNote, Long> {

}
