package it.polito.tdp.LibrettoVoti.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	private List<Voto> voti;

	public Libretto() {
		voti = new ArrayList<>();
	}

	public void add(Voto v) {
		this.voti.add(v);
	}
	/* non vanno bene!!
	 * 
	public void stampaVotiUguali(int punteggio) {
		// stampa solo voti con quel punteggio
	}
	
	public String votiUguali (int punteggio) {
		// crea una stringa che contiene i voti
		// sara poi il chiamante a stamparli
		// solo il nome ? 
		// tutto il Voto.toString() ?
	}
	 */
	public List<Voto> listaDiVotiUguali (int punteggio){
		// restituisce solo i voti uguali al punteggio
		List <Voto> risultato = new ArrayList<>();
		for(Voto v: this.voti) {
			if(v.getVoto()==punteggio)
			risultato.add(v);
		}
		return risultato;
	}
	
	public Libretto votiUguali1 (int punteggio) {
		// restituisce un libretto con i voti filtrati per quel punteggio specifico
		// il libretto ha  gia tutti i metodi che servono
		Libretto risultato = new Libretto();
		for(Voto v: this.voti) {
			if(v.getVoto()==punteggio)
				risultato.add(v);
		}
		return risultato;
	}
	
	public Voto cercaCorso (String nomeCorso) {
		Voto voto = null;
		for(Voto v: this.voti) {
			if(v.getNome().equals(nomeCorso)) {
				voto=v;
			break;
			}
		}
		return voto;
	}
	public String toString() {
		String r = "";
		for(Voto v : voti) {
			r = r +  v.toString() +"\n";
		}
		return r;
	}
	
	
}
