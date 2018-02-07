package atsistemas.prueba.service.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import atsistemas.prueba.dao.ProductDao;
import atsistemas.prueba.dto.ProductDto;
import atsistemas.prueba.model.Product;
import atsistemas.prueba.model.Provider;
import atsistemas.prueba.model.Restaurant;
import atsistemas.prueba.service.Provider.ProviderService;
import atsistemas.prueba.service.Restaurant.RestaurantService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;

	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private ProviderService providerService;
	
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
		final Product product;
		final Provider provider = providerService.transform(providerService.findById(dto.getIdProvider()));
		final Restaurant restaurant = restaurantService.transform(restaurantService.findById(dto.getIdRestaurant()));
		if (dto.getIdProduct() != null && productDao.exists(dto.getIdProduct())){
			product = productDao.findOne(dto.getIdProduct());
		}else{
			product = new Product();
		}
		product.setName(dto.getNameProduct());
		product.setProvider(provider);
		product.setRestaurant(restaurant);
		return product;
	}

	@Override
	public ProductDto map(Product p) {
		final ProductDto dto =new ProductDto();
		final List<Integer> idSales = new ArrayList<>();
		p.getSales().forEach(x->{
			idSales.add(x.getId());
		});
		dto.setIdProduct(p.getId());
		dto.setNameProduct(p.getName());
		dto.setIdProvider(p.getProvider().getId());
		dto.setIdRestaurant(p.getRestaurant().getId());
		dto.setIdSales(idSales);

		return dto;
	} 
}
