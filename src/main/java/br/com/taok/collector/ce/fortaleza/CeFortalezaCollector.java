package br.com.taok.collector.ce.fortaleza;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.taok.collector.api.Collector;
import br.com.taok.collector.api.model.Provider;
import br.com.taok.collector.api.model.standard.CollectedLaunch;
import br.com.taok.collector.api.model.standard.Search;
import br.com.taok.collector.exception.CollectExcepion;
import br.com.taok.collector.util.ConectorAPI;

public class CeFortalezaCollector implements Collector {

	private final String URL_DEFAULT = "https://transparencia.fortaleza.ce.gov.br/index.php/despesa/exibirResultConsultaPeriodoCSV/:provider/P/:datainicial/:datafinal/0/2019/RGVzcGVzYXMgZGEgUHJlZmVpdHVyYSBkZSBGb3J0YWxlemEgZGUgMDEvMDEvMjAxOSBhIDMxLzAxLzIwMTkgLSBGYXNlIGRlIFBhZ2FtZW50bw%3D%3D";
	
	private List<CollectedLaunch> launchs = new ArrayList<>();
	
	@Override
	public Collector collectNow(Search search) {

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
			launchs.addAll( new CeFortalezaNormalize().normalize(datas) );

			return this;
			
		} catch (Exception e) {

			throw new CollectExcepion("Importation form Fortaleza/CE, Failed: "+e.getMessage());
		}
	}

	@Override
	public List<CollectedLaunch> launchs() {
		return this.launchs;
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
