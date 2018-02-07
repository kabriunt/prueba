package atsistemas.prueba.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import atsistemas.prueba.model.StockRestaurant;

@Repository
public interface StockRestaurantDao extends PagingAndSortingRepository<StockRestaurant,Integer> {

}
