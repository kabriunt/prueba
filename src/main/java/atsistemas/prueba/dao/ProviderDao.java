package atsistemas.prueba.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import atsistemas.prueba.model.Provider;

@Repository
public interface ProviderDao extends PagingAndSortingRepository<Provider,Integer>{

}
