package atsistemas.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import atsistemas.prueba.dto.SaleDto;
import atsistemas.prueba.service.Sale.SaleService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/sale")
public class SaleController {
	@Autowired
	private SaleService saleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<SaleDto> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Saleos");
		return saleService.findAll(page,size);		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{idSale}")
	public SaleDto findOneById(@PathVariable Integer idSale) throws Exception{
		log.info("Recuperando Venta con Id = " + idSale);
		return saleService.findById(idSale);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/name={nameSale}")
	public List<SaleDto> findByName(@PathVariable String nameSale){
		log.info("Recuperando Ventas con nombre = " + nameSale);
		return saleService.findByName(nameSale);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public SaleDto create(@RequestBody SaleDto s) {
		log.info("Creando Venta = " + s);
		return saleService.create(s);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idSale}")
	public void update(@PathVariable Integer idSale, @RequestBody SaleDto s) {
		log.info("Modificando Venta = " + s);
		saleService.update(s);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idSale}")
	public void delete(@PathVariable Integer idSale){
		log.info("Borrando Saleo con Id = " + idSale);
		SaleService.delete(idSale);
	}
}
