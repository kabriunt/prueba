package atsistemas.prueba.service.Sale;

import java.util.List;

import atsistemas.prueba.dto.SaleDto;
import atsistemas.prueba.model.Sale;

public interface SaleService {
	
	public Sale map (SaleDto s);
	
	public SaleDto map(Sale s);
	
	public List<SaleDto> findAll();
	
	public SaleDto findById(Integer id) /*throws NotFoundException*/;
	
	public SaleDto create(SaleDto saleDto) /*throws InvalidDataException,*/ /*throws NotFoundException*/;

	public void update(SaleDto saleDto) /*throws NotFoundException*/;

	public void delete(Integer id);


}
