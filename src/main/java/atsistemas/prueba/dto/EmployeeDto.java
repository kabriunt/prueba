package atsistemas.prueba.dto;

import java.io.Serializable;

import atsistemas.prueba.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto implements Serializable {

	private static final long serialVersionUID = 668545598518153456L;

	private Integer id, restaurant;

	private String name;
	
	private String email;
	
	private String phone;
	
	public EmployeeDto (Integer id, Restaurant restaurant, String name, String email, String phone) {
		this.id=id;
		this.restaurant = restaurant.getId();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public EmployeeDto() {}

}
