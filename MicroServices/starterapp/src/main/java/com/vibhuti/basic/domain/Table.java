package com.vibhuti.basic.domain;

import java.math.BigInteger;

import com.vibhuti.basic.domain.core.BaseEntity;

public class Table extends BaseEntity<BigInteger> {
	
	private int capacity=0;

	public Table(BigInteger id, String name, int capacity) {
		super(id, name);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
