package it.unifi.ing.gel.swe.elaborato;

import java.util.Comparator;

public class prodottiByNome implements Comparator<Prodotto> {
	
	@Override
	public int compare(Prodotto o1, Prodotto o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
