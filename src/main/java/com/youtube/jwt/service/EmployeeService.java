package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.youtube.jwt.dao.EmployeeDao;
import com.youtube.jwt.dao.ProjectDao;
import com.youtube.jwt.dao.ShiftDao;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.entity.Project;
import com.youtube.jwt.entity.Shift;
import com.youtube.jwt.exception.EntityNotFoundException;

import org.springframework.util.StringUtils;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private ShiftDao shiftRepository;
    @Autowired
    private ProjectDao projectRepository;


    public Employee saveEmployee(Employee employee) {
        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);
        if (employee.getImageData() != null && StringUtils.hasText(employee.getImageName())) {
            String directoryPath = "src/images/employeeImages";
            String imagePath = ImageFileHandler.saveImageDataToFile(directoryPath, employee.getImageName(), employee.getImageData());
            if (imagePath != null) {
                employee.setImageName(imagePath);
            } else {
                // Handle the case where image saving fails
            }
        }
        return employeeDao.save(employee);
    }
    public Optional<Employee> getEmployeeById(Long empId) {
        Optional<Employee> employee = employeeDao.findById(empId);
        if (employee.isEmpty()) {
            //Logger.warning("Employee with ID " + empId + " not found.");
        }
        return employee;
    }
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
    public List<Employee> getEmployee() {
        return employeeDao.findAll();
    }
    
    @Transactional
    public void deleteEmployee(Long employeeId) {
        Optional<Employee> employeeOptional = employeeDao.findById(employeeId);
        
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            List<Shift> shifts = shiftRepository.findByEmployee(employee);
            
            // Delete all shifts associated with the employee
            for (Shift shift : shifts) {
                shiftRepository.delete(shift);
            }
            for (Project project : employee.getProjects()) {
                project.getMembers().remove(employee);
                projectRepository.save(project);
            }
            
            // Now delete the employee
            employeeDao.delete(employee);
        } 
    }
    @Transactional
    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
        Optional<Employee> employeeOptional = employeeDao.findById(employeeId);

        if (employeeOptional.isPresent()) {
            Employee existingEmployee = employeeOptional.get();
            
            // Update fields of the existing employee with values from updatedEmployee
            existingEmployee.setEmployeeIdentity(updatedEmployee.getEmployeeIdentity());
            existingEmployee.setSalutation(updatedEmployee.getSalutation());
            existingEmployee.setEmpName(updatedEmployee.getEmpName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setPassword(updatedEmployee.getPassword());
            existingEmployee.setDesignation(updatedEmployee.getDesignation());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());
            existingEmployee.setCountry(updatedEmployee.getCountry());
            existingEmployee.setMobileNo(updatedEmployee.getMobileNo());
            existingEmployee.setGender(updatedEmployee.getGender());
            existingEmployee.setJoiningDate(updatedEmployee.getJoiningDate());
            existingEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
            existingEmployee.setReportingTo(updatedEmployee.getReportingTo());
            existingEmployee.setLanguage(updatedEmployee.getLanguage());
            existingEmployee.setEmp_User_Name(updatedEmployee.getEmp_User_Name());
            existingEmployee.setAddress(updatedEmployee.getAddress());
            existingEmployee.setAbout(updatedEmployee.getAbout());
            existingEmployee.setLogin_Allowed(updatedEmployee.getLogin_Allowed());
            existingEmployee.setEmail_Notification(updatedEmployee.getEmail_Notification());
            existingEmployee.setHourly_Rate(updatedEmployee.getHourly_Rate());
            existingEmployee.setSlack_Member_Id(updatedEmployee.getSlack_Member_Id());
            existingEmployee.setSkills(updatedEmployee.getSkills());
            existingEmployee.setProvision_End_Date(updatedEmployee.getProvision_End_Date());
            existingEmployee.setNotice_Period_Date(updatedEmployee.getNotice_Period_Date());
            existingEmployee.setNotice_Period_Enddate(updatedEmployee.getNotice_Period_Enddate());
            existingEmployee.setEmployement_Type(updatedEmployee.getEmployement_Type());
            existingEmployee.setMaritial_State(updatedEmployee.getMaritial_State());
            existingEmployee.setRole(updatedEmployee.getRole());
            existingEmployee.setImageName(updatedEmployee.getImageName());
            existingEmployee.setImageData(updatedEmployee.getImageData());

            // Save the updated employee
            return employeeDao.save(existingEmployee);
        } else {
            // Handle the case when the employee is not found
            throw new EntityNotFoundException("Employee not found with id: " + employeeId);
        }
    }
    

}