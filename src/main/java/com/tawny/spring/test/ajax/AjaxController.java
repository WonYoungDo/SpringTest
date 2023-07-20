package com.tawny.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tawny.spring.test.ajax.domain.Favorite;
import com.tawny.spring.test.ajax.service.FavoriteService;

@Controller
@RequestMapping("/ajax/test")
public class AjaxController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	
	// input 페이지 보여주는 메소드
	@GetMapping("/input")
	public String forvoriteInput() {
		return "ajax/farvoriteInput";
	}
	
	
	// select 쿼리 얻기
	@GetMapping("/list")
	public String forvoriteInfo(Model model) {
		List<Favorite> favoriteList = favoriteService.getFavorite();
		model.addAttribute("favorite", favoriteList);
		return "ajax/favorite";
	}
	
	
	//
	@PostMapping("/add")
	public Map<String, String> createFavorite(
			@RequestParam("name") String name
			, @RequestParam("address") String address) {
		
		int count = favoriteService.addFavorite(name, address);
		
		// 실행 결과 성공 여부
		// 성공 : {"result" : success}
		// 실패 : {"result" : fail}
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {// 성공
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");	
		}
		
		return resultMap;
	}
	

	
	
	
}
