package com.spring.persistence;

import java.util.List;

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
    
    @Override
    public List<RatingVO> selectRate(int loc_id){
    	return sqlSession.selectList(namespace + ".selectRate", loc_id);
    }
    
    @Override
    public boolean existRate(int reserve_id) {
    	int count = sqlSession.selectOne(namespace + ".existRate", reserve_id);
    	return count > 0;
    }

}
