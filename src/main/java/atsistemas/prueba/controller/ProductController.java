package atsistemas.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import atsistemas.prueba.dto.ProductDto;
import atsistemas.prueba.service.Product.ProductService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ProductDto> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Productos");
		return productService.findAll(page,size);		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{idProduct}")
	public ProductDto findOneById(@PathVariable Integer idProduct) throws Exception{
		log.info("Recuperando Producta con Id = " + idProduct);
		return productService.findById(idProduct);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/name={nameProduct}")
	public List<ProductDto> findByName(@PathVariable String nameProduct){
		log.info("Recuperando Producto con nombre = " + nameProduct);
		return productService.findByName(nameProduct);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ProductDto create(@RequestBody ProductDto p) {
		log.info("Creando Producto = " + p);
		return productService.create(p);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idProduct}")
	public void update(@PathVariable Integer idProduct, @RequestBody ProductDto p) {
		log.info("Modificando Producto = " + p);
		productService.update(p);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idProduct}")
	public void delete(@PathVariable Integer idProduct){
		log.info("Borrando Producto con Id = " + idProduct);
		productService.delete(idProduct);
	}
}
