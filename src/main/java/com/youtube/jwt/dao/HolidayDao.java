package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Holiday;

@Repository
public interface HolidayDao extends JpaRepository<Holiday, Long> {

}
