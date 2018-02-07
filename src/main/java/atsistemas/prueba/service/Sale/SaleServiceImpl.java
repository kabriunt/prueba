package atsistemas.prueba.service.Sale;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atsistemas.prueba.dao.SaleDao;
import atsistemas.prueba.dto.SaleDto;
import atsistemas.prueba.model.Sale;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SaleServiceImpl implements SaleService {
	
	@Autowired
	private SaleDao saleDao;
	
	@Autowired
	private DozerBeanMapper mapper;
	
//	Faltan mapeadores y findAll
	
	@Override
	public Sale map (SaleDto s) {
		Sale sale = saleDao.findOne(s.getId());
		if(sale == null)
			sale = new Sale();
		sale.setId(s.getId());


		return sale;
	}
	
	@Override
	public SaleDto map(Sale s) {
		return mapper.map(s,SaleDto.class);
	}
	
	@Override
	public List<SaleDto> findAll() {
		Iterable<Sale> sales = saleDao.findAll();
		final List<SaleDto> res = new ArrayList<>();
		sales.forEach(x->{
			res.add(map(x));
		});
		return res;
	}
	
	@Override
	public SaleDto findById(Integer id) /*throws NotFoundException*/{
		log.info("se va a buscar el empleado con id con "+id);
		final Sale e = saleDao.findOne(id);	 
		return map(e);
//		throw new NotFoundException();
	}
	
	@Override
	public SaleDto create(SaleDto saleDto) /*throws InvalidDataException,*/ /*throws NotFoundException*/ {
		log.info("Intentando crear la cita...");
//		if(validate(saleDto))
			return map(saleDao.save(map(saleDto)));
//		log.info("Excepción: Alguno de los campos no contiene datos correctos o están vacios");
//		throw new InvalidDataException("Datos incorrectos");
	}
	
	@Override
	public void update(SaleDto saleDto) /*throws NotFoundException*/ {
		log.info("Actualizando cita...");
		saleDao.save(map(saleDto));
	}
	
	@Override
	public void delete(Integer id) {
		log.info("Borrando cita...");
		saleDao.delete(id);
	}

}
