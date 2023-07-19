package com.tawny.spring.test.jstl.jstl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tawny.spring.test.jstl.jstl.domain.Weather;
import com.tawny.spring.test.jstl.jstl.service.WeatherService;

@RequestMapping("/jstl/weather")
@RestController
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	
	
	// 기상청 화면 
	@GetMapping("/info")
	public String weather(Model model) {
		List<Weather> weatherList = weatherService.getWeather();
		model.addAttribute("weatherList", weatherList);
		return "jstl/weather/weather";
	}

	
	// 날씨 입력 화면
	@GetMapping("/input")
	public String weatherInput() {
		return "jstl/weather/weatherInput";
	}
	
	
//	 날씨 추가 후 보여지는 화면 
	@GetMapping("/print")
	public String weatherPrint(
			@RequestParam("date") Date date
			, @RequestParam("weather") String weather
			, @RequestParam("microDust") String microDust
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("windSpeed") double windSpeed
			, Model model) {
		
		Weather addWeather = new Weather();
		addWeather.setDate(date);
		addWeather.setMicroDust(microDust);
		addWeather.setPrecipitation(precipitation);
		addWeather.setTemperatures(temperatures);
		addWeather.setWeather(weather);
		addWeather.setWindSpeed(windSpeed);
		
		model.addAttribute("addWeather", addWeather);
		
		return "jstl/weather/weatherInput";
	}	
	
}
