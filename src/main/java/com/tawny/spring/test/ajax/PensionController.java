package com.tawny.spring.test.ajax;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	// API
	// 예약자 화면에서 입력된 정보 리스트에 추가하기 ㅌ
	// 이름, 날짜, 일수, 인원, 전화번호
	@GetMapping("/add")
	@ResponseBody 
	public Map<String, String> createBooking(
			@RequestParam("name") String name
			, @RequestParam("headcount") int headcount
			, @RequestParam("day") int day
			, @DateTimeFormat(pattern="yyyy년 MM월 dd일") @RequestParam("date") Date date 
			, @RequestParam("phoneNumber") String phoneNumber) {
		int count = pensionService.addBooking(name, headcount, day, date, phoneNumber);
		
		// 성공 실패 여부에 따라서 json문자열을 Map에 담기
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) { // 성공
			resultMap.put("result", "success");
		} else { // 실패
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	
	// 삭제 버튼 클릭 시 해당 행 삭제
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		int count = pensionService.deleteBooking(id);
		
		Map<String, String> deleteMap = new HashMap<>();
		if(count == 1) {
			deleteMap.put("result", "success");
		} else {
			deleteMap.put("result", "fail");
		}
		return deleteMap;
	}
	
	// 예약확인자 조회 
	// 이름과 전화번호를 전달 받고, 일치하는 예약 정보를 json으로 response에 담는다.
	@GetMapping("/search")
	@ResponseBody
	public Map<String, Object> searchBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		Pension booking = pensionService.searchBooking(name, phoneNumber);
		
		
		// 성공 실패 여부
		// {"result":"success", "info":{"name":"원영도", "headcount":1, "day":2 .....}}
		Map<String, Object> resultMap = new HashMap<>();
		
		if(booking == null) {
			// 조회 실패
			resultMap.put("result", "fail");
		} else {
			// 조회 성공
			resultMap.put("result", "success");
			resultMap.put("info", booking);
		}
		
		return resultMap;
	}
	
}
