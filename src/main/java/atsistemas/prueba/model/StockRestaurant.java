package atsistemas.prueba.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StockRestaurant{
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Restaurant idRestaurant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Product idProduct;
	
	private Integer stock;
	
}
