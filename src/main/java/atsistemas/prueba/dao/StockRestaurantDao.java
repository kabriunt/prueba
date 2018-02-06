package atsistemas.prueba.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import atsistemas.prueba.model.StockRestaurant;

public interface StockRestaurantDao extends PagingAndSortingRepository<StockRestaurant,Integer> {

}
