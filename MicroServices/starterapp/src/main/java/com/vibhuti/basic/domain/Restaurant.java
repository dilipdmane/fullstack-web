package com.vibhuti.basic.domain;

import java.util.ArrayList;
import java.util.List;

import com.vibhuti.basic.domain.core.BaseEntity;

public class Restaurant extends BaseEntity<String> {
	
	private List<Table> tables = new ArrayList<>(); 

	public Restaurant(String id, String name, List<Table> tables) {
		super(id, name);
		this.tables = tables;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	
	@Override
	public String toString() {
		
		return new StringBuilder("{ \"id\": \"").append(id)
				.append("\" , \"name\" :").append(name).append("\" , tables:")
				.append(tables).append("}")
				.toString();
	}

}
