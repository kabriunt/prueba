package atsistemas.prueba.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Restaurant implements Serializable{
	
	private static final long serialVersionUID = 1477279438283912003L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String location;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
	private List<Sale> sales = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
	private List<Employee> employees = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "restaurants")
	private List<Product> products = new ArrayList<>();
}
