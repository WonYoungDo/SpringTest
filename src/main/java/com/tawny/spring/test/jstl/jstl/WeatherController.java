package com.tawny.spring.test.jstl.jstl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tawny.spring.test.jstl.jstl.domain.Weather;
import com.tawny.spring.test.jstl.jstl.service.WeatherService;

@RequestMapping("/jstl/weather")
@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/info")
	public String weather(Model model) {
		
		List<Weather> weatherList = weatherService.addWeather();
		
		model.addAttribute("weatherList", weatherList);
		
		return "jstl/weather/weather";
	}
	

	@GetMapping("/input")
	public String weatherInput() {
		return "jstl/weather/weatherInput";
	}
}
