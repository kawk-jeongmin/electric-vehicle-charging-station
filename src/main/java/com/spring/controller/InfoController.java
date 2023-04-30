package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.ReserveVO;
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
	public String search(@RequestParam("reserve_name") String reserve_name, @RequestParam("reserve_phone") String reserve_phone, Model model) {
		List<Map<String, Object>> myInfoList = infoService.myInfoSearch(reserve_name, reserve_phone);
		if (myInfoList.isEmpty()) {
			model.addAttribute("errorMessage", "검색 결과가 없습니다.");
		} else {
			model.addAttribute("myInfoList", myInfoList);
		}
		return "myInfo";
	}
}
//	public String search(@RequestParam("reserve_name") String reserve_name, @RequestParam("reserve_phone") String reserve_phone, Model model) {
//	    List<ReserveVO> searchResult = infoService.myInfoSearch(reserve_name, reserve_phone);
//	    List<Map<String, Object>> myInfoList = new ArrayList<>();
//	    if (searchResult.isEmpty()) {
//          model.addAttribute("errorMessage", "검색 결과가 없습니다.");
//      } else {
//	    for(ReserveVO reserveVO : searchResult) {
//	    	Map<String, Object> myInfo = new HashMap<>();
//	    	myInfo.put("reserve_time", reserveVO.getReserve_time());
//	    	myInfo.put("user_name", reserveVO.getUser_name());
//	    	myInfo.put("user_phone", reserveVO.getUser_phone());
//	    	myInfoList.add(myInfo);
//	    }
//	    model.addAttribute("myInfoList", myInfoList);
//      }
//	    return "myInfo";
//	}

