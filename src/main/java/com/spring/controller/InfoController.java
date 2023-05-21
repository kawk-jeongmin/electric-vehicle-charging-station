package com.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring.service.InfoServiceImpl;

@Controller
public class InfoController {
	
	@Autowired
	private InfoServiceImpl infoService;
	
	@PostMapping("/myInfo")
	public String InfoPage() {
		return "/myInfo";
	}
	
	@GetMapping("/myInfoSearch")
	public String search(@RequestParam("reserve_name") String reserve_name, @RequestParam("reserve_phone") String reserve_phone, Model model) throws Exception {
		List<Map<String, Object>> myInfoList = infoService.myInfoSearch(reserve_name, reserve_phone);
	    
		if (myInfoList.isEmpty()) {
			model.addAttribute("errorMessage", "해당하는 정보가 없습니다.");
		}
		else {
			model.addAttribute("myInfoList", myInfoList);
		}
		
		return "myInfo";
	}
	
	
	@PostMapping("/delete")
	public String deleteReservation(@RequestParam("reserve_id") int reserve_id) {
		infoService.deleteReservation(reserve_id);
		
		 return "myInfo";
	}
}

