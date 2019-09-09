package br.com.taok.collector.ce.fortaleza;

import java.time.LocalDate;
import java.util.List;

import br.com.taok.collector.CollectExcepion;
import br.com.taok.collector.ConectorAPI;
import br.com.taok.collector.api.Collector;
import br.com.taok.collector.api.model.standard.CollectedLaunch;
import br.com.taok.collector.api.model.standard.Search;

public class CollectorCeFortaleza implements Collector {

	private final String URL_DEFAULT = "https://transparencia.fortaleza.ce.gov.br/index.php/despesa/exibirResultConsultaPeriodoCSV/:provider/P/:datainicial/:datafinal/0/2019/RGVzcGVzYXMgZGEgUHJlZmVpdHVyYSBkZSBGb3J0YWxlemEgZGUgMDEvMDEvMjAxOSBhIDMxLzAxLzIwMTkgLSBGYXNlIGRlIFBhZ2FtZW50bw%3D%3D";

	
	@Override
	public List<CollectedLaunch> collectNow(Search search) {

		LocalDate startDate = search.getStartDate();
		LocalDate endDate   = search.getEndDate();
		
		String diaInicial = startDate.getDayOfMonth() < 10 ? "0"+startDate.getDayOfMonth(): ""+startDate.getDayOfMonth();
		String mesInicial = startDate.getMonthValue() < 10 ? "0"+startDate.getMonthValue(): ""+startDate.getMonthValue();
		String dataInicialFiltro = diaInicial+mesInicial+""+startDate.getYear();

		String diaFinal = endDate.getDayOfMonth() < 10 ? "0"+endDate.getDayOfMonth(): ""+endDate.getDayOfMonth();
		String mesFinal = endDate.getMonthValue() < 10 ? "0"+endDate.getMonthValue(): ""+endDate.getMonthValue();
		String dataFinalFiltro = diaFinal+mesFinal+""+endDate.getYear();
		
		try {
			
			String url = URL_DEFAULT
					.replace(":datainicial", dataInicialFiltro)
					.replace(":datafinal", dataFinalFiltro)
					.replace(":provider", search.getProvider().getDescription());
			List<String[]> datas = ConectorAPI.conecta(url);
			return new NormalizeCeFortaleza().normalize(datas);

		} catch (Exception e) {

			throw new CollectExcepion("Importation form Fortaleza/CE, Failed: "+e.getMessage());
		}
	}
}
