package com.otrs.restaurant.domain.model.entity;

import java.util.List;
import java.util.Optional;

public class Restaurant extends BaseEntity<String> {
	
	private Optional<List<Table>> tables;
	private String address;
	
	public Restaurant(String id, String name , String address,Optional<List<Table>> tables ) {
		super(id, name);
		this.tables = tables;
		this.address = address;
	}
	
	 private Restaurant(String name, String id) {
		    super(id, name);
		    this.tables = Optional.empty();
		  }

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public Optional<List<Table>> getTables() {
		return tables;
	}
	
	public void setTables(Optional<List<Table>> tables) {
		this.tables = tables;
	}
	
	 public static Restaurant getDummyRestaurant() {
		    return new Restaurant(null, null);
		  }
}
