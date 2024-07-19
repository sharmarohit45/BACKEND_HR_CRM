package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.TemplateDao;
import com.youtube.jwt.entity.Template;

@Service
public class TemplateService {
@Autowired
private TemplateDao templateDao;

public Template saveData(Template template) {
    return templateDao.save(template);
}
public List<Template> getAllTemplate() {
	return templateDao.findAll();
}
public Optional<Template> getTemplateById(Long id) {
    return templateDao.findById(id);
}

}
