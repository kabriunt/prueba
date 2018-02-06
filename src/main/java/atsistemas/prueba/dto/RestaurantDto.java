package atsistemas.prueba.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantDto implements Serializable {

	private static final long serialVersionUID = 8727858579023760040L;

	private Integer id;
	private String location;
	
	public RestaurantDto(){}
	
	public RestaurantDto(Integer id, String location) {
		this.id = id;
		this.location = location;
	}
}
