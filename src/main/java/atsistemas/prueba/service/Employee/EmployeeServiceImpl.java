package atsistemas.prueba.service.Employee;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import atsistemas.prueba.dao.EmployeeDao;
import atsistemas.prueba.dto.EmployeeDto;
import atsistemas.prueba.model.Employee;
import atsistemas.prueba.model.Restaurant;
import atsistemas.prueba.service.Restaurant.RestaurantService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DozerBeanMapper mapper;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Override 
	public EmployeeDto map (Employee e) {
		return mapper.map(e, EmployeeDto.class);
	}
	
//	mapeador de empleado a DTO
	@Override
	public Employee map(EmployeeDto dto) {
		final Employee p;
		if (dto.getId() != null && employeeDao.exists(dto.getId())) {
			p = employeeDao.findOne(dto.getId());
		} else {
			p = new Employee();
		}
//		u.setId(dto.getId()); el id no se pone para proteger el control
		final Restaurant restaurant = restaurantService.map(restaurantService.findById(dto.getRestaurant()));
		p.setName(dto.getName());
		p.setEmail(dto.getEmail());
		p.setPhone(dto.getPhone());
		p.setRestaurant(restaurant);
		return p;
	}
	
	@Override
	public List<EmployeeDto> findAll(Integer page, Integer size)/*throws NotFoundException*/{
		log.info("se van a buscar todas los empleados...");
		final Iterable<Employee> findAll = employeeDao.findAll(new PageRequest(page,size));
			final List<EmployeeDto> res = new ArrayList<>();
			findAll.forEach(e -> {
				res.add(map(e));
			});
			return res;
		
//		log.info("Excepción: No se han encontrado empleados");
//		throw new NotFoundException();
	}
	
	@Override
	public EmployeeDto findById(Integer id) /*throws NotFoundException*/{
		log.info("se va a buscar el empleado con id con "+id);
		final Employee e = employeeDao.findOne(id);	 
		return map(e);
//		throw new NotFoundException();
	}
	
	@Override
	public EmployeeDto create(EmployeeDto employeeDto) /*throws InvalidDataException,*/ /*throws NotFoundException*/ {
		log.info("Intentando crear la cita...");
//		if(validate(employeeDto))
			return map(employeeDao.save(map(employeeDto)));
//		log.info("Excepción: Alguno de los campos no contiene datos correctos o están vacios");
//		throw new InvalidDataException("Datos incorrectos");
	}
	
	@Override
	public void update(EmployeeDto employeeDto) /*throws NotFoundException*/ {
		log.info("Actualizando cita...");
		employeeDao.save(map(employeeDto));
	}
	
	@Override
	public void delete(Integer id) {
		log.info("Borrando cita...");
		employeeDao.delete(id);
	}
/*	
	public boolean validate(employeeDto e) {
		return e!= null && e.getRestaurant()!= null; /* && d.getMedicalVisit() != null
	} */
}
