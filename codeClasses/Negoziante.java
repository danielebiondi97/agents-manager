package it.unifi.ing.gel.swe.elaborato;

import java.time.LocalDate;

public class Negoziante extends Persona{
	
	private long pIVA;
	
	public Negoziante (String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String luogoNascita, Sesso sesso, long pIVA) {
		super (codiceFiscale, nome, cognome, dataNascita, luogoNascita, sesso);
		this.pIVA = pIVA;
	}
	
	public long getPIVA() { return pIVA; }
	
	@Override
	public String toString() {
		return "Negoziante [codiceFiscale = " + codiceFiscale + ", nome = " + nome + ", cognome = " + cognome + ", dataNascita = " + dataNascita + 
				", luogoNascita = " + luogoNascita + ", sesso = " + sesso + ", pIVA = " + pIVA + "]";
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
		
		Negoziante other = (Negoziante) obj;
		
		if (this.pIVA != other.pIVA) {
			return false;
		}
		
		return true;
	}
	
}
