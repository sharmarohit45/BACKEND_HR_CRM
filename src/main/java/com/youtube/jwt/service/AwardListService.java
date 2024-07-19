package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.AwardListDao;
import com.youtube.jwt.entity.AwardList;

@Service
public class AwardListService {
	 @Autowired
	    private AwardListDao awardListDao;
	    
	    public List<AwardList> getAllAwards() {
	        return awardListDao.findAll();
	    }

	    public AwardList getAwardById(Long awardListId) {
	        Optional<AwardList> awardList = awardListDao.findById(awardListId);
	        return awardList.orElse(null);
	    }

	    public AwardList saveAward(AwardList awardList) {
	        return awardListDao.save(awardList);
	    }

	    public void deleteAward(Long awardId) {
	        awardListDao.deleteById(awardId);
	    }
}
