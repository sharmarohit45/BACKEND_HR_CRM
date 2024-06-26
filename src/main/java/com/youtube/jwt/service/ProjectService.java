package com.youtube.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.youtube.jwt.dao.ClientDao;
import com.youtube.jwt.dao.EmployeeDao;
import com.youtube.jwt.dao.ProjectDao;
import com.youtube.jwt.entity.Client;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.entity.Project;

@Service
public class ProjectService {

    @Autowired
    private ProjectDao projectRepository;

    @Autowired
    private EmployeeDao employeeRepository;
    
    @Autowired
    private ClientDao clientRepository;

    public Long getProjectCount() {
        return projectRepository.count();
    }
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public Project createProjectWithMembers(Project project, List<Long> employeeIds,Long ClientId) {
        List<Employee> members = new ArrayList<>();
        for (Long employeeId : employeeIds) {
            Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
            employeeOptional.ifPresent(members::add); // Add employee if found
        }
        project.setMembers(members); // Assign employees to the project
        Client client = clientRepository.findById(ClientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        project.setClient(client);
        return projectRepository.save(project);
    }
    
    public Project saveProject(Project project) {
        if (project.getAddFileData() != null && StringUtils.hasText(project.getAddFile())) {
            String directoryPath = "src/images/ProjectFile"; // Set your image directory path here
            String imagePath = ImageFileHandler.saveImageDataToFile(directoryPath, project.getAddFile(), project.getAddFileData());
            if (imagePath != null) {
            	project.setAddFile(imagePath);
            } else {
                // Handle the case where image saving fails
            }
        }
        List<Employee> members = new ArrayList<>();
        for (Long employeeId : project.getEmployeeIds()) {
            Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
            employeeOptional.ifPresent(members::add);
        }
        project.setMembers(members); 
        Client client = clientRepository.findById(project.getClientIId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        project.setClient(client);
        return projectRepository.save(project);
    }
}
