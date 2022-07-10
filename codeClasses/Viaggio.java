package it.unifi.ing.gel.swe.elaborato;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Viaggio {
	
	private Map<LocalDateTime, Posizione> posizioni;
	private List<Visita> visite = new LinkedList<>();
	private int nViaggio;
	private Agente agente;
	private boolean inCorso; // true = in corso, false = terminato
	
	public Viaggio(int nViaggio, Agente agente) {
		this.posizioni = new TreeMap<>();
		this.nViaggio = nViaggio;
		this.agente = agente;
		inCorso = true;
	}
	
	public int getNViaggio() { return nViaggio; }
	
	public List<Visita> getVisite () {
		return Collections.unmodifiableList(visite);
	}
	
	public Agente getAgente() { return agente; }
	
	public boolean getInCorso() { return inCorso; }
	
	
	
	public void terminaViaggio() {
		inCorso = false;
	}
	
	public void aggiungiPosizione(LocalDateTime tempo, Posizione posizione) {
		if (inCorso) {
		posizioni.put(tempo, posizione);
		} else {
			throw new UnsupportedOperationException ("Questo viaggio è già terminato!!");
		}
	}

	public void aggiungiVisita(String resoconto, LocalDate data, Negozio negozio) {
		negozio.aggiornaStato();
		if (negozio.getStato() == Stato.VISITATO) {
			throw new IllegalArgumentException("Hai già visitato questo negozio meno di 2 mesi fa... non fare il furbo con me !!!");
		}
		Visita visita = new Visita(resoconto, data, negozio, this); 
		visite.add(visita);
		negozio.aggiungiVisita(visita);
		negozio.aggiornaStato();
	}
	
	public void printPosizioni() {
		Set<LocalDateTime> tempi = new TreeSet<>();
		tempi = posizioni.keySet();
		
		for (LocalDateTime tempo : tempi) {
			System.out.println("\tTempo = " + tempo + ", Posizione = " + posizioni.get(tempo) + "\t");
		}
	}
	
	public double calcolaKm () {
		return 5.7;
		// TODO implementare la una funzione per calcolare una distanza tra due punti su una sfera con coordinate polari
		// usando la Harvesine Formula e sommare tutte le distanze tra due posizioni successive all'interno di un viaggio
	}
	
	@Override
	public String toString() {
		return "Viaggio [agente = " + agente + "nViaggio = " + nViaggio + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj ) {
			return true;
		}
		
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		Viaggio other = (Viaggio) obj;
		
		if (this.nViaggio != other.nViaggio) {
			return false;
		}
		
		return true;
	}
}
