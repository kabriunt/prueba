package atsistemas.prueba.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import atsistemas.prueba.model.Product;

public interface ProductDao extends PagingAndSortingRepository<Product,Integer> {

}
