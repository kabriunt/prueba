package atsistemas.prueba.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import atsistemas.prueba.model.Product;

@Repository
public interface ProductDao extends PagingAndSortingRepository<Product,Integer> {

	public List<Product> findByName(String name);
}
