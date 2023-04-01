package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
	    List<String> searchResult = searchService.listSearch(keyword);
	    if (searchResult.isEmpty()) {
          model.addAttribute("errorMessage", "검색 결과가 없습니다.");
      } else {
          model.addAttribute("searchResult", searchResult);
      }
      return "map";
  }
}