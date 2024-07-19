package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.AwardList;

@Repository
public interface AwardListDao extends JpaRepository<AwardList, Long> {

}
