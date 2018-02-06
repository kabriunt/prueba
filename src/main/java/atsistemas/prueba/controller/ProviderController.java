package atsistemas.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import atsistemas.prueba.dto.ProviderDto;
import atsistemas.prueba.service.Provider.ProviderService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/provider")
public class ProviderController {
	@Autowired
	private ProviderService providerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ProviderDto> getAll(@PageableDefault(page=0,size=10)Pageable pageable){
		return providerService.findAll(pageable.getPageNumber(),pageable.getPageSize());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ProviderDto getById(@PathVariable(value = "id") Integer id) {
		return providerService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ProviderDto create(@RequestBody ProviderDto providerDto) {
		return providerService.create(providerDto);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody ProviderDto providerDto) {
		providerService.update(providerDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Integer id) {
		providerService.delete(id);
	}
}
