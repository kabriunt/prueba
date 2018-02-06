package atsistemas.prueba.dto;

import java.io.Serializable;
import java.util.Date;


import atsistemas.prueba.model.Employee;
import atsistemas.prueba.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDto  implements Serializable{

	private static final long serialVersionUID = -3580071187275557767L;

	private Integer id, restaurant, employee;
	
	private Date saledate;
	
	public SaleDto (Integer id, Restaurant restaurant, Employee employee, Date saledate) {
		this.id=id;
		this.restaurant = restaurant.getId();
		this.employee = employee.getId();
		this.saledate = saledate;
	}
}
