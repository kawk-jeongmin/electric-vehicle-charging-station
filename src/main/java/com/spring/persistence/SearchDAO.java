package com.spring.persistence;

import java.util.List;

import com.spring.domain.SearchVO;

public interface SearchDAO {
	
	public List<SearchVO> listSearch(String keyword);

}
