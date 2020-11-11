/**
 * 
 */
package com.vibhuti.basic.domain;

import java.math.BigInteger;
import java.util.Collection;

import com.vibhuti.basic.domain.core.service.BaseService;

/**
 * @author jyodak
 *
 */
public class RestaurantService extends BaseService<Restaurant,String> {
	
	private RestaurantRepository<Restaurant, String> restaurantRepository;

	public RestaurantService(RestaurantRepository<Restaurant, String> repository) {
		super(repository);
		this.restaurantRepository=repository;
		
	}
	
	public void add(Restaurant restaurant) throws Exception
	{
		if( restaurantRepository.containsName(restaurant.getName()))
		{
			throw new Exception(String.format("There is already restaurant with name %s", restaurant.getName()));
		}
		
		if (restaurant.getName() ==null || "".equalsIgnoreCase(restaurant.getName()))
		{
			throw new Exception("Restaurant name cannot be empty or null !");
		}
		
		super.add(restaurant);
	}
	
	@Override
	public Collection<Restaurant> getAll() throws Exception {	
		return super.getAll();
	}

}
