package br.com.taok.collector.ce.caucaia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.taok.collector.api.Collector;
import br.com.taok.collector.api.model.Provider;
import br.com.taok.collector.api.model.standard.CollectedLaunch;
import br.com.taok.collector.api.model.standard.Search;

public class CeCaucaiaCollector implements Collector {

	/**
	 * 
	 * Class to import data from CE-Caucaia
	 * 
	 * */
	@Override
	public Collector collectNow(Search search) {
		
		System.out.println("Start Caucaia Implementation");
		
		return this;
	}

	@Override
	public List<CollectedLaunch> launchs() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public List<Provider> providers() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public BigDecimal amount() {
		// TODO Auto-generated method stub
		return BigDecimal.ZERO;
	}
}
