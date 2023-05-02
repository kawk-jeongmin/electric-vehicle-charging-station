package com.spring.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	//reserveForm에서 받아온 데이터를 db에 저장하고 reserve로 이동
	@PostMapping("/reserves")
	public String reserve(@ModelAttribute ReserveVO reserveVO, Model model) {
		Date date = reserveVO.getReserve_time();
		LocalDateTime reserveTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	    reserveService.insertReservation(reserveVO);
	    model.addAttribute("loc_id", reserveVO.getLoc_id());
        model.addAttribute("loc_name", reserveVO.getLoc_name());
        model.addAttribute("address", reserveVO.getAddress());
        model.addAttribute("user_name", reserveVO.getUser_name());
        model.addAttribute("user_phone", reserveVO.getUser_phone());
        model.addAttribute("charge_type", reserveVO.getCharge_type());
        model.addAttribute("reserve_time", reserveTime);

	    return "reserve";
	}
	

}
