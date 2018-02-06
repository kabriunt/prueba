package atsistemas.prueba.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import atsistemas.prueba.model.Provider;


public interface ProviderDao extends PagingAndSortingRepository<Provider,Integer>{

}
