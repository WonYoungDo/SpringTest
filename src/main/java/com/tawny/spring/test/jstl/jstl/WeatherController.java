package com.tawny.spring.test.jstl.jstl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/jstl/weather")
@Controller
public class WeatherController {
	
	@GetMapping("/info")
	public String weather() {
		return "jstl/weather/weather";
	}
}
