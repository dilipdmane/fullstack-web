package com.vibhuti.basic.starterapp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.vibhuti.basic.domain.InMemRestaurantRepository;
import com.vibhuti.basic.domain.Restaurant;
import com.vibhuti.basic.domain.RestaurantService;
import com.vibhuti.basic.domain.Table;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {        	
        	//Initialize restaurant service
        	RestaurantService restaurantService = new RestaurantService(new InMemRestaurantRepository());
        	
        	//Add tables
        	
        	List<Table> tables = Arrays.asList(
        			new Table(BigInteger.ONE, "Table 1", 5),
        			new Table(BigInteger.valueOf(2), "Table 2", 6),
        			new Table(BigInteger.valueOf(3), "Table 3", 7));
        	
        	// Add few restaurants using Service
            // Note: To raise an exception give same restaurant name to one of the below restaurant
            restaurantService
                .add(new Restaurant("1","Big-O Restaurant",  tables));
            restaurantService.add(new Restaurant("2","Pizza Shops", new ArrayList<Table>() ));
            restaurantService.add(new Restaurant("3","La Pasta",  new ArrayList<Table>()));
            
            // Retrieving all restaurants using Service
            Collection<Restaurant> restaurants = restaurantService.getAll();
            
            System.out.println("App.main() Restaurant List ...");
            
            restaurants.stream().map(r -> String.format("Restaurant : %s", r)).forEach(
            		System.out::println
            		);
			
		} catch (Exception e) {
			 System.out.println(String.format("Exception: %s", e.getMessage()));
		}
    }
}
