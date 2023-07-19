package com.tawny.spring.test.jstl.jstl.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.spring.test.jstl.jstl.domain.Weather;
import com.tawny.spring.test.jstl.jstl.repository.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	public List<Weather> getWeather() {
		List<Weather> weather = weatherRepository.selectWeather();
		return weather;
	}
	
	
	public int addWeather(
			Date date
			, String weather
			, String microDust
			, double temperatures
			, double precipitation
			, double windSpeed) {
		int count = weatherRepository.insertWeather(
				date
				, weather
				, microDust
				, temperatures
				, precipitation
				, windSpeed);
		return count;
	}
	
	
	
	
	
}
