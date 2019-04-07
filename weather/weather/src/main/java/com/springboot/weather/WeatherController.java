package com.springboot.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;

	@RequestMapping("/weather/{location}")
	@GetMapping("/redirectWithRedirectView")
	public RedirectView getWeather(RedirectAttributes attributes, @PathVariable String location) {
		weatherService.setAllURL();
		return new RedirectView(weatherService.getUrl(location));
	}

	@RequestMapping("/weather")
	@GetMapping("/redirectWithRedirectView")
	public RedirectView getWeather(RedirectAttributes attributes) {
		return new RedirectView("https://www.accuweather.com/");
	}
}
