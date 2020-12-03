package com.otrs.restaurant.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.junit.Before;


import com.otrs.restaurant.common.RestaurantNotFoundException;
import com.otrs.restaurant.domain.model.entity.Restaurant;
import com.otrs.restaurant.domain.repository.RestaurantRepository;
import com.otrs.restaurant.domain.service.RestaurantService;
import com.otrs.restaurant.domain.service.RestaurantServiceImpl;

public class RestaurantControllerTests extends AbstractRestaurantControllerTests {
	
	protected static final Restaurant restaurantStaticInstance = new Restaurant(RESTAURANT, RESTAURANT_NAME, RESTAURANT_ADDRESS, null);
	
	protected TestRestaurantRepository testRestaurantRepository = new TestRestaurantRepository();
	
	protected RestaurantService restaurantService =  new RestaurantServiceImpl(testRestaurantRepository);
			
	
	@Before
	public  void setup() {
		restaurantController =  new RestaurantController(restaurantService);
	}
	
	protected static class TestRestaurantRepository implements RestaurantRepository<Restaurant, String>
	{
		private HashMap<String, Restaurant> entities;
		
		public TestRestaurantRepository() {
			this.entities = new HashMap<>();
			Restaurant restaurant =  new Restaurant(RESTAURANT, RESTAURANT_NAME, RESTAURANT_ADDRESS, null);
			this.entities.put("1", restaurant);
			restaurant =  new Restaurant("2", "O Restaurant", "Address O Restaurant", null);
			this.entities.put("2", restaurant);
			
		}

		@Override
		public void add(Restaurant entity) {
			this.entities.put(entity.getId(), entity);
		}

		@Override
		public void remove(String id) {
			if(this.entities.containsKey(id))
			{
				this.entities.remove(id);
			}
			
		}

		@Override
		public void update(Restaurant entity) {
			if(this.entities.containsKey(entity.getId()))
			{
				this.entities.remove(entity.getId());
				this.entities.put(entity.getId(), entity);
			}
			
		}

		@Override
		public Restaurant get(String id) {
			
			return this.entities.get(id);
		}

		@Override
		public boolean contains(String id) {
			
			throw new UnsupportedOperationException(
			          "Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

		@Override
		public Collection<Restaurant> getAll() {
			
			return this.entities.values();
		}

		@Override
		public boolean containsName(String name) {
			
			try {
				return this.findByName(name).size()>0;
			} catch (RestaurantNotFoundException e) {
				
			}
			return false;
		}

		@Override
		public Collection<Restaurant> findByName(String name) throws RestaurantNotFoundException {
					
			Collection<Restaurant> retList = new ArrayList<>();
			int noOfChars = name.length();			
			entities.forEach((k,v)->
			{
				if(v.getName().toLowerCase().contains(name.subSequence(0, noOfChars)))
				{
					retList.add(v);
				}
			});			
			return retList;
		}		
	}

}
