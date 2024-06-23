package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Shift;

@Repository
public interface ShiftDao extends JpaRepository<Shift,Long> {

}
