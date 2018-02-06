package atsistemas.prueba.model;

import java.io.Serializable;
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
public class Employee implements Serializable {

	private static final long serialVersionUID = 1887844984928837480L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	// Relación muchos empleados pertenecen a un único restaurante
	@ManyToOne (fetch = FetchType.LAZY)
	private Restaurant restaurant;
	
	// Relación 1 a n de empleado con ventas
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private List<Sale> sales = new ArrayList<>();

}