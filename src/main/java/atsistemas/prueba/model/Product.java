package atsistemas.prueba.model;

import java.io.Serializable;
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
public class Product implements Serializable{

	private static final long serialVersionUID = 2524097256299967243L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="products")
	private List<Restaurant> restaurants = new ArrayList<>();
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="products")
	private List<Sale> sales = new ArrayList<>();
}
