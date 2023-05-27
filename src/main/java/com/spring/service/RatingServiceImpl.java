package com.spring.service;

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

}
