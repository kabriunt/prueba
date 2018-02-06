package atsistemas.prueba.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product{

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Restaurant restaurant;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Sale> sales = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Provider provider;
}
