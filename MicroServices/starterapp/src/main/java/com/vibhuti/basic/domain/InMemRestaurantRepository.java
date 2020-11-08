package com.vibhuti.basic.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemRestaurantRepository implements RestaurantRepository<Restaurant, String> {
	
	private Map<String, Restaurant> entities;
	
	

	public InMemRestaurantRepository() {
		super();
		this.entities = new HashMap();
	}

	@Override
	public void add(Restaurant entity) {
		entities.put(entity.getName(), entity);		
	}

	@Override
	public void remove(String id) {
		if(entities.containsKey(id))
		{
			entities.remove(id);
		}
		
	}

	@Override
	public void update(Restaurant entity) {
		if( entities.containsKey(entity.getName()))
		{
			entities.put(entity.getName(), entity);
		}
	}

	@Override
	public boolean contains(String id) {
		
		return false;
	}

	@Override
	public Restaurant get(String id) {
		
		return null;
	}

	@Override
	public Collection<Restaurant> getAll() {
		
		return entities.values();
	}

	@Override
	public boolean containsName(String name) {
		
		return false;
	}

}
