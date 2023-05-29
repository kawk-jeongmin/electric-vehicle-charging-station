package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.domain.RatingVO;
import com.spring.persistence.RatingDAO;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Inject
	private RatingDAO ratingDAO;
	
	@Override
	public void insertRate(RatingVO ratingVO) {
		ratingDAO.insertRate(ratingVO);
	}
	
	@Override
	public List<RatingVO> selectRate(int loc_id){
		return ratingDAO.selectRate(loc_id);
	}
	
	@Override
	public boolean existRate(int reserve_id) {
		return ratingDAO.existRate(reserve_id);
	}

}
