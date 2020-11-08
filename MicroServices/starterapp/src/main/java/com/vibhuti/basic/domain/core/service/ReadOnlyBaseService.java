/**
 * 
 */
package com.vibhuti.basic.domain.core.service;

import com.vibhuti.basic.domain.core.repository.ReadOnlyRepository;
import com.vibhuti.basic.domain.core.repository.Repository;

/**
 * @author jyodak
 *
 */
public abstract class ReadOnlyBaseService<TE,T> {
	
	private final ReadOnlyRepository<TE, T> repository;
	
	public ReadOnlyBaseService(ReadOnlyRepository<TE,T> repository ) {
		this.repository = repository;
	}

	public ReadOnlyRepository<TE, T> getRepository() {
		return repository;
	}
	
	
}
