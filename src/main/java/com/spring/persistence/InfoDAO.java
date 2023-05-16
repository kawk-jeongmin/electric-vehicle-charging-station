package com.spring.persistence;

import java.util.List;

import com.spring.domain.ReserveVO;

public interface InfoDAO {
	
	public List<ReserveVO> myInfoSearch(String reserve_name, String reserve_phone);
	
	public void deleteReservation(int reserve_id);
	
}
