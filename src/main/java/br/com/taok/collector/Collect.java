package br.com.taok.collector;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import br.com.taok.collector.api.Collector;
import br.com.taok.collector.api.model.standard.CollectedLaunch;
import br.com.taok.collector.api.model.standard.Search;
import br.com.taok.collector.model.ProviderCollected;

/**
 * 
 * Class with responsibility of the make Collections
 * 
 * */
public class Collect {

	@Inject
	@Any
	private Instance<Collector> collectoresLazy;
	
	/**
	 * 
	 * Execute the collections and persist in databases
	 * 
	 * */
	public void make() {
		
		LocalDate start = LocalDate.of(2019, 8, 1);
		LocalDate end = LocalDate.of(2019, 8, 30);
		ProviderCollected provider =  new ProviderCollected("Companhia+De+Agua+E+Esgoto+Do+Ceara-Cagece", "");
		
		Search search = new Search(start, end, provider, null);
		
		for( Collector collector : collectoresLazy ) {
			
			List<CollectedLaunch> collectNow = collector.collectNow(search);
			System.out.println(collectNow.size());
		}
	}
}
