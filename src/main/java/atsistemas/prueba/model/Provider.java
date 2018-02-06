package atsistemas.prueba.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Provider {
	
	@Id
	@GeneratedValue
	private String id;
	
	private String name,location,phone;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "provider")
	private List<Product> products = new ArrayList<>();
	
}
