package com.weather.weather.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.weather.weather.model.Weather;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WeatherController {

	List<Weather> weathers = new ArrayList<>();
	{
		weathers.add(new Weather("Mougins","06000","FR", "16 degres"));
		weathers.add(new Weather("Marseille","13000","FR", "18 degres"));
		weathers.add(new Weather("Rome","23000","IT", "26 degres"));
		weathers.add(new Weather("Milan","11000","IT", "11 degres"));
	}

	@RequestMapping(value = "/getWeatherByCity/{ville}")
	public Weather getWeatherByCity(@PathVariable(value = "ville") String name) {
		return weathers.stream().filter(x -> x.getNom().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
	}

	@RequestMapping(value = "/getWeatherByZipcode/{zipcode}")
	public Weather getWeatherByZipcode(@PathVariable(value = "zipcode") String zipcode) {
		return weathers.stream().filter(x -> x.getZipCode().equals(zipcode)).collect(Collectors.toList()).get(0);
	}

	@RequestMapping(value = "/getWeatherByCountry/{pays}")
	public List<Weather> getStudentByCountry(@PathVariable(value = "pays") String pays) {
		System.out.println("Searching weathers in country : " + pays);
		List<Weather> studentsByCountry = weathers.stream().filter(x -> x.getPays().equalsIgnoreCase(pays))
				.collect(Collectors.toList());
		System.out.println(studentsByCountry);
		return studentsByCountry;
	}

}
