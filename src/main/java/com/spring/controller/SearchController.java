package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.SearchVO;
import com.spring.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
	    List<SearchVO> searchResult = searchService.listSearch(keyword);
	    List<Map<String, Object>> locInfoList = new ArrayList<>();
	    if (searchResult.isEmpty()) {
          model.addAttribute("errorMessage", "검색 결과가 없습니다.");
      } else {
	    for(SearchVO searchVO : searchResult) {
	    	Map<String, Object> locInfo = new HashMap<>();
	    	locInfo.put("loc_id", searchVO.getLoc_id());
	    	locInfo.put("loc_name", searchVO.getLoc_name());
	    	locInfo.put("address", searchVO.getAddress());
	    	locInfoList.add(locInfo);
	    }
	    model.addAttribute("locInfoList", locInfoList);
      }
	    return "map";
	}
}