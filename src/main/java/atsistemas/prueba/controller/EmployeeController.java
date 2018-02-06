package atsistemas.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import atsistemas.prueba.dto.EmployeeDto;
import atsistemas.prueba.dto.ProductDto;
import atsistemas.prueba.service.Employee.EmployeeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<EmployeeDto> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Empleados");
		return employeeService.findAll(page,size);		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public EmployeeDto findById(@PathVariable(value = "id") Integer id) {
		return employeeService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public EmployeeDto create(@RequestBody EmployeeDto employeeDto) {
		return employeeService.create(employeeDto);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody EmployeeDto employeeDto) {
		employeeService.update(employeeDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Integer id) {
		employeeService.delete(id);
	}
	
	
}
