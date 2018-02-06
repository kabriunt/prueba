package atsistemas.prueba.model;

import java.io.Serializable;

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
public class StockRestaurant  implements Serializable{

	private static final long serialVersionUID = 1789177101733760860L;

	@OneToOne(fetch = FetchType.LAZY)
	private Integer idRestaurant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Integer idProduct;
	
	private Integer stock;
	
}
