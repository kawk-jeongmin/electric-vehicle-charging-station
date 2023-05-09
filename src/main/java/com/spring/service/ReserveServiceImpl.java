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

        reserveDAO.insertReservation(reserveVO);
    }

}
