package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.DesignationDao;
import com.youtube.jwt.entity.Admin;
import com.youtube.jwt.entity.Designations;
import com.youtube.jwt.exception.EntityNotFoundException;

@Service
public class DesignationService {
	@Autowired
	private DesignationDao designationDao;

	public Designations saveDesignation(Designations designation) {
		return designationDao.save(designation);
	}

	public List<Designations> getAllDesignations() {
		return designationDao.findAll(); // Or whatever method is used in your DAO
	}
	public Optional<Designations> getDesignationById(Long id) {
        return designationDao.findById(id);
    }

    public void deleteDesignation(Long id) {
        designationDao.deleteById(id);
    }
    public Designations updateDesignation(Long id, Designations updatedDesignation) {
        Optional<Designations> existingDesignationOptional = designationDao.findById(id);
        if (existingDesignationOptional.isPresent()) {
            Designations existingDesignation = existingDesignationOptional.get();
            existingDesignation.setName(updatedDesignation.getName());
            // Add other fields to update as needed
            return designationDao.save(existingDesignation);
        } else {
            // Handle the case where the designation doesn't exist
            throw new EntityNotFoundException("Designation not found with id " + id);
        }
    }

}
