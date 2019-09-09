package br.com.taok.collector.ce.caucaia;

import java.util.ArrayList;
import java.util.List;

import br.com.taok.collector.api.Collector;
import br.com.taok.collector.api.model.standard.CollectedLaunch;
import br.com.taok.collector.api.model.standard.Search;

public class CollectorCeCaucaia implements Collector {

	/**
	 * 
	 * Class to import data from CE-Caucaia
	 * 
	 * */
	@Override
	public List<CollectedLaunch> collectNow(Search search) {
	
		System.out.println("Importation Test");
		
		return new ArrayList<>();
	}
}
