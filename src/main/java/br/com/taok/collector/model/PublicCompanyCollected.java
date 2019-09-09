package br.com.taok.collector.model;

import br.com.taok.collector.api.model.PublicCompany;

public class PublicCompanyCollected implements PublicCompany {

	private String description;
	
	public PublicCompanyCollected(String description) {
		this.description = description;
	}

	@Override
	public String getDescription() {
		return this.description;
	}
}
