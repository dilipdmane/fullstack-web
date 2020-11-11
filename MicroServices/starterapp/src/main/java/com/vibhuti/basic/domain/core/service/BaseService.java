package com.vibhuti.basic.domain.core.service;

import java.util.Collection;

import com.vibhuti.basic.domain.core.repository.Repository;

public class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {
	  private final Repository<TE, T> _repository;
	
	public BaseService(Repository<TE, T> repository) {
		super(repository);
		this._repository = repository;
	}
	
	public void add(TE entity) throws Exception
	{
		_repository.add(entity);
	}
	
	public Collection<TE> getAll() throws Exception
	{
		return _repository.getAll();
	}
}
