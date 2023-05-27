package com.spring.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.RatingVO;
import com.spring.service.RatingService;

@Controller
public class RatingController {
	
	@Inject
	private RatingService ratingService;
	
	@PostMapping("/rating")
	public String insertRate(@RequestParam("reserve_id") int reserve_id,
							@RequestParam("loc_id") int loc_id,
							@RequestParam("loc_name") String loc_name,
							@RequestParam("address") String address,
							@RequestParam("charge_type") String charge_type,
							@RequestParam("user_name") String user_name,
							@RequestParam("user_phone") String user_phone,
							Model model) {
		
		model.addAttribute("reserve_id", reserve_id);
		model.addAttribute("loc_id", loc_id);
		model.addAttribute("loc_name", loc_name);
		model.addAttribute("address", address);
		model.addAttribute("user_name", charge_type);
		model.addAttribute("user_name", user_name);
		model.addAttribute("user_phone", user_phone);
		
		return "ratingForm";
	}
	
	@PostMapping("/ratings")
	public String ratings(@RequestParam("reserve_id") int reserve_id,
			@RequestParam("loc_id") int loc_id,
			@RequestParam("loc_name") String loc_name,
			@RequestParam("address") String address,
			@RequestParam("charge_type") String charge_type,
			@RequestParam("user_name") String user_name,
			@RequestParam("user_phone") String user_phone,
			@RequestParam("rate_score") String rate_score,
			@RequestParam("rate_content") String rate_content,
			@RequestParam("rate_date") String rate_date,
			@RequestParam("rate_img") String rate_img,
			Model model) {
		
		RatingVO ratingVO = new RatingVO();
		ratingVO.setReserve_id(reserve_id);
		ratingVO.setLoc_id(loc_id);
		ratingVO.setLoc_name(loc_name);
		ratingVO.setAddress(address);
		ratingVO.setCharge_type(charge_type);
		ratingVO.setUser_name(user_name);
		ratingVO.setUser_phone(user_phone);
		ratingVO.setRate_id(loc_id);
		ratingVO.setRate_score(rate_score);
		ratingVO.setRate_content(rate_content);
		ratingVO.setRate_img(rate_img);
		
		ratingService.insertRate(ratingVO);
		
		return "ratingView";
	}

}
