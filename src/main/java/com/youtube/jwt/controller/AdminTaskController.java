package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.jwt.entity.AdminTask;
import com.youtube.jwt.entity.Project;
import com.youtube.jwt.service.AdminTaskService;

@RestController
public class AdminTaskController {

	@Autowired
	private AdminTaskService adminTaskService;

	@GetMapping("/task")
	public List<AdminTask> getAllTask() {
		return adminTaskService.getAllTask();
	}

	@PostMapping("/createTask")
	 public ResponseEntity<AdminTask> saveTasks(@RequestBody AdminTask adminTask) {
        try {			 
            AdminTask savedtask = adminTaskService.savetask(adminTask);
            return ResponseEntity.ok(savedtask);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
}
