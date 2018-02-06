package atsistemas.prueba.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import atsistemas.prueba.model.Sale;

public interface SaleDao extends PagingAndSortingRepository<Sale,Integer>{

}
