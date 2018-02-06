package atsistemas.prueba.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Sale{

	@Id
	@GeneratedValue
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date saledate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY)
	private Restaurant restaurant;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="sales")
	private List<Product> products = new ArrayList<>();
}
