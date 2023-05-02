package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.ReserveVO;
import com.spring.persistence.ReserveDAO;

@Service
public class ReserveServiceImpl implements ReserveService {
	
	@Autowired
    private ReserveDAO reserveDAO;
    
	@Override
    public void insertReservation(ReserveVO reserveVO) {
        ReserveVO reserve = new ReserveVO();
        reserve.setLoc_id(reserveVO.getLoc_id());
        reserve.setLoc_name(reserveVO.getLoc_name());
        reserve.setAddress(reserveVO.getAddress());
        reserve.setUser_name(reserveVO.getUser_name());
        reserve.setUser_phone(reserveVO.getUser_phone());
        reserve.setCharge_type(reserveVO.getCharge_type());
        reserve.setReserve_time(reserveVO.getReserve_time());

        reserveDAO.insertReservation(reserve);
    }

}
