package com.otrs.restaurant.domain.model.entity;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Table extends BaseEntity<BigInteger> {
	
	private int capacity;

	public Table(@JsonProperty("name") String name,@JsonProperty("id") BigInteger id,@JsonProperty("capacity")int capacity) {
		super(id, name);
		this.capacity = capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	@Override
	public String toString() {
		  return String.format("{id: %s, name: %s, capacity: %s}",
			        this.getId(), this.getName(), this.getCapacity());
	}
}
