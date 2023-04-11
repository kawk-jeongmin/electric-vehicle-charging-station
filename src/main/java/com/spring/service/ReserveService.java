package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.ReserveVO;
import com.spring.persistence.ReserveDAO;

@Service
public class ReserveService {
	
	@Autowired
    private ReserveDAO reserveDAO;
    
    public void insertReservation(ReserveVO reserveVO) {
        reserveDAO.insertReservation(reserveVO);
    }

}
