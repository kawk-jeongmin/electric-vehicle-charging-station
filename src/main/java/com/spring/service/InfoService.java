package com.spring.service;

import java.util.List;
import java.util.Map;

public interface InfoService{
	
	public List<Map<String, Object>> myInfoSearch(String reserve_name, String reserve_phone);

}
