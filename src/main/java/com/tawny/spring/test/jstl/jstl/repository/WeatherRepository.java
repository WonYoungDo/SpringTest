package com.tawny.spring.test.jstl.jstl.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tawny.spring.test.jstl.jstl.domain.Weather;

@Repository
public interface WeatherRepository {
	
	public List<Weather> selectWeather();
	
	public int insertWeather(
			@Param("date") Date date
			, @Param("weather") String weather
			, @Param("microDust") String microDust
			, @Param("temperatures") double temperatures
			, @Param("precipitation") double precipitation
			, @Param("windSpeed") double windSpeed);


	public int insertWeatherByObject(Weather weather);
}
