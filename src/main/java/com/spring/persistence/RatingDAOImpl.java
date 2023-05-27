package com.spring.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.RatingVO;

@Repository
public class RatingDAOImpl implements RatingDAO{
	
	@Autowired
    private SqlSession sqlSession;
	
	private static final String namespace ="com.spring.mapper.RatingMapper";

    @Override
    public void insertRate(RatingVO ratingVO) {
        sqlSession.insert(namespace + ".insertRate", ratingVO);
    }

}
