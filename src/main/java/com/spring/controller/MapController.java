package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {
	
	@GetMapping("/map")
	public String getMap(Model model) {
		model.addAttribute("appKey", "91ddb989957b19faffb682a0e6d6fc8a");
		model.addAttribute("x", 126.73679290415274);
        model.addAttribute("y", 37.508781018659796);
        return "map";
	}

}
