package com.spring.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.ReserveVO;

@Repository
public class InfoDAOImpl implements InfoDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace ="com.spring.mapper.SearchMapper";
	
	@Override
	public List<ReserveVO> myInfoSearch(String reserve_name, String reserve_phone){
		
		Map<String, Object> parameter = new HashMap<>();
	    if (reserve_name != null && !reserve_name.isEmpty()) {
	    	parameter.put("reserve_name", reserve_name);
	    }
	    if (reserve_phone != null && !reserve_phone.isEmpty()) {
	    	parameter.put("reserve_phone", reserve_phone);
	    }
	    
	    return sqlSession.selectList(namespace + ".myInfoSearch", parameter);
	}
	
	@Override
	public void deleteReservation(int reserve_id) {
		sqlSession.delete(namespace +".deleteReservation", reserve_id);
	}
	

}