package com.otrs.restaurant.domain.repository;

import java.util.Collection;

import com.otrs.restaurant.common.RestaurantNotFoundException;

public interface RestaurantRepository<Restaurant, String> extends Repository<Restaurant, String> {
	
	boolean containsName(String name);
	public Collection<Restaurant> findByName(String name) throws RestaurantNotFoundException; 

}
