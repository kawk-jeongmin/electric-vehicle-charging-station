package com.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.ReserveVO;
import com.spring.persistence.InfoDAO;

@Service
public class InfoServiceImpl implements InfoService{
	
	@Autowired
	private InfoDAO infoDAO;

	@Override
	public List<Map<String, Object>> myInfoSearch(String reserve_name, String reserve_phone) {
	    List<Map<String, Object>> myInfoList = new ArrayList<>();
	    List<ReserveVO> searchResult = infoDAO.myInfoSearch(reserve_name, reserve_phone);
	    for (ReserveVO reserveVO : searchResult) {
	        Map<String, Object> myInfo = new HashMap<>();
	        myInfo.put("reserve_time", reserveVO.getReserve_time());
	        myInfo.put("user_name", reserveVO.getUser_name());
	        myInfo.put("user_phone", reserveVO.getUser_phone());
	        myInfo.put("address", reserveVO.getAddress());
	        myInfo.put("charge_type", reserveVO.getCharge_type());
	        myInfoList.add(myInfo);
	    }
	    return myInfoList;
	}
}
