package it.unifi.ing.gel.swe.elaborato;

import java.time.LocalDate;

public class Visita {
	
	private String resoconto;
	private LocalDate data;
	private Negozio negozio;
	private Viaggio viaggio;
	
	public Visita (String resoconto, LocalDate data, Negozio negozio, Viaggio viaggio) {
		this.resoconto = resoconto;
		this.data = data;
		this.negozio = negozio;
		this.viaggio = viaggio;
	}
	
	public LocalDate getData() { return data; }

	public String getResoconto() { return resoconto; }
	
	public Negozio getNegozio() { return negozio; }
	
	public Viaggio getViaggio() { return viaggio; }

	@Override
	public String toString() {
		return "Visita [resoconto = " + resoconto + ", data = " + data + ", negozio = " + negozio + ", viaggio = " + viaggio + ", agente = " + viaggio.getAgente() + "]";
	}
	
	// L'equals non viene implementato perché il sistema non consente l'aggiunta di una visita se è già presente una visita allo stesso
	// negozio effettuata meno di 60 giorni prima
	
}
