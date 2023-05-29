package com.spring.service;

import java.util.List;

import com.spring.domain.RatingVO;

public interface RatingService {
	
	void insertRate(RatingVO ratingVO);
	
	public List<RatingVO> selectRate(int loc_id);
	
	boolean existRate(int reserve_id);

}
