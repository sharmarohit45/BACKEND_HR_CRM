package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.jwt.entity.ProjectWithMembersRequest;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.entity.Project;
import com.youtube.jwt.service.ProjectService;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    
    @GetMapping("/project-count")
	public Long getProjectCount() {
		return projectService.getProjectCount();
	}
    @PostMapping({"/createNewProject"})
    public ResponseEntity<Project> saveProjects(@RequestParam("addfile") MultipartFile addfile, @ModelAttribute Project project) {
        try {
            if (!addfile.isEmpty()) {
                byte[] imageData = addfile.getBytes();
                project.setAddFileData(imageData);
                project.setAddFile(addfile.getOriginalFilename());
            }
            Project savedProject = projectService.saveProject(project);
            return ResponseEntity.ok(savedProject);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/getallProject")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
}
