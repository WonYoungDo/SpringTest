package com.tawny.spring.test.jstl.jstl.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tawny.spring.test.jstl.jstl.domain.Weather;

@Repository
public interface WeatherRepository {
	
	public List<Weather> selectWeather();
}
