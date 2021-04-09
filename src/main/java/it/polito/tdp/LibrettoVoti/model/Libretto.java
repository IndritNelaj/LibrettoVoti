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

	@Override
	public String toString() {
		String r = "";
		for(Voto v : voti) {
			r = r +  v.toString() +"\n";
		}
		return r;
	}
	
}
