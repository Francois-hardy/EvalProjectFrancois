package com.weather.showweather.delegate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class WeatherServiceDelegate {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callWeatherServiceAndGetData_Fallback")
	public String callWeatherServiceAndGetData(String ville) {
		System.out.println("Getting weather details for " + ville);
		String response = restTemplate
				.exchange("http://localhost:8080/getWeatherByCity/{ville}"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, ville).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - City Name -  " + ville + " :::  Weather Details " + response + " -  " + new Date();
	}

	@HystrixCommand(fallbackMethod = "callWeatherServiceAndGetData_Fallback")
	public String callWeatherServiceAndGetDataByZipcode(String zipcode) {
		System.out.println("Getting weather details for " + zipcode);
		String response = restTemplate
				.exchange("http://localhost:8080/getWeatherByZipcode/{zipcode}"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}, zipcode).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - City Name -  " + zipcode + " :::  Weather Details " + response + " -  " + new Date();
	}
	
	@SuppressWarnings("unused")
	private String callWeatherServiceAndGetData_Fallback(String ville) {
		System.out.println("Weather Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Student Service at this moment. Service will be back shortly - " + new Date();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
