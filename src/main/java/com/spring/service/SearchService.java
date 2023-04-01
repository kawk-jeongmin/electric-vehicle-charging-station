package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.SearchVO;
import com.spring.persistence.SearchDAO;

@Service
public class SearchService {
	
	@Autowired
	private SearchDAO searchDAO;
	
	public List<String> listSearch(String keyword) {
	    return searchDAO.listSearch(keyword);
	  }

}