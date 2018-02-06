package atsistemas.prueba.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"idRestaurant", "idProduct"}))
public class StockRestaurant {
	
	@OneToOne(fetch = FetchType.LAZY)
	private String idRestaurant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private String idProduct;
	
	private Integer stock;
	
}
