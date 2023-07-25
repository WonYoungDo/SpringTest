package com.tawny.spring.test.ajax;

import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.tawny.spring.test.ajax.domain.Pension;
import com.tawny.spring.test.ajax.service.PensionService;

@Controller
@RequestMapping("/ajax/pension")
public class PensionController {
	
	@Autowired
	private PensionService pensionService; 
	
	// 메인 화면
	@GetMapping("/info")
	public String pensionInfo() {
		return "ajax/pension/pension";
	}
	
	
	// 예약하기 화면
	@GetMapping("/booking")
	public String reservation() {
		return "ajax/pension/booking";
	}
	
	
	// 예약 목록 화면 (기존 쿼리 불러오기)
	@GetMapping("/bookingList")
	public String reservationList(Model model) {
		List<Pension> bookingList = pensionService.getBooking();
		model.addAttribute("bookingList", bookingList);
		return "ajax/pension/bookingList";
	}
	
	
	// 예약자 화면에서 입력된 정보 리스트에 추가하기
	@PostMapping("/add")
	@ResponseBody
	public Map<String, String> createBooking(
			@RequestParam("name") String name
			, @RequestParam("headcount") int headcount
			, @RequestParam("day") int day
			, @RequestParam("date") Date date
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("state") String state) {
		int count = pensionService.addBooking(name, headcount, day, date, phoneNumber, state);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	
	// 삭제 버튼 클릭 시 해당 행 삭제
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		
	}
}
