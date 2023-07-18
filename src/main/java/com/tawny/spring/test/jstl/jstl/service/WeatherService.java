package com.tawny.spring.test.jstl.jstl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.spring.test.jstl.jstl.domain.Weather;
import com.tawny.spring.test.jstl.jstl.repository.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	public List<Weather> addWeather() {
		List<Weather> weather = weatherRepository.selectWeather();
		return weather;
	}
	
	
}
