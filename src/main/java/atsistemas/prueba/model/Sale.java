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

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Sale implements Serializable{

	private static final long serialVersionUID = -5877884379801168189L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date saledate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY)
	private Restaurant restaurant;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="sale")
	private List<Product> products = new ArrayList<>();
}
