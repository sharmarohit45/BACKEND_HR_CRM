package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.AdminEvent;
@Repository
public interface AdminEventDao extends JpaRepository<AdminEvent, Long> {

}
