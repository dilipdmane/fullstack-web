package com.otrs.restaurant.domain.service;

import com.otrs.restaurant.domain.repository.ReadOnlyRepository;

public abstract class ReadOnlyBaseService<TE, T> {

  private ReadOnlyRepository<TE, T> repository;

  ReadOnlyBaseService(ReadOnlyRepository<TE, T> repository) {
    this.repository = repository;
  }
}