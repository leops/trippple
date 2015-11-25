package com.traveloid.trippple.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	private static EntityManagerFactory factory = null;
	
	public static EntityManagerFactory getFactory() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("Trippple");
		}
		
		return factory;
	}
	
	public static void close() {
		if(factory != null) {
			if(factory.isOpen())
				factory.close();
			factory = null;
		}
	}
}
