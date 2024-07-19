package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Template;

@Repository
public interface TemplateDao extends JpaRepository<Template, Long> {

}
