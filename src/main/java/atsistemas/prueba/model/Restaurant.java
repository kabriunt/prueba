package atsistemas.prueba.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Restaurant{
	
	@Id
	@GeneratedValue
	private Integer id;
<<<<<<< HEAD
	
=======
>>>>>>> branch 'master' of https://github.com/kabriunt/prueba.git
	private String location;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
	private List<Sale> sales = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
	private List<Employee> employees = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
	private List<Product> products = new ArrayList<>();
}
