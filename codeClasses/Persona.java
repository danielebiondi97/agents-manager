package it.unifi.ing.gel.swe.elaborato;

import java.time.LocalDate;

public abstract class Persona {
	
	protected String codiceFiscale;
	protected String nome;
	protected String cognome;
	protected LocalDate dataNascita;
	protected String luogoNascita;
	protected Sesso sesso;
	
	public Persona (String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String luogoNascita, Sesso sesso) {
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.sesso = sesso;
	}
	
	
	public String getCodiceFiscale() { return codiceFiscale; }

	public String getNome() { return nome; }

	public String getCognome() { return cognome; }

	public LocalDate getDataNascita() { return dataNascita; }

	public String getLuogoNascita() { return luogoNascita; }

	public Sesso getSesso() { return sesso; }


	@Override
	public String toString () {
		return "Persona [codiceFiscale = " + codiceFiscale + ", nome = " + nome + ", cognome = " + cognome + ", dataNascita = " + dataNascita + 
				", luogoNascita = " + luogoNascita + ", sesso = " + sesso + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null ) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		
		Persona other = (Persona) obj;
		
		
		 if (this.codiceFiscale == null) {
			if (other.codiceFiscale != null) {
				return false;
			}
		} else if (!this.codiceFiscale.equals(other.codiceFiscale)) {
			return false;
		}
		
		if (this.nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!this.nome.equals(other.nome)) {
			return false;
		}
		
		if (this.cognome == null) {
			if (other.cognome != null) {
				return false;
			}
		} else if (!this.cognome.equals(other.cognome)) {
			return false;
		}
		
		if (this.dataNascita == null) {
			if (other.dataNascita != null) {
				return false;
			}
		} else if (!this.dataNascita.equals(other.dataNascita)) {
			return false;
		}
		
		if (this.luogoNascita == null) {
			if (other.luogoNascita != null) {
				return false;
			}
		} else if (!this.luogoNascita.equals(other.luogoNascita)) {
			return false;
		}
		
		if (this.sesso == null) {
			if (other.sesso != null) {
				return false;
			}
		} else if (!this.sesso.equals(other.sesso)) {
			return false;
		}
		
		return true; 
	}
}