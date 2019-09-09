package br.com.taok.collector;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import br.com.taok.collector.ce.ImporterCE;

public class Main {

	public static void main(String[] args) {

		
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        try (SeContainer container = initializer.initialize()) {
        	ImporterCE importer = container.select(ImporterCE.class).get();
        	
        	importer.makeImportation();
        }
	}
}
