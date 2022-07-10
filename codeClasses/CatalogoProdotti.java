package it.unifi.ing.gel.swe.elaborato;


import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class CatalogoProdotti {
	
	private Set<Prodotto> prodotti;
	
	public CatalogoProdotti() {
		prodotti = new TreeSet<>();
	}
	
	public Set<Prodotto> getProdotti() {
		return Collections.unmodifiableSet(prodotti);
	}
	
	public Set<Prodotto> getProdottiByNome() {
		Set<Prodotto> ordinatiByNome = new TreeSet<>(new prodottiByNome());
		ordinatiByNome.addAll(prodotti);
		return Collections.unmodifiableSet(ordinatiByNome);
	}
	
	public Set<Prodotto> getProdottiByPrezzo() {
		Set<Prodotto> ordinatiByPrezzo = new TreeSet<>(new prodottiByPrezzo());
		ordinatiByPrezzo.addAll(prodotti);
		return Collections.unmodifiableSet(ordinatiByPrezzo);
	}
	
	public void aggiungiProdotto(String nome, long codice, double prezzo) {
		Prodotto prodotto = new Prodotto(nome, codice, prezzo);
		prodotti.add(prodotto);
	}
	
	public void rimuoviProdotto(Prodotto prodotto) {
		prodotti.remove(prodotto);
	}

}
