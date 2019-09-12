package br.com.taok.collector;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Main {

	public static void main(String[] args) {

		
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        try (SeContainer container = initializer.initialize()) {
        	Collect collect = container.select(Collect.class).get();
        	
        	collect.make();
        }
	}
}
