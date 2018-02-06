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
public class Provider implements Serializable {
	
	private static final long serialVersionUID = -7875756553942958427L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name,location,phone;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "provider")
	private List<Product> products = new ArrayList<>();
	
}
