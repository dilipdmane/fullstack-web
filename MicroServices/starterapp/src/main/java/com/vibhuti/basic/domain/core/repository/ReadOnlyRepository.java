/**
 * 
 */
package com.vibhuti.basic.domain.core.repository;

import java.util.Collection;

/**
 * @author jyodak
 *
 */
public interface ReadOnlyRepository<TE,T> {
	
	boolean contains(T id);
	
	TE get(T id);
		
	Collection<TE> getAll();

}
