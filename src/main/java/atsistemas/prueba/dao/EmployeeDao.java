package atsistemas.prueba.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import atsistemas.prueba.model.Employee;

@Repository
public interface EmployeeDao extends PagingAndSortingRepository<Employee,Integer>{

}
