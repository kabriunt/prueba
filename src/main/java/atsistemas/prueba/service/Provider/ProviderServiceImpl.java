package atsistemas.prueba.service.Provider;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import atsistemas.prueba.dao.ProviderDao;
import atsistemas.prueba.dto.ProviderDto;
import atsistemas.prueba.model.Provider;

@Service
public class ProviderServiceImpl implements ProviderService{
	
	@Autowired
	private ProviderDao providerDao;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	public Provider map (ProviderDto p) {
		Provider provider = providerDao.findOne(p.getId());
		if(provider == null)
			provider = new Provider();
		provider.setId(p.getId());
		provider.setName(p.getName());
		provider.setLocation(p.getLocation());
		provider.setPhone(p.getPhone());
		return provider;
	}
	
	public ProviderDto map(Provider p) {
		return mapper.map(p,ProviderDto.class);
	}
	
	@Override
	public List<ProviderDto> findAll(Integer pages, Integer size) {
		Iterable<Provider> providers = providerDao.findAll(new PageRequest(pages,size));
		final List<ProviderDto> res = new ArrayList<>();
		providers.forEach(x->{
			res.add(map(x));
		});
		return res;
	}

	@Override
	public ProviderDto findById(Integer id) {
		Provider provider = providerDao.findOne(id);
		return map(provider);
	}

	@Override
	public ProviderDto create(ProviderDto providerDto) {
		return map(providerDao.save(map(providerDto)));
	}

	@Override
	public void update(ProviderDto providerDto) {
		providerDao.save(map(providerDto));
	}

	@Override
	public void delete(Integer id) {
		providerDao.delete(id);
	}
}
