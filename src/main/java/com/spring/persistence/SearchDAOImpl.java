package com.spring.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.SearchVO;

@Repository
public class SearchDAOImpl implements SearchDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace ="com.spring.mapper.SearchMapper";
	
	@Override
	public List<SearchVO> listSearch(String keyword) {
		
		return sqlSession.selectList(namespace +".listSearch", keyword);
	}
	
}
