package com.otrs.restaurant.domain.repository;

import java.util.Collection;

public interface ReadOnlyRepository<TE,T> {
	
	TE get(T id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean contains(T id);
	
	
	/**
	 * 
	 * @return
	 */
	Collection<TE> getAll();

}
