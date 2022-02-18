package com.weather.weather.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.weather.weather.model.Weather;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Swagger2DemoRestController", description = "REST Apis related to weather Entity!!!!")
@RestController
public class WeatherController {

	List<Weather> weathers = new ArrayList<>();
	{
		weathers.add(new Weather("Mougins","06000","FR", "16 degres"));
		weathers.add(new Weather("Marseille","13000","FR", "18 degres"));
		weathers.add(new Weather("Rome","23000","IT", "26 degres"));
		weathers.add(new Weather("Milan","11000","IT", "11 degres"));
	}

	@ApiOperation(value = "Get list of weather in the System ", response = Iterable.class, tags = "getWeathers")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })


	@RequestMapping(value = "/getWeathers")
	public List<Weather> getWeathers() {
		return weathers;
	}

	@ApiOperation(value = "Get specific weather in the System by city", response = Weather.class, tags = "getWeatherByCity")
	@RequestMapping(value = "/getWeatherByCity/{ville}")
	public Weather getWeatherByCity(@PathVariable(value = "ville") String name) {
		return weathers.stream().filter(x -> x.getNom().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
	}

	@ApiOperation(value = "Get specific weather in the System by zipcode", response = Weather.class, tags = "getWeatherByZipcode")
	@RequestMapping(value = "/getWeatherByZipcode/{zipcode}")
	public Weather getWeatherByZipcode(@PathVariable(value = "zipcode") String zipcode) {
		return weathers.stream().filter(x -> x.getZipCode().equals(zipcode)).collect(Collectors.toList()).get(0);
	}

	@ApiOperation(value = "Get all weather in the System by country", response = Weather.class, tags = "getWeatherByCountry")
	@RequestMapping(value = "/getWeatherByCountry/{pays}")
	public List<Weather> getStudentByCountry(@PathVariable(value = "pays") String pays) {
		System.out.println("Searching weathers in country : " + pays);
		List<Weather> studentsByCountry = weathers.stream().filter(x -> x.getPays().equalsIgnoreCase(pays))
				.collect(Collectors.toList());
		System.out.println(studentsByCountry);
		return studentsByCountry;
	}

}
