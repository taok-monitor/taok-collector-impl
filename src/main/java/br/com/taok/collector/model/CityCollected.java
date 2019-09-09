package br.com.taok.collector.model;

import br.com.taok.collector.api.model.City;

public class CityCollected implements City {

	private Integer id;
	private String description;
	
	public CityCollected(Integer id, String description) {
		this.description = description;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}
}
