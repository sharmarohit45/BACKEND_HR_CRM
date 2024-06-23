package com.youtube.jwt.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Employee;
import java.util.List;
import java.util.Optional;
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {
	 Employee findByEmail(String email);
	 List<Employee> findAll();
	 @Override
	 Optional<Employee> findById(Long id);
	 

}
