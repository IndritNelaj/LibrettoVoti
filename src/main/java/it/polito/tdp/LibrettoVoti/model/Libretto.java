package it.polito.tdp.LibrettoVoti.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Libretto {
	private List<Voto> voti;
	private Map<String, Voto> votiMap; // identity Map nome esame -> oggetto voto , se creo la mappa devo sempre
										// tenerla aggiornata

	public Libretto() {
		voti = new ArrayList<>();
		votiMap = new HashMap<String, Voto>();
	}

	public void add(Voto v) {
		if(this.esisteDuplicato(v)==false || this.esisteConflitto(v)==false) {
		this.voti.add(v);
		this.votiMap.put(v.getNome(), v);
		}
	}

	/*
	 * non vanno bene!!
	 * 
	 * public void stampaVotiUguali(int punteggio) { // stampa solo voti con quel
	 * punteggio }
	 * 
	 * public String votiUguali (int punteggio) { // crea una stringa che contiene i
	 * voti // sara poi il chiamante a stamparli // solo il nome ? // tutto il
	 * Voto.toString() ? }
	 */
	public List<Voto> listaDiVotiUguali(int punteggio) {
		// restituisce solo i voti uguali al punteggio
		List<Voto> risultato = new ArrayList<>();
		for (Voto v : this.voti) {
			if (v.getVoto() == punteggio)
				risultato.add(v);
		}
		return risultato;
	}

	public Libretto votiUguali1(int punteggio) {
		// restituisce un libretto con i voti filtrati per quel punteggio specifico
		// il libretto ha gia tutti i metodi che servono
		Libretto risultato = new Libretto();
		for (Voto v : this.voti) {
			if (v.getVoto() == punteggio)
				risultato.add(v);
		}
		return risultato;

	}

	public Voto cercaCorso(String nomeCorso) {
		/**Voto voto = null;
		for (Voto v : this.voti) {
			if (v.getNome().equals(nomeCorso)) {
				voto = v;
				break;
			}
		}
		return voto;
		*/
		return votiMap.get(nomeCorso); // cerca il Voto dentro la mappa tramite la key nomeCorso , se non la trova ritorna null
	}

	/**
	 * verifica se nel libretto c'è più di un Voto con un esame con lo stesso nome e
	 * lo stesso votazione
	 * 
	 */
	public boolean esisteDuplicato(Voto v) {
		/**
		 * boolean trovato = false; for(Voto voto:voti) {
		 * if(voto.getNome().equals(v.getNome()) && voto.getVoto()==v.getVoto()) {
		 * trovato = true; break ; } } return trovato;
		 */
		Voto trovato = votiMap.get(v.getNome());
		if (trovato == null)
			return false;
		if (trovato.getVoto() == v.getVoto())
			return true;
		else
			return false;
	}

	/**
	 * Verificare se esiste un voto con stesso nome esame ma diversa votazione
	 * 
	 */
	public boolean esisteConflitto(Voto v) {
		/**
		 * boolean trovato = false; for (Voto voto : voti) { if
		 * (voto.getNome().equals(v.getNome()) && voto.getVoto() != v.getVoto()) {
		 * trovato = true; break; } } return trovato;
		 */
		Voto trovato = votiMap.get(v.getNome());
		if (trovato == null)
			return false;
		if (trovato.getVoto() != v.getVoto())
			return true;
		else
			return false;
	}

	public String toString() {
		String r = "";
		for (Voto v : voti) {
			r = r + v.toString() + "\n";
		}
		return r;
	}

}
