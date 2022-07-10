package it.unifi.ing.gel.swe.elaborato;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Negozio {
	
	private Negoziante negoziante;
	private Posizione posizione;
	private String nomeAttività;
	private Stato stato;
	private List<Visita> visite = new LinkedList<>();
	private Set<Prodotto> prodotti = new TreeSet<>();
	
	public Negozio (Negoziante negoziante, Posizione posizione, String nomeAttività) {
		this.negoziante = negoziante;
		this.posizione = posizione;
		this.nomeAttività = nomeAttività;
		stato = Stato.DA_VISITARE;
	}
	
	public Negoziante getNegoziante() { return negoziante; }
	
	public Posizione getPosizione() { return posizione; }
	
	public String getNomeAttività() { return nomeAttività; }
	
	public Stato getStato() { return stato; }
	
	public List<Visita> getVisite() {
		return Collections.unmodifiableList(visite);
	}
	
	public Set<Prodotto> getProdotti() {
		return Collections.unmodifiableSet(prodotti);
	}
	
	public void aggiungiVisita (Visita visita) {
		visite.add(visita);
	}
	
	public void aggiornaStato() {
		if (visite.isEmpty() || visite.get(visite.size()-1).getData().isBefore(LocalDate.now().minusDays(60) )) {
			stato = Stato.DA_VISITARE;
		} else {
			stato = Stato.VISITATO;
		}
	}
	
	public void aggiungiProdotto(Prodotto prodotto) {
		prodotti.add(prodotto);
	}
	
	public void rimuoviProdotto(Prodotto prodotto) {
		prodotti.remove(prodotto);
	}
	
	@Override
	public String toString () {
		return "Negozio [negoziante = " + negoziante + ", nomeAttività = " + nomeAttività + ", posizione = " + 
				posizione + ", stato =  " + stato + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		Negozio other = (Negozio) obj;
		
		/* return (this.negoziante == other.negoziante 
				&& this.posizione == other.posizione
				&& this.nomeAttività == other.nomeAttività); */
		
		if (this.negoziante == null) {
			if (other.negoziante != null) {
				return false;
			}
		} else if (!this.negoziante.equals(other.negoziante)) {
			return false;
		}
		
		if (this.posizione == null) {
			if (other.posizione != null) {
				return false;
			}
		} else if (!this.posizione.equals(other.posizione)) {
			return false;
		}
		
		if (this.nomeAttività == null) {
			if (other.nomeAttività != null) {
				return false;
			}
		} else if (!this.nomeAttività.equals(other.nomeAttività)) {
			return false;
		}
		
		return true; 
	} 

}
