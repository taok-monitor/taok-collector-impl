package br.com.taok.collector;

import br.com.taok.collector.api.model.Provider;

public class PrefectureProvider implements Provider {

	private String description;
	private String cnpj;
	
	public PrefectureProvider(String description, String cnpj) {
		this.description = description;
		this.cnpj = cnpj;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String getCNPJ() {
		return this.cnpj;
	}
}
