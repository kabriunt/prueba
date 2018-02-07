package atsistemas.prueba.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import atsistemas.prueba.model.Sale;

@Repository
public interface SaleDao extends PagingAndSortingRepository<Sale,Integer>{

}
