package br.com.taok.collector.ce;

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
 * Class with responsibility of the make importation of the state Ceará
 * 
 * */
public class ImporterCE {

	@Inject
	@Any
	private Instance<Collector> collectoresLazy;
	
	public void makeImportation() {
		
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
