package atsistemas.prueba.service.Restaurant;

import java.util.List;
import atsistemas.prueba.dto.RestaurantDto;

public interface RestaurantService {
	
	List<RestaurantDto> findAll();
	
	RestaurantDto findOne(Integer id);
	
	RestaurantDto create(RestaurantDto restaurantDto);
	
	void update(RestaurantDto restaurantDto);
	
	void delete (Integer id);
	
}
