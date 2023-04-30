package com.spring.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.ReserveVO;
import com.spring.service.ReserveService;

@Controller
public class ReserveController {
	
	@Autowired
    private ReserveService reserveService;
	
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
	
	//reserveForm에서 받아온 데이터를 db에 저장하고 reserve로 이동
	@PostMapping("/reserves")
    public String reserve(@RequestParam("loc_id") int loc_id,
                          @RequestParam("loc_name") String loc_name,
                          @RequestParam("address") String address,
                          @RequestParam("user_name") String user_name,
                          @RequestParam("user_phone") String user_phone,
                          @RequestParam("charge_type") String charge_type,
                          @RequestParam("reserve_time") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime reserve_time,
                          Model model) {
        ReserveVO reserveVO = new ReserveVO();
        reserveVO.setLoc_id(loc_id);
        reserveVO.setLoc_name(loc_name);
        reserveVO.setAddress(address);
        reserveVO.setUser_name(user_name);
        reserveVO.setUser_phone(user_phone);
        reserveVO.setCharge_type(charge_type);
        reserveVO.setReserve_time(reserve_time);

        reserveService.insertReservation(reserveVO);

        model.addAttribute("loc_id", loc_id);
        model.addAttribute("loc_name", loc_name);
        model.addAttribute("address", address);
        model.addAttribute("user_name", user_name);
        model.addAttribute("user_phone", user_phone);
        model.addAttribute("charge_type", charge_type);
        model.addAttribute("reserve_time", reserve_time);

        return "reserve";
    }

}
