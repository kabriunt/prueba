package atsistemas.prueba.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class ProductDto  implements Serializable {

	private static final long serialVersionUID = 1470255632541969186L;

	@Mapping(value = "id")
	private Integer idProduct;
	
	@Mapping(value = "name")
	private String nameProduct;
	
	@Mapping(value = "restaurant")
	private Integer idRestaurant;

	@Mapping(value = "sales")
	private List<Integer> idSales = new ArrayList<>();
	
	@Mapping(value = "provider")
	private Integer idProvider;
}
