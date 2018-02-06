package atsistemas.prueba.service.Provider;

import java.util.List;

import atsistemas.prueba.dto.ProviderDto;

public interface ProviderService {
	
	List<ProviderDto> findAll();
	
	ProviderDto findById(Integer id);
	
	ProviderDto create(ProviderDto providerDto);
	
	void update(ProviderDto providerDto);
	
	void delete(Integer id);
	
}
