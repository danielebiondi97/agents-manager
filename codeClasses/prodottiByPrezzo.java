package it.unifi.ing.gel.swe.elaborato;

import java.util.Comparator;

public class prodottiByPrezzo implements Comparator<Prodotto>{
	
	@Override
	public int compare (Prodotto o1, Prodotto o2) {
		if (o1.getPrezzo() > o2.getPrezzo()) {
			return 1;
		}
		
		if (o1.getPrezzo() == o2.getPrezzo()) {
			return 0;
		}
		
		else {
			return -1;
		}
	
	}

}
