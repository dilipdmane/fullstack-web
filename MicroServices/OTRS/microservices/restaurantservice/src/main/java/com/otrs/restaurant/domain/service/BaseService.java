package com.otrs.restaurant.domain.service;

import java.util.Collection;

import com.otrs.restaurant.domain.repository.Repository;

public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

  private Repository<TE, T> _repository;

  BaseService(Repository<TE, T> repository) {
    super(repository);
    _repository = repository;
  }

  /**
   * @param entity
   */
  public void add(TE entity) throws Exception {
    _repository.add(entity);
  }

  /**
   *
   * @return
   */
  public Collection<TE> getAll() {
    return _repository.getAll();
  }
}