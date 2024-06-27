package com.youtube.jwt.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.ClockAttendenceDao;
import com.youtube.jwt.entity.ClockAttendence;

@Service
public class ClockAttendenceService {
	@Autowired
	private ClockAttendenceDao clockAttendanceDao;
	
	public List<ClockAttendence> getAllClockAttendences() {
        return clockAttendanceDao.findAll();
    }
	public ClockAttendence createClockAttendence(ClockAttendence clockAttendence) {
        return clockAttendanceDao.save(clockAttendence);
    }

}
