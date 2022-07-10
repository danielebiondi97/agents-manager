package it.unifi.ing.gel.swe.elaborato;


public class Prodotto implements Comparable<Prodotto> {
	
	private String nome;
	private long codice;
	private double prezzo;
	
	public Prodotto (String nome, long codice, double prezzo) {
		this.nome = nome;
		this.codice = codice;
		this.prezzo = prezzo;
	}
	
	public String getNome() { return nome; }
	
	public long getCodice() { return codice; }
	
	public double getPrezzo() { return prezzo; }
	
	@Override
	public int compareTo (Prodotto o) {
		if (this.codice > o.codice) {
			return 1;
		}
		
		if (this.codice == o.codice) {
			return 0;
		}
		
		else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		return "Prodotto [nome = " + nome + ", codice = " + codice + ", prezzo = " + prezzo + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} 
		if(obj == null) {
			return false;
		} 
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		Prodotto other = (Prodotto) obj;
		
		
		if (this.codice != other.codice) {
			return false;
		}
		
		return true;
	}

}
