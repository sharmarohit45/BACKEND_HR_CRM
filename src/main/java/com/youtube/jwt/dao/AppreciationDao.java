package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Appericiation;
@Repository
public interface AppreciationDao extends JpaRepository<Appericiation, Long> {

}
