package com.otrs.restaurant.resources;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.logging.Logger;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.otrs.restaurant.domain.model.entity.Entity;
import com.otrs.restaurant.domain.model.entity.Restaurant;
import com.otrs.restaurant.domain.valueobject.RestaurantVO;

public abstract class AbstractRestaurantControllerTests {

	/**
	 * RESTAURANT ID constant having value 1
	 */
	protected static final String RESTAURANT = "1";

	protected static final String RESTAURANT_NAME = "Le Meurice";

	protected static final String RESTAURANT_ADDRESS = "228 rue de Rivoli, 75001, Paris";

	@Autowired
	RestaurantController restaurantController;

	@Test
	public void validRestaurantbyId() throws Exception {
		Logger.getGlobal().info("Start validRestaurantbyId Test...Start");
		ResponseEntity<Entity> restaurant = restaurantController.findById(RESTAURANT);
		assertEquals(HttpStatus.OK, restaurant.getStatusCode());
		assertTrue(restaurant.hasBody());
		assertNotNull(restaurant.getBody());
		assertEquals(RESTAURANT, restaurant.getBody().getId());
		assertEquals(RESTAURANT_NAME, restaurant.getBody().getName());
		Logger.getGlobal().info("Start validRestaurantbyId Test... End");

	}

	@Test
	public void validRestaurantByName() throws Exception {
		Logger.getGlobal().info("Start validRestaurantByName Test...Start");
		ResponseEntity<Collection<Restaurant>> restaurants = restaurantController.findByName(RESTAURANT_NAME);
		assertEquals(HttpStatus.OK, restaurants.getStatusCode());
		assertTrue(restaurants.hasBody());
		assertNotNull(restaurants.getBody());
		assertFalse(restaurants.getBody().isEmpty());
		Restaurant restaurant = (Restaurant) restaurants.getBody().toArray()[0];
		assertEquals(RESTAURANT, restaurant.getId());
		assertEquals(RESTAURANT_NAME, restaurant.getName());
		Logger.getGlobal().info("Start validRestaurantByName Test...end");
	}

	@Test
	public void validAdd() throws Exception {
		Logger.getGlobal().info("Start validAdd test Started....");
		RestaurantVO restaurantVO = new RestaurantVO();
		restaurantVO.setId("99");
		restaurantVO.setName("Test Restaurant");

		ResponseEntity<Restaurant> restaurant = restaurantController.add(restaurantVO);
		assertEquals(HttpStatus.CREATED, restaurant.getStatusCode());
		Logger.getGlobal().info("Start validAdd test End");
	}

}
