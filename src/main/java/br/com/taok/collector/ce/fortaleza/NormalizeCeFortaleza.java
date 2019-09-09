package br.com.taok.collector.ce.fortaleza;

import java.util.ArrayList;
import java.util.List;

import br.com.taok.collector.CollectedLaunchBuilder;
import br.com.taok.collector.api.model.standard.CollectedLaunch;
import br.com.taok.collector.api.model.standard.NormalizeLaunch;
import br.com.taok.collector.model.CityCollected;
import br.com.taok.collector.model.ProviderCollected;
import br.com.taok.collector.model.PublicCompanyCollected;

public class NormalizeCeFortaleza implements NormalizeLaunch {

	@Override
	public List<CollectedLaunch> normalize(List<String[]> datas) {

		CityCollected city = new CityCollected(1,"CE-Fortaleza");

		List<CollectedLaunch> result = new ArrayList<>();

		int row = 0;
		for (String[] data : datas) {

			row ++;
			
			if( row > 3 ) {
				
				PublicCompanyCollected publicCompany = new PublicCompanyCollected(data[5]);
				ProviderCollected provider = new ProviderCollected(data[4], data[3]);
				
				CollectedLaunch launch = new CollectedLaunchBuilder()
					.withIdentify(data[1])
					.withCity(city)
					.withValue(data[7])
					.withProvider(provider)
					.withPublicCompany(publicCompany)
					.withDate(data[0])
					.now();
				
				result.add(launch);				
			}
		}
		
		return result;
	}
}
