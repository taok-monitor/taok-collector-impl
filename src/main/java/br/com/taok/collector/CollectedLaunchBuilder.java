package br.com.taok.collector;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.taok.collector.api.model.City;
import br.com.taok.collector.api.model.Provider;
import br.com.taok.collector.api.model.PublicCompany;
import br.com.taok.collector.api.model.standard.CollectedLaunch;

public class CollectedLaunchBuilder {

	private CollectedLaunch collectedLaunch;
	
	public CollectedLaunchBuilder() {
		
		this.collectedLaunch = new CollectedLaunch();
	}
	
	public CollectedLaunchBuilder withIdentify(String identify) {
		
		identify = emptyString(identify);
		this.collectedLaunch.setIdentify(identify);
		return this;
	}
	
	public CollectedLaunchBuilder withCity(City city) {
		
		this.collectedLaunch.setCity( city );
		return this;
	}
	
	public CollectedLaunchBuilder withPublicCompany(PublicCompany publicCompany) {
		
		this.collectedLaunch.setPublicCompany(publicCompany);
		return this;
	}
	
	public CollectedLaunchBuilder withProvider( Provider provider ) {
		
		this.collectedLaunch.setProvider(provider);
		return this;
	}
	
	public CollectedLaunchBuilder withDate(String date) {
		
		date = emptyString(date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		this.collectedLaunch.setDate(LocalDate.parse(date, 	formatter));
		return this;
	}
	
	public CollectedLaunchBuilder withValue(String value) {
		
		value = emptyString(value)
				.replace(".", "")
				.replace(",", ".");
		
		this.collectedLaunch.setValue(new BigDecimal(value));
		return this;
	}
	
	public CollectedLaunch now() {
		
		return this.collectedLaunch;
	}
	
	public String emptyString(String data) {
		
		return data.replace("\"", "");
	}
}
