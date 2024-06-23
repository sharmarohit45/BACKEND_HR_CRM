package com.youtube.jwt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.youtube.jwt.dao.ShiftDao;
import com.youtube.jwt.entity.Admin;
import com.youtube.jwt.entity.Lead;
import com.youtube.jwt.entity.Shift;

@Service
public class ShiftService {
	
	@Autowired
	private ShiftDao shiftDao;
	
	public Shift saveShift(Shift shift){
		if (shift.getFileData() != null && StringUtils.hasText(shift.getFileName())) {
            String directoryPath = "src/images/ClientProfileImages"; // Set your image directory path here
            String imagePath = ImageFileHandler.saveImageDataToFile(directoryPath, shift.getFileName(), shift.getFileData());
            if (imagePath != null) {
            	shift.setFileName(imagePath);
            } else {
                // Handle the case where image saving fails
            }
        }
		return shiftDao.save(shift);
	}
	 public List<Shift> getShiftData() {
	        return shiftDao.findAll();
	    }

}
