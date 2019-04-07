package com.springboot.weather;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Weather {
	
	@Id
	private String location;
	private String locationUrl;
	
	public Weather() {
		
	}
	
	public Weather(String location, String locationUrl) {
		super();
		this.location = location;
		this.locationUrl = locationUrl;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getURL() {
		return locationUrl;
	}
	public void setURL(String locationUrl) {
		this.locationUrl = locationUrl;
	}

}
