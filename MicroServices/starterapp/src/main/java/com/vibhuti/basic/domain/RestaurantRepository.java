/**
 * 
 */
package com.vibhuti.basic.domain;

import com.vibhuti.basic.domain.core.repository.Repository;

/**
 * @author jyodak
 *
 */
public interface RestaurantRepository<TE, T> extends Repository<TE, T> {
 boolean containsName(String name);
}
