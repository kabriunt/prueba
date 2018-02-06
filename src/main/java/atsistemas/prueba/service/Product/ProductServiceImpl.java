package atsistemas.prueba.service.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import atsistemas.prueba.dao.ProductDao;
import atsistemas.prueba.dto.ProductDto;
import atsistemas.prueba.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductDto> findAll(Integer page, Integer size) {
		List<Product> products = (List<Product>) productDao.findAll(new PageRequest(page, size)).getContent();
		return products.stream().map(u->map(u)).collect(Collectors.toList());
	}
	
	@Override
	public ProductDto findById(Integer idProduct) throws Exception{
		Product find = productDao.findOne(idProduct);
		return map(Optional.ofNullable(find).orElseThrow(Exception::new));
	}
	
	@Override
	public List<ProductDto> findByName(String nameProduct) {
		List<Product> Products = productDao.findByName(nameProduct);
		return Products.stream().map(u->map(u)).collect(Collectors.toList());
	}
	
	@Override
	public ProductDto create(ProductDto p) {
		final Product Product = productDao.save(map(p));
		return map(Product);
	}

	@Override
	public void update(ProductDto p) {
		final Product Product = productDao.save(map(p));
		map(Product);
	}

	@Override
	public void delete(Integer idProduct){
		productDao.delete(idProduct);
	}
	
	@Override
	public Product map(ProductDto dto) {
		return mapper.map(dto, Product.class);
	}

	@Override
	public ProductDto map(Product p) {
		return mapper.map(p, ProductDto.class);
	}
}
