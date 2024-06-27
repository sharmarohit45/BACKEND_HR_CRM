package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.HolidayDao;
import com.youtube.jwt.entity.Holiday;

@Service
public class HolidayService {
	@Autowired
	private HolidayDao holidayDao;

	public List<Holiday> getAllHoliday() {
		return holidayDao.findAll();
	}

	public Holiday createHoliday(Holiday holiday) {
		return holidayDao.save(holiday);
	}

	public Holiday updateHoliday(Long id, Holiday holiday) {
		Optional<Holiday> existingHolidayOptional = holidayDao.findById(id);
		if (existingHolidayOptional.isPresent()) {
			Holiday existingHoliday = existingHolidayOptional.get();
			existingHoliday.setDate(holiday.getDate());
			existingHoliday.setOccasion(holiday.getOccasion());
			existingHoliday.setDepartment(holiday.getDepartment());
			existingHoliday.setDesignation(holiday.getDesignation());
			existingHoliday.setEmploymentType(holiday.getEmploymentType());
			return holidayDao.save(existingHoliday);
		} else {
			throw new RuntimeException("Holiday not found with id " + id);
		}
	}

	public void deleteHoliday(Long id) {
		holidayDao.deleteById(id);
	}

}
