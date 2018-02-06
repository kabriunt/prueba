package atsistemas.prueba.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import atsistemas.prueba.model.Employee;

public interface EmployeeDao extends PagingAndSortingRepository<Employee,Integer>{

}
