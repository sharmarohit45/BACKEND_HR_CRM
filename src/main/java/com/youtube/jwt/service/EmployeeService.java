package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.youtube.jwt.dao.ClockAttendenceDao;
import com.youtube.jwt.dao.EmployeeDao;
import com.youtube.jwt.dao.ProjectDao;
import com.youtube.jwt.dao.ShiftDao;
import com.youtube.jwt.entity.ClockAttendence;
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
    @Autowired
    private ClockAttendenceDao clockAttendenceDao;

    public Long getEmployeeCount() {
        return employeeDao.count();
    }
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
            List<ClockAttendence> clockAttendence = clockAttendenceDao.findByEmployee(employee);
            for (ClockAttendence clockAtt : clockAttendence) {
            	clockAttendenceDao.delete(clockAtt);
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

            if (updatedEmployee.getEmployeeIdentity() != null) {
                existingEmployee.setEmployeeIdentity(updatedEmployee.getEmployeeIdentity());
            }
            if (updatedEmployee.getSalutation() != null) {
                existingEmployee.setSalutation(updatedEmployee.getSalutation());
            }
            if (updatedEmployee.getEmpName() != null) {
                existingEmployee.setEmpName(updatedEmployee.getEmpName());
            }
            if (updatedEmployee.getEmail() != null) {
                existingEmployee.setEmail(updatedEmployee.getEmail());
            }
            if (updatedEmployee.getPassword() != null) {
                existingEmployee.setPassword(passwordEncoder.encode(updatedEmployee.getPassword()));
            }
            if (updatedEmployee.getDesignation() != null) {
                existingEmployee.setDesignation(updatedEmployee.getDesignation());
            }
            if (updatedEmployee.getDepartment() != null) {
                existingEmployee.setDepartment(updatedEmployee.getDepartment());
            }
            if (updatedEmployee.getCountry() != null) {
                existingEmployee.setCountry(updatedEmployee.getCountry());
            }
            if (updatedEmployee.getMobileNo() != null) {
                existingEmployee.setMobileNo(updatedEmployee.getMobileNo());
            }
            if (updatedEmployee.getGender() != null) {
                existingEmployee.setGender(updatedEmployee.getGender());
            }
            if (updatedEmployee.getJoiningDate() != null) {
                existingEmployee.setJoiningDate(updatedEmployee.getJoiningDate());
            }
            if (updatedEmployee.getDateOfBirth() != null) {
                existingEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
            }
            if (updatedEmployee.getReportingTo() != null) {
                existingEmployee.setReportingTo(updatedEmployee.getReportingTo());
            }
            if (updatedEmployee.getLanguage() != null) {
                existingEmployee.setLanguage(updatedEmployee.getLanguage());
            }
            if (updatedEmployee.getEmp_User_Name() != null) {
                existingEmployee.setEmp_User_Name(updatedEmployee.getEmp_User_Name());
            }
            if (updatedEmployee.getAddress() != null) {
                existingEmployee.setAddress(updatedEmployee.getAddress());
            }
            if (updatedEmployee.getAbout() != null) {
                existingEmployee.setAbout(updatedEmployee.getAbout());
            }
            if (updatedEmployee.getLogin_Allowed() != null) {
                existingEmployee.setLogin_Allowed(updatedEmployee.getLogin_Allowed());
            }
            if (updatedEmployee.getEmail_Notification() != null) {
                existingEmployee.setEmail_Notification(updatedEmployee.getEmail_Notification());
            }
            if (updatedEmployee.getHourly_Rate() != null) {
                existingEmployee.setHourly_Rate(updatedEmployee.getHourly_Rate());
            }
            if (updatedEmployee.getSlack_Member_Id() != null) {
                existingEmployee.setSlack_Member_Id(updatedEmployee.getSlack_Member_Id());
            }
            if (updatedEmployee.getSkills() != null) {
                existingEmployee.setSkills(updatedEmployee.getSkills());
            }
            if (updatedEmployee.getProvision_End_Date() != null) {
                existingEmployee.setProvision_End_Date(updatedEmployee.getProvision_End_Date());
            }
            if (updatedEmployee.getNotice_Period_Date() != null) {
                existingEmployee.setNotice_Period_Date(updatedEmployee.getNotice_Period_Date());
            }
            if (updatedEmployee.getNotice_Period_Enddate() != null) {
                existingEmployee.setNotice_Period_Enddate(updatedEmployee.getNotice_Period_Enddate());
            }
            if (updatedEmployee.getEmployement_Type() != null) {
                existingEmployee.setEmployement_Type(updatedEmployee.getEmployement_Type());
            }
            if (updatedEmployee.getMaritial_State() != null) {
                existingEmployee.setMaritial_State(updatedEmployee.getMaritial_State());
            }
            if (updatedEmployee.getRole() != null) {
                existingEmployee.setRole(updatedEmployee.getRole());
            }
            if (updatedEmployee.getImageName() != null) {
                existingEmployee.setImageName(updatedEmployee.getImageName());
            }
            if (updatedEmployee.getImageData() != null) {
                existingEmployee.setImageData(updatedEmployee.getImageData());
            }

            return employeeDao.save(existingEmployee);
        } else {
            throw new EntityNotFoundException("Employee not found with id: " + employeeId);
        }
    }

    

}