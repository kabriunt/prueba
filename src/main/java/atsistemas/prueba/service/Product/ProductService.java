package atsistemas.prueba.service.Product;

import java.util.List;

import atsistemas.prueba.dto.ProductDto;
import atsistemas.prueba.model.Product;

public interface ProductService {

	/**
	 * Realiza la busqueda de todos los Productos existentes (con paginacion)
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<ProductDto> findAll(Integer page, Integer size);
	
	/**
	 * Busca por Id
	 * 
	 * @param idProduct
	 * @return
	 * @throws Exception 
	 */
	public ProductDto findById(Integer idProduct) throws Exception;
	
	/**
	 * Busca por Nombre
	 * 
	 * @param nameProduct
	 * @return
	 */
	public List<ProductDto> findByName(String nameProduct);
	
	/**
	 * Crea un Producto
	 * 
	 * @param p
	 * @return
	 */
	public ProductDto create(ProductDto p);
	
	/**
	 * Modifica un Producto
	 * 
	 * @param p
	 */
	public void update(ProductDto p);

	/**
	 * Borra un Producto
	 * 
	 * @param idProduct
	 */
	public void delete(Integer idProduct);

	/**
	 * Mapea de ProductDto a Product
	 * 
	 * @param p
	 * @return
	 */
	public Product map(ProductDto p);
	
	/**
	 * Mapea de Product a ProductDto
	 * 
	 * @param p
	 * @return
	 */
	public ProductDto map(Product p);
}
