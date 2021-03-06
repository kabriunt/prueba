package atsistemas.prueba.service.Restaurant;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	
	@Override
	public Restaurant map(RestaurantDto r) {
		Restaurant restaurant = restaurantDao.findOne(r.getId());
		if(restaurant == null)
			restaurant = new Restaurant();
		restaurant.setId(r.getId());
		restaurant.setLocation(r.getLocation());
		return restaurant;
	}
	
	@Override
	public RestaurantDto map(Restaurant r) {
		return mapper.map(r,RestaurantDto.class);
	}
	
	@Override
	public List<RestaurantDto> findAll(Integer pages, Integer size) {
		Iterable<Restaurant> restaurants = restaurantDao.findAll(new PageRequest(pages,size));
		final List<RestaurantDto> res = new ArrayList<>();
		restaurants.forEach(x->{
			res.add(map(x));
		});
		return res;
	}

	@Override
	public RestaurantDto findById(Integer id) {
		Restaurant restaurant = restaurantDao.findOne(id);
		return map(restaurant);
	}

	@Override
	public RestaurantDto create(RestaurantDto restaurantDto) {
		return map(restaurantDao.save(map(restaurantDto)));
	}

	@Override
	public void update(RestaurantDto restaurantDto) {
		restaurantDao.save(map(restaurantDto));
	}

	@Override
	public void delete(Integer id) {
		restaurantDao.delete(id);	
	}

}
