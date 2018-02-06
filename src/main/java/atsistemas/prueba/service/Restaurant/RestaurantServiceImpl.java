package atsistemas.prueba.service.Restaurant;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atsistemas.prueba.dao.RestaurantDao;
import atsistemas.prueba.dto.RestaurantDto;
import atsistemas.prueba.model.Restaurant;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	public Restaurant transform (RestaurantDto r) {
		Restaurant restaurant = restaurantDao.findOne(r.getId());
		if(restaurant == null)
			restaurant = new Restaurant();
		restaurant.setId(r.getId());
		restaurant.setLocation(r.getLocation());
		return restaurant;
	}
	
	public RestaurantDto transform(Restaurant r) {
		return mapper.map(r,RestaurantDto.class);
	}
	
	@Override
	public List<RestaurantDto> findAll() {
		Iterable<Restaurant> restaurants = restaurantDao.findAll();
		final List<RestaurantDto> res = new ArrayList<>();
		restaurants.forEach(x->{
			res.add(transform(x));
		});
		return res;
	}

	@Override
	public RestaurantDto findOne(Integer id) {
		Restaurant restaurant = restaurantDao.findOne(id);
		return transform(restaurant);
	}

	@Override
	public RestaurantDto create(RestaurantDto restaurantDto) {
		return transform(restaurantDao.save(transform(restaurantDto)));
	}

	@Override
	public void update(RestaurantDto restaurantDto) {
		restaurantDao.save(transform(restaurantDto));
	}

	@Override
	public void delete(Integer id) {
		restaurantDao.delete(id);	
	}

}
