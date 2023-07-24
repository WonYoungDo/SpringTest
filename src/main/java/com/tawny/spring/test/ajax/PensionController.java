package com.tawny.spring.test.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tawny.spring.test.ajax.domain.Pension;
import com.tawny.spring.test.ajax.service.PensionService;

@Controller
@RequestMapping("/ajax/pension")
public class PensionController {
	
	@Autowired
	private PensionService pensionService; 
	
	@GetMapping("/info")
	public String pensionInfo() {
		return "ajax/pension/pension";
	}
	
	
	
	@GetMapping("/booking")
	public String reservation() {
		return "ajax/pension/booking";
	}
	
	
	
	// 모든 쿼리 불러오기
	@GetMapping("/bookingList")
	public String reservationList(Model model) {
		List<Pension> bookingList = pensionService.getBooking();
		model.addAttribute("bookingList", bookingList);
		return "ajax/pension/bookingList";
	}
	
	
	
}
