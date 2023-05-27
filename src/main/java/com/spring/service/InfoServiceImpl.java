package com.spring.service;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
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
	        myInfo.put("loc_id",reserveVO.getLoc_id());
	        myInfo.put("loc_name",reserveVO.getLoc_name());
	        myInfo.put("reserve_id",reserveVO.getReserve_id());
	        myInfo.put("user_name", reserveVO.getUser_name());
	        myInfo.put("user_phone", reserveVO.getUser_phone());
	        myInfo.put("address", reserveVO.getAddress());
	        myInfo.put("charge_type", reserveVO.getCharge_type());
	        
	        LocalDateTime currentDateTime = LocalDateTime.now();
	        LocalDateTime thresholdDateTime = currentDateTime.minusMinutes(5);
	        
	        Date reserveDate = reserveVO.getReserve_date();
	        Time reserveTime = reserveVO.getReserve_time();
	        
	        LocalDateTime reserveDateTime = LocalDateTime.of(
	                reserveDate.toLocalDate(),
	                reserveTime.toLocalTime()
	        );
	      
	        
	        String status;
	        if (reserveDateTime.isBefore(thresholdDateTime)) {
	            status = "과거";
	        } else if (reserveDateTime.isAfter(currentDateTime)) {
	            status = "미래";
	        } else {
	            status = "현재";
	        }
	        
	        myInfo.put("reserve_date", reserveVO.getReserve_date() != null ? reserveVO.getReserve_date().toString() : "null");
	        myInfo.put("reserve_time", reserveVO.getReserve_time() != null ? reserveVO.getReserve_time().toString() : "null");
	        myInfo.put("status", status);
	        
	        Duration duration = Duration.between(currentDateTime, reserveDateTime.plusMinutes(5));
            long secondsRemaining = duration.getSeconds();
            long minutesRemaining = secondsRemaining / 60;
            long seconds = secondsRemaining % 60;
            String timeRemaining = String.format("%d:%02d", minutesRemaining, seconds);
            myInfo.put("time_remaining", timeRemaining);
	        
	        myInfoList.add(myInfo);
	    }
	    return myInfoList;
	}
	
	@Override
	public void deleteReservation(int reserve_id) {
		infoDAO.deleteReservation(reserve_id);
	}
}
