package com.spring.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.ReserveVO;

@Repository
public class ReserveDAOImpl implements ReserveDAO{
	
	@Autowired
    private SqlSession sqlSession;
	
	private static final String namespace ="com.spring.mapper.ReserveMapper";

    @Override
    public void insertReservation(ReserveVO reserveVO) {
        sqlSession.insert(namespace + ".insertReservation", reserveVO);
    }

}
