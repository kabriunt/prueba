package atsistemas.prueba.service.Employee;

import java.util.List;


import atsistemas.prueba.dto.EmployeeDto;
import atsistemas.prueba.model.Employee;

public interface EmployeeService {
	
	
	public EmployeeDto map (Employee e);
	
	public Employee map(EmployeeDto dto);

	
	/**
	 * Busca todos los empleados existentes
	 * 
	 * @return List<EmployeeDto>
	 * @param  Integer, Integer
	 * @throws NotFoundException 
	 */
	public List<EmployeeDto> findAll(Integer page, Integer size)/*throws NotFoundException*/;


	public EmployeeDto findById(Integer id) /*throws NotFoundException*/;

	public EmployeeDto create(EmployeeDto employeeDto) /*throws InvalidDataException,*/ /*throws NotFoundException*/;
	
	public void update(EmployeeDto employeeDto) /*throws NotFoundException*/;

	public void delete(Integer id);
	
//	public boolean validate(employeeDto e);


	
	
	
}
