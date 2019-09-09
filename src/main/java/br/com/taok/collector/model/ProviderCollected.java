package br.com.taok.collector.model;

import br.com.taok.collector.api.model.Provider;

public class ProviderCollected implements Provider {

	private String description;
	private String cnpj;
	
	public ProviderCollected(String description, String cnpj) {
		this.description = description;
		this.cnpj = cnpj;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String getCNPJ() {
		return this.cnpj;
	}
}
