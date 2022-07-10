package it.unifi.ing.gel.swe.elaborato;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Proprietario {
	
	private List<Negoziante> negozianti;
	private List<Agente> agenti;
	private List<Negozio> negozi;
	
	public Proprietario () {
		negozianti = new ArrayList<>();
		agenti = new ArrayList<>();
		negozi = new ArrayList<>();
	}
	
	public List<Agente> getAgenti () {
		return agenti;
	}
	
	public List<Negoziante> getNegozianti () {
		return negozianti;
	}
	
	public List<Negozio> getNegozi() {
		return negozi;
	}
	
	public Agente creaAgente(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String luogoNascita, 
			Sesso sesso, String zona, int nAgente) {
		Agente agente = new Agente (codiceFiscale, nome, cognome, dataNascita, luogoNascita, sesso, zona, nAgente);
		agenti.add(agente);
		return agente;
	}
	
	public void creaNegozioCreaNegoziante(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, 
			String luogoNascita, Sesso sesso, long pIVA, Posizione posizione, String nomeAttività) {
		
		Negoziante negoziante = new Negoziante(codiceFiscale, nome, cognome, dataNascita, luogoNascita, sesso, pIVA);
		if (controllaNegoziante(negoziante)) {
			throw new IllegalArgumentException ("Questo negoziante esiste già!! Selezionalo dalla lista...");
		}
		
		negozianti.add(negoziante);
		Negozio negozio = new Negozio (negoziante, posizione, nomeAttività);
		negozi.add(negozio);
	}
	
	// Si seleziona il negoziante dalla lista dei negozianti e quando viene chiamato il metodo, questo riceve come parametro
	// in ingresso il negoziante selezionato
	public void creaNegozioConSelezione(Negoziante negoziante, Posizione posizione, String nomeAttività) {
		Negozio negozio = new Negozio(negoziante, posizione, nomeAttività);
		negozi.add(negozio);
	}
	
	private boolean controllaNegoziante (Negoziante negoziante) {
		if (negozianti.contains(negoziante)) {
			return true;
		} else {
			return false;
		}
	}

}
