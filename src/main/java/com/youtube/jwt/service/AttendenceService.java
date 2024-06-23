package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.AttendenceDao;
import com.youtube.jwt.entity.Attendence;
@Service
public class AttendenceService {
	@Autowired
	private AttendenceDao attendenceDao;
	public Attendence saveAttendence(Attendence attendence) {
        return attendenceDao.save(attendence);
    }
 public List<Attendence> getAllAttendence() {
	    return attendenceDao.findAll(); 
	}
 

}
