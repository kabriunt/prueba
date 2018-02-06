package atsistemas.prueba.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import atsistemas.prueba.model.Restaurant;

@Repository
public interface RestaurantDao extends PagingAndSortingRepository<Restaurant,Integer>{

}
