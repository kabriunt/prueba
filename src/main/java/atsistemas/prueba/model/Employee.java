package atsistemas.prueba.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee{

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String phone;

	@ManyToOne (fetch = FetchType.LAZY)
	private Restaurant restaurant;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private List<Sale> sales = new ArrayList<>();

}