package it.unifi.ing.gel.swe.elaborato;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Demo {
	
	public static void main (String [] args ) {
				
		// Nel momento in cui il proprietario mette in funzione il sistema per la prima volta viene istanziato
		
		Proprietario proprietario = new Proprietario();
		
		// e viene creato un catalogo di prodotti vuoto
		
		CatalogoProdotti cat1 = new CatalogoProdotti();
		
		// Il Proprietario aggiunge dei Prodotti al Catalogo: questo metodo è accessibile solo tramite l'interfaccia grafica
		// del Proprietario del sistema
		
		cat1.aggiungiProdotto("Scatolette al tonno gatti", 6575864, 1.49);
		cat1.aggiungiProdotto("Scatoletta al salmone per gatti", 8963544, 1.89);
		cat1.aggiungiProdotto("Crocchetta al tonno per gatti", 1237377, 10.99);
		cat1.aggiungiProdotto("Crocchette al salmone per gatti", 9284622, 13.99);
		cat1.aggiungiProdotto("Arnica per cavalli (ma qualcuno la usa anche per le persone)", 9275527, 199.99);
		cat1.aggiungiProdotto("Biscotti per cavalli", 2744183, 9.99);
		
		System.out.println("Stampa dei prodotti nel catalogo cat1 (ordinati di default per Codice) :");
		for (Prodotto prodotto: cat1.getProdotti()) {
			System.out.println("\t" + prodotto);
		}
		
		// Il Proprietario del Sistema (il proprietario dell'impresa o il responsabile delle risorse informatiche) crea 
		// degli agenti, assegnando loro i dati anagrafici, una zona geografica di competenza e un numero identificativo
		
		Agente leclerc = proprietario.creaAgente("CHRLCL", "Charles", "Leclerc", LocalDate.of(1997, 10, 16), "Monaco", Sesso.M, "Veneto", 1);
		Agente verstappen = proprietario.creaAgente("VRSMXA", "Max", "Verstappen", LocalDate.of(1997, 9, 30), "Olanda", Sesso.M, "Lombardia", 2);
		Agente perez = proprietario.creaAgente("PRZSRG", "Sergio", "Perez", LocalDate.of(1990, 1, 26), "Messico", Sesso.M, "Friuli", 3);
		Agente lombardi = proprietario.creaAgente("LMBMRG", "Maria Grazia", "Lombardi", LocalDate.of(1941, 3, 26), "Italia", Sesso.F, "Piemonte", 4);
		
		System.out.println("\n" + "Stampa degli agenti presenti nel sistema :");
		for (Agente agente: proprietario.getAgenti()) {
			System.out.println("\t" + agente);
		}
		
		//Verifica che effettivamente l'agente Leclerc sia il primo agente del proprietario
		
		System.out.println("\n" + "Leclerc è il primo agente del proprietario? : " + (leclerc == proprietario.getAgenti().get(0))); // expected: true
		
		// il Proprietario del sistema crea dei Negozi e i loro proprietari Negozianti assegnando ai Negozianti i dati anagrafici e la partita IVA
		// e ai negozi la posizione e il nome
		
		proprietario.creaNegozioCreaNegoziante("RSSGRG", "George", "Russell", LocalDate.of(1998, 2, 15), "Regno Unito", Sesso.M, 123456789,
				new Posizione (43.66666, 67.09090), "Farmacia Amica");
		
		proprietario.creaNegozioCreaNegoziante("HMLLWS", "Lewis", "Hamilton", LocalDate.of(1985, 1, 7), "Regno Unito", Sesso.M, 987654321,
				new Posizione (44.43666, 69.02590), "Rivendita al dettaglio S.r.l.");
		
		// il Proprietario crea i negozi selezionando il negoziante dalla lista dei negozianti già creati
		
		proprietario.creaNegozioConSelezione(proprietario.getNegozianti().get(0), new Posizione (45.43666, 68.02590), "La bottega degli animali");
		proprietario.creaNegozioConSelezione(proprietario.getNegozianti().get(1), new Posizione (46.43666, 64.02590), "Animal Planet");
		proprietario.creaNegozioConSelezione(proprietario.getNegozianti().get(0), new Posizione (43.79865665998937, 11.25320551232756), "Negozio che vende l'Arnica per cavalli");
		
		System.out.println("\n" + "Stampa dei negozianti presenti nel sistema :");
		for (Negoziante negoziante: proprietario.getNegozianti()) {
			System.out.println("\t" + negoziante);
		}
		
		System.out.println("\n" + "Stampa dei negozi presenti nel sistema :");
		for (Negozio negozio: proprietario.getNegozi()) {
			System.out.println("\t" + negozio);
		}
		
		//Il Proprietario del sistema aggiunge dei negozi alla lista di negozi di Leclerc (il primo agente)
		
		proprietario.getAgenti().get(0).aggiungiNegozio(proprietario.getNegozi().get(0));
		proprietario.getAgenti().get(0).aggiungiNegozio(proprietario.getNegozi().get(1));
		proprietario.getAgenti().get(0).aggiungiNegozio(proprietario.getNegozi().get(2));
		
		System.out.println("\n" + "Stampa dei negozi associati a Leclerc :");
		for (Negozio negozio: proprietario.getAgenti().get(0).getNegozi()) {
			System.out.println("\t" + negozio);
		}
		
		// e ne aggiunge anche alla lista di negozi di Verstappen
		proprietario.getAgenti().get(1).aggiungiNegozio(proprietario.getNegozi().get(3));
		proprietario.getAgenti().get(1).aggiungiNegozio(proprietario.getNegozi().get(4));
		
		System.out.println("\n" + "Stampa dei negozi associati a Verstappen :");
		for (Negozio negozio: proprietario.getAgenti().get(1).getNegozi()) {
			System.out.println("\t" + negozio);
		}
		
		// L'agente Leclerc sceglie in quali negozi andare nel suo prossimo viaggio in base a quali sono quelli ancora da visitare
		
		System.out.println("\n" + "I negozi che Leclerc può visitare prima di fare il suo viaggio: ");
		for (Negozio negozio: leclerc.negoziDaVisitare()) {
			System.out.println("\t" + negozio);
		}
		
		// Leclerc inizia a fare un viaggio
		leclerc.aggiungiViaggio(1);
		
		// Il sistema registra ogni intervallo di tempo (ex: ogni secondo) il momento e la posizione di Leclerc, e le inserisce 
		//all'interno del viaggio che Leclerc sta facendo
		
		leclerc.getViaggioInCorso().aggiungiPosizione(LocalDateTime.of(2022, 6, 5, 9, 23, 34), new Posizione (67.7877, 78.3487));
		leclerc.getViaggioInCorso().aggiungiPosizione(LocalDateTime.of(2022, 6, 5, 10, 9, 25), new Posizione (65.2393, 54.7694));
		leclerc.getViaggioInCorso().aggiungiPosizione(LocalDateTime.of(2022, 6, 5, 11, 12, 56), new Posizione (14.6593, 12.6793));
		leclerc.getViaggioInCorso().aggiungiPosizione(LocalDateTime.of(2022, 6, 5, 12, 48, 01), new Posizione (43.66666, 67.09090));
		leclerc.getViaggioInCorso().aggiungiPosizione(LocalDateTime.of(2022, 6, 5, 13, 8, 17), new Posizione (14.8630, 12.5494));
		leclerc.getViaggioInCorso().aggiungiPosizione(LocalDateTime.of(2022, 6, 5, 14, 28, 19), new Posizione (37.5309, 26.8409));
		
		System.out.println("\n" + "Viaggio in corso di Leclerc : " + "\t" + leclerc.getViaggioInCorso());
		
		
		// Leclerc consulta il catalogo dei prodotti ordinandoli per Nome
		
		System.out.println("\n" + "Stampa dei prodotti nel catalogo ordinati per Nome : ");
		for (Prodotto prodotto: cat1.getProdottiByNome()) {
			System.out.println("\t" + prodotto);
		}
		
		// Leclerc consulta il catalogo dei prodotti ordinandoli per Prezzo
		
		System.out.println("\n" + "Stampa dei prodotti nel catalogo ordinati per Prezzo : ");
		for (Prodotto prodotto: cat1.getProdottiByPrezzo()) {
			System.out.println("\t" + prodotto);
		}
		
		// Leclerc termina il viaggio
		
		leclerc.getViaggioInCorso().terminaViaggio();
		
		System.out.println("\n" + "Lo stato del viaggio di leclerc è : " + leclerc.getViaggi().get(0).getInCorso());
		
		// Leclerc controlla quanti km ha percorso durante il suo viaggio
		
		System.out.println("\n" + "km percorsi nel viaggio di Leclerc : " + leclerc.getViaggi().get(0).calcolaKm());
		
		// Leclerc controlla quanti km ha percorso in totale in tutti i suoi viaggi
		
		System.out.println("\n" + "km percorsi in totale da Leclerc : " + leclerc.calcolaKmTot());
		
		// Una volta che il viaggio è terminato, il sistema non ci può più aggiungere posizioni
		
		System.out.println("\n" + "Se si prova ad aggiungere una posizione ad un viaggio terminato...");
		
		try {
			leclerc.getViaggi().get(0).aggiungiPosizione(LocalDateTime.of(2022, 6, 5, 15, 9, 37), new Posizione (67.6477, 78.3787));
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}
		
		// Adesso che il viaggio è terminato, leclerc aggiunge delle visite al viaggio
		
		leclerc.getViaggi().get(0).aggiungiVisita("Visita a Farmacia Amica", LocalDate.of(2022, 6, 5), leclerc.getNegozi().get(0));
		leclerc.getViaggi().get(0).aggiungiVisita("Visita a Rivenditore al dettaglio", LocalDate.of(2022, 6, 5), leclerc.getNegozi().get(1));
		
		System.out.println("\n" + "Visite fatte da Leclerc nel suo viaggio: ");
		for (Visita visita: leclerc.getViaggi().get(0).getVisite()) {
			System.out.println("\t" + visita);
		}
		
		// dopo che la visita è stata aggiunta, lo stato dei negozi visitati passa da DA_VISITARE a VISITATO
		
		// Lo stato di Farmacia Amica adesso è VISITATO
		
		System.out.println("\n" + "Data dell'ultima visita di Farmacia amica : ");
		
		System.out.println("\t" + leclerc.getNegozi().get(0).getVisite().get(0).getData());
		
		System.out.println("\n" + "Stato di Farmacia Amica, visitata da Leclerc : " + leclerc.getNegozi().get(0).getStato());
		
		// Leclerc non può aggiungere una visita ad un negozio che ha visitato meno di 60 giorni fa
		
		System.out.println("\n" + "Leclerc prova ad aggiungere una visita fatta meno di 60 giorni fa e.. ");
		
		try {
			leclerc.getViaggi().get(0).aggiungiVisita("Visita a Farmacia Amica", LocalDate.of(2021, 6, 5), leclerc.getNegozi().get(0));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		// I negozi che Leclerc deve ancora visitare sono diminuiti
		
		System.out.println("\n" + "I negozi che Leclerc può visitare dopo aver fatto il suo viaggio: ");
		for (Negozio negozio: leclerc.negoziDaVisitare()) {
			System.out.println("\t" + negozio);
		}
		
		// Leclerc vuole vedere dov'è andato nel suo viaggio
		
		System.out.println("\n" + "Stampa delle posizioni di Leclerc durante il suo viaggio: ");
		leclerc.getViaggi().get(0).printPosizioni();
		
	}

}
