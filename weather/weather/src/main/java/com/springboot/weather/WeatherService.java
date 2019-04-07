package com.springboot.weather;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;
	private static Properties weatherProps;

	static {
		try {
			weatherProps = new Properties();
			weatherProps.load(new FileInputStream(new File("weather.properties")));
		} catch (FileNotFoundException ex) {
			System.out.println("There is a FileNotFoundException :" + ex);
		} catch (IOException ioex) {
			System.out.println("There is a IOException :" + ioex);
		}
	}

	public String getUrl(String location) {
		return weatherRepository.findById(location).get().getURL();
	}

	public void setAllURL() {
		Set<Object> locationKey = weatherProps.keySet();
		for (Object o : locationKey) {
			weatherRepository.save(new Weather(o.toString(), weatherProps.get(o).toString()));
		}
	}
}
