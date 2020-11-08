package com.vibhuti.basic.domain.core;

public abstract class  Entity<T> {
	protected T id;
	protected String name;
	
	public Entity() {	
	}

	public Entity(T id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public T getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(T id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

}
