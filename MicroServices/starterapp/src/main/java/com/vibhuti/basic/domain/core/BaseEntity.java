package com.vibhuti.basic.domain.core;

public class BaseEntity<T> extends Entity<T> {
	private final boolean isModified=false;

	public BaseEntity(T id, String name) {
		super(id, name);
	}
	
	public boolean isModified() {
		return isModified;
	}
	
	
	
	

}
