package com.tawny.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tawny.spring.test.jsp.domain.Seller;
import com.tawny.spring.test.jsp.service.SellerService;

@RequestMapping("/jsp/seller")
@Controller
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@ResponseBody
	@PostMapping("/add")
	public String creatSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature)	{
		int count = sellerService.addSeller(nickname, profileImage, temperature);
		return "입력성공 : " + count;
	}
	
	
	// 판매자 추가 화면
	@GetMapping("/input")
	public String inputSeller() {
		return "jsp/sellerInput";
	}
	
	
	// 최근 판매자 조회
	@GetMapping("/info")
	public String sellerInfo(Model model) {
		Seller seller = sellerService.getSellerInfo();
		model.addAttribute("seller", seller);
		return "jsp/sellerInfo";
	}
	
	
	// id를 기반으로 판매자 조회
	@GetMapping("/seller_info")
	public String seller(@RequestParam(value="id", required=false) Integer id, Model model) {
		
		Seller seller = null;
		
		if(id == null) { // 파라미터가 없는 경우
			seller = sellerService.getSellerInfo();
			model.addAttribute("seller", seller);
			
		} else { // id 값이 전달 된 경우			
			seller = sellerService.getSeller(id);
			model.addAttribute("seller", seller);
		}
		
		return "jsp/sellerInfo";
	}
	
}
