package it.unifi.ing.gel.swe.elaborato;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Agente extends Persona{
	
	private String zona;
	private int nAgente;
	private List<Viaggio> viaggi = new ArrayList<>();
	private List<Negozio> negozi;
	
	public Agente (String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String luogoNascita, 
			Sesso sesso, String zona, int nAgente) {
		super(codiceFiscale, nome, cognome, dataNascita, luogoNascita, sesso);
		this.zona = zona;
		this.nAgente = nAgente;
		negozi = new ArrayList<Negozio>();
	}
	
	public String getZona() { return zona; }
	
	public int getNAgente () { return nAgente; }
	
	public List<Negozio> getNegozi () { return negozi; }
	
	public List<Viaggio> getViaggi() { return viaggi; }
	
	public Viaggio getViaggioInCorso () {
		for (Viaggio viaggio : viaggi) {
			if (viaggio.getInCorso()) {
				return viaggio;
			}
		}
		throw new IllegalArgumentException("Non ci sono viaggi in corso!!");
	}
	
	private boolean controllaInCorso() {
		for (Viaggio viaggio : viaggi) {
			if (viaggio.getInCorso()) {
				return true;
			}
		}
		return false;
	}
	
	public void aggiungiNegozio(Negozio negozio) {
		negozi.add(negozio);
	}
	
	public void aggiungiViaggio (int nViaggio) {
		if (!controllaInCorso()) {
			Viaggio viaggio = new Viaggio(nViaggio, this);
			viaggi.add(viaggio);
		} else {
			throw new IllegalArgumentException("Non puoi iniziare un viaggio prima di terminare quello in corso!");
		}
	}
	
	public Set<Negozio> negoziDaVisitare () {
		Set<Negozio> daVisitare = new HashSet<>();
		for (Negozio negozio : negozi) {
			negozio.aggiornaStato();
			if (negozio.getStato() == Stato.DA_VISITARE) {
				daVisitare.add(negozio);
			}
		}
		return daVisitare;
	}
	
	public double calcolakmTot() {
		double kmTot = 0;
		for (Viaggio viaggio : viaggi) {
			kmTot = kmTot + viaggio.calcolaKm();
		}
		return kmTot;
	}
	
	@Override
	public String toString() {
		return "Agente [codiceFiscale = " + codiceFiscale + ", nome = " + nome + ", cognome = " + cognome + ", dataNascita = " + dataNascita + 
				", luogoNascita = " + luogoNascita + ", sesso = " + sesso + ", zona = " + zona + ", nAgente = " + nAgente + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		Agente other = (Agente) obj;
		
		if (this.nAgente != other.nAgente) {
			return false;
		}
		
		return true;
	}

}
