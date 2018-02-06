package atsistemas.prueba.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderDto implements Serializable{

	private static final long serialVersionUID = -937732802820681459L;
	
	private Integer id;
	private String name,location,phone;
	
	public ProviderDto(){}
	
	public ProviderDto(Integer id, String name, String location, String phone) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.phone = phone;
	}

}
