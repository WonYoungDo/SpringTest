package com.tawny.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tawny.spring.test.jsp.service.SellerService;

@RequestMapping("/jsp/seller")
@Controller
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@ResponseBody
	@PostMapping("/1")
	public String creatSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature)	{
		int count = sellerService.addSeller(nickname, profileImage, temperature);
		return "입력성공 : " + count;
	}
	
	@GetMapping("/input")
	public String inputSeller() {
		return "/jsp/sellerInput";
	}
}
