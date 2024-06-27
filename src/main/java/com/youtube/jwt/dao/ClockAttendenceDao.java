package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.ClockAttendence;
@Repository
public interface ClockAttendenceDao extends JpaRepository<ClockAttendence, Long> {

}
