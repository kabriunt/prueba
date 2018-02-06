package atsistemas.prueba.service.Provider;

import java.util.List;

import atsistemas.prueba.dto.ProviderDto;
import atsistemas.prueba.dto.RestaurantDto;
import atsistemas.prueba.model.Provider;
import atsistemas.prueba.model.Restaurant;

public interface ProviderService {
	
	Provider transform(ProviderDto providerDto);
	
	ProviderDto transform(Provider provider);
	
	List<ProviderDto> findAll();
	
	ProviderDto findById(Integer id);
	
	ProviderDto create(ProviderDto providerDto);
	
	void update(ProviderDto providerDto);
	
	void delete(Integer id);
	
}
