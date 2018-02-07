package atsistemas.prueba.service.Restaurant;

import java.util.List;
import atsistemas.prueba.dto.RestaurantDto;
import atsistemas.prueba.model.Restaurant;

public interface RestaurantService {
	
	Restaurant map(RestaurantDto restaurantDto);
	
	RestaurantDto map(Restaurant restaurant);
	
	List<RestaurantDto> findAll(Integer pages, Integer size);
	
	RestaurantDto findById(Integer id);
	
	RestaurantDto create(RestaurantDto restaurantDto);
	
	void update(RestaurantDto restaurantDto);
	
	void delete (Integer id);
	
}
