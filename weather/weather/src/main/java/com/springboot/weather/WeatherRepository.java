package com.springboot.weather;

import org.springframework.data.repository.CrudRepository;


public interface WeatherRepository extends CrudRepository<Weather,String>{

}
