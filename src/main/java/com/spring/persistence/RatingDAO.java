package com.spring.persistence;

import java.util.List;

import com.spring.domain.RatingVO;

public interface RatingDAO {
	
	public void insertRate(RatingVO ratingVO);
	
	public List<RatingVO> selectRate(int loc_id);
	
	boolean existRate(int reserve_id);

}
