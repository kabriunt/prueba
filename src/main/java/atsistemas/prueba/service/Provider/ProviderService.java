package atsistemas.prueba.service.Provider;

import java.util.List;

import atsistemas.prueba.dto.ProviderDto;
import atsistemas.prueba.model.Provider;

public interface ProviderService {
	
	Provider transform(ProviderDto providerDto);
	
	ProviderDto transform(Provider provider);
	
	List<ProviderDto> findAll(Integer pages, Integer size);
	
	ProviderDto findById(Integer id);
	
	ProviderDto create(ProviderDto providerDto);
	
	void update(ProviderDto providerDto);
	
	void delete(Integer id);
	
}
