package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.youtube.jwt.entity.Template;
import com.youtube.jwt.service.TemplateService;

@RestController
public class TemplateController {
	@Autowired
	private TemplateService templateService;

	@PostMapping("/template")
	public ResponseEntity<Template> saveTemplate(@RequestBody Template template) {
		Template saveTemplate = templateService.saveData(template);
		return ResponseEntity.ok(saveTemplate);
	}

	@GetMapping("/template")
	public List<Template> getAllDesignations() {
		return templateService.getAllTemplate();
	}
}
