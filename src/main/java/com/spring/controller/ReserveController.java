package com.spring.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.*;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.ReserveVO;
import com.spring.service.ReserveServiceImpl;

@Controller
public class ReserveController {
	
	@Autowired
    private ReserveServiceImpl reserveService;
	
	//reserveForm으로 충전소 데이터 넘김
	@PostMapping("/reserve")
	public String reserve(@RequestParam("loc_id") int loc_id, 
	                        @RequestParam("loc_name") String loc_name,
	                        @RequestParam("address") String address, Model model) {
        
	    model.addAttribute("loc_id", loc_id);
	    model.addAttribute("loc_name", loc_name);
	    model.addAttribute("address", address);
	    
	    return "reserveForm";
	  }
	
	@PostMapping("/reserves")
    public String reserve(@RequestParam("loc_id") int loc_id,
                          @RequestParam("loc_name") String loc_name,
                          @RequestParam("address") String address,
                          @RequestParam("user_name") String user_name,
                          @RequestParam("user_phone") String user_phone,
                          @RequestParam("charge_type") String charge_type,
                          @RequestParam("reserve_date") String reserve_date,
                          @RequestParam("reserve_time") String reserve_time,
                          Model model) {
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;
		DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_TIME;

		LocalDate parsedDate = LocalDate.parse(reserve_date, dateFormatter);
		LocalTime parsedTime = LocalTime.parse(reserve_time, timeFormatter);

		Date date = java.sql.Date.valueOf(parsedDate);
		Time time = java.sql.Time.valueOf(parsedTime);
		
        ReserveVO reserveVO = new ReserveVO();
        reserveVO.setLoc_id(loc_id);
        reserveVO.setLoc_name(loc_name);
        reserveVO.setAddress(address);
        reserveVO.setUser_name(user_name);
        reserveVO.setUser_phone(user_phone);
        reserveVO.setCharge_type(charge_type);
        reserveVO.setReserve_date(date);
        reserveVO.setReserve_time(time);
        
        reserveService.insertReservation(reserveVO);
        
        model.addAttribute("loc_id", loc_id);
        model.addAttribute("loc_name", loc_name);
        model.addAttribute("address", address);
        model.addAttribute("user_name", user_name);
        model.addAttribute("user_phone", user_phone);
        model.addAttribute("charge_type", charge_type);
        model.addAttribute("reserve_date", date);
        model.addAttribute("reserve_time", time);

        return "reserve";
    }

}
