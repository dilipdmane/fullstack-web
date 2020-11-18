package com.otrs.restaurant.domain.repository;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.otrs.restaurant.common.RestaurantNotFoundException;
import com.otrs.restaurant.domain.model.entity.Restaurant;

@Repository("restaurantRepository")
public class InMemRestaurantRepository implements RestaurantRepository<Restaurant, String> {
	
	private static final Map<String, Restaurant> entities;
	
	static {
		entities = new ConcurrentHashMap<>( Map.ofEntries(
				new AbstractMap.SimpleEntry<String, Restaurant>("1",new Restaurant("Le Meurice", "1", "228 rue de Rivoli, 75001, Paris", Optional.empty()) ),
				new AbstractMap.SimpleEntry<String, Restaurant>("2",new Restaurant("Le L'Ambroisie", "2", "9 place des Vosges, 75004, Paris", Optional.empty()) ),
				new AbstractMap.SimpleEntry<String, Restaurant>("3",new Restaurant("Arpège", "4", "84, rue de Varenne, 75007, Paris", Optional.empty()) ),
				new AbstractMap.SimpleEntry<String, Restaurant>("4",new Restaurant("Alain Ducasse au Plaza Athénée", "8", "18 rue Troyon, 75017, Paris", Optional.empty()) )
				));
		
	}

	@Override
	public void add(Restaurant entity) {
		entities.put(entity.getId(), entity);
	}

	@Override
	public void remove(String id) {
		if(entities.containsKey(id)) {
			entities.remove(id);
		}
	}

	@Override
	public void update(Restaurant entity) {
		if(entities.containsKey(entity.getId())) {
			entities.put(entity.getId(), entity);
		}
	}

	@Override
	public Restaurant get(String id) {
		return entities.get(id);
	}

	@Override
	public boolean contains(String id) {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
	public Collection<Restaurant> getAll() {
		
		return entities.values();
	}

	@Override
	public boolean containsName(String name) {
		
		return false;
	}

	@Override
	public Collection<Restaurant> findByName(String name) throws RestaurantNotFoundException{
		int noOfChars = name.length();
		Collection<Restaurant> restaurants= entities.entrySet().stream().filter(e-> e.getValue().getName().contains( name.subSequence(0, noOfChars)))
		.collect(Collectors.toList())
		.stream()
		.map(k -> k.getValue())
		.collect(Collectors.toList());
		if (restaurants !=null && restaurants.isEmpty())
		{
			Object[] args= {name};
			throw new RestaurantNotFoundException("restaurantNotFound",args);
		}
		return restaurants;
	}

}
