package atsistemas.prueba.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import atsistemas.prueba.model.Restaurant;

public interface RestaurantDao extends PagingAndSortingRepository<Restaurant,Integer>{

}
