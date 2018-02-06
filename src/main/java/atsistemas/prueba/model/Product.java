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
public class Product {

	@Id
	@GeneratedValue
	private String id;
	
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="products")
	private List<Restaurant> restaurants = new ArrayList<>();
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="products")
	private List<Sale> sales = new ArrayList<>();
}
