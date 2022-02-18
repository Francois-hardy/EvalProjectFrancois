package com.weather.showweather.controller;

import com.weather.showweather.delegate.WeatherServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowWeatherServiceController {
	
	@Autowired
	WeatherServiceDelegate weatherServiceDelegate;

	@RequestMapping(value = "/getWeatherByCity/{ville}", method = RequestMethod.GET)
	public String getWeatherByCity(@PathVariable String ville) {
		System.out.println("Going to call weather service to get data!");
		return weatherServiceDelegate.callWeatherServiceAndGetData(ville);
	}

	@RequestMapping(value = "/getWeatherByZipcode/{zipcode}", method = RequestMethod.GET)
	public String getWeatherByZipcode(@PathVariable String zipcode) {
		System.out.println("Going to call weather service to get data!");
		return weatherServiceDelegate.callWeatherServiceAndGetDataByZipcode(zipcode);
	}
	
}
