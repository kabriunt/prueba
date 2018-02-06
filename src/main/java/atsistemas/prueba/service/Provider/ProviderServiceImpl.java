package atsistemas.prueba.service.Provider;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import atsistemas.prueba.dao.ProviderDao;
import atsistemas.prueba.dto.ProviderDto;
import atsistemas.prueba.model.Provider;

public class ProviderServiceImpl implements ProviderService{
	
	@Autowired
	private ProviderDao providerDao;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	public Provider transform (ProviderDto p) {
		Provider provider = providerDao.findOne(p.getId());
		if(provider == null)
			provider = new Provider();
		provider.setId(p.getId());
		provider.setName(p.getName());
		provider.setLocation(p.getLocation());
		provider.setPhone(p.getPhone());
		return provider;
	}
	
	public ProviderDto transform(Provider p) {
		return mapper.map(p,ProviderDto.class);
	}
	
	@Override
	public List<ProviderDto> findAll(Integer pages, Integer size) {
		Iterable<Provider> providers = providerDao.findAll(new PageRequest(pages,size));
		final List<ProviderDto> res = new ArrayList<>();
		providers.forEach(x->{
			res.add(transform(x));
		});
		return res;
	}

	@Override
	public ProviderDto findById(Integer id) {
		Provider provider = providerDao.findOne(id);
		return transform(provider);
	}

	@Override
	public ProviderDto create(ProviderDto providerDto) {
		return transform(providerDao.save(transform(providerDto)));
	}

	@Override
	public void update(ProviderDto providerDto) {
		providerDao.save(transform(providerDto));
	}

	@Override
	public void delete(Integer id) {
		providerDao.delete(id);
	}
}
