package atsistemas.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import atsistemas.prueba.service.Restaurant.RestaurantService;
import atsistemas.prueba.dto.RestaurantDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<RestaurantDto> getAll(@PageableDefault(page=0,size=10)Pageable pageable){
		return restaurantService.findAll(pageable.getPageNumber(),pageable.getPageSize());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public RestaurantDto getById(@PathVariable(value = "id") Integer id) {
		return restaurantService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public RestaurantDto create(@RequestBody RestaurantDto restaurantDto) {
		return restaurantService.create(restaurantDto);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody RestaurantDto restaurantDto) {
		restaurantService.update(restaurantDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Integer id) {
		restaurantService.delete(id);
	}
	
}
