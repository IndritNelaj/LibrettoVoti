package it.polito.tdp.LibrettoVoti.model;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {
	public static void main(String[] args) {
		System.out.println(" - Test Metodi di Libretto - ");
		Libretto libretto = new Libretto();
		Voto voto1 = new Voto("Analisi 1", 30, LocalDate.of(2019, 2, 15));
		libretto.add(voto1);
		libretto.add(new Voto("Fisica 1",28,LocalDate.of(2019, 7, 15)));
		libretto.add(new Voto("Chimica",25,LocalDate.of(2019, 6, 17)));
		libretto.add(new Voto("Informatica",24,LocalDate.of(2019, 9, 15)));
		
		System.out.println(libretto);
		List<Voto> venticinque = libretto.listaDiVotiUguali(25);
		System.out.println(venticinque);
		
		Libretto librettoVenticinque = libretto.votiUguali1(25);
		System.out.println(librettoVenticinque);
		
		Voto cercavoto= libretto.cercaCorso("Informatica");
		System.out.println("il voto dell' esame "+cercavoto.getNome() +" è : " + cercavoto.getVoto());
		
		Voto cercavoto1= libretto.cercaCorso("Informatica");
		System.out.println(cercavoto1);
		
		Voto cercavoto2= libretto.cercaCorso("Analisi 3");
		System.out.println(cercavoto2);
		
		Voto chimica = libretto.cercaCorso("Chimica");
		Voto chimicaDoppio = new Voto("Chimica",25,LocalDate.of(2019, 6, 17));
		Voto chimicaConflitto = new Voto("Chimica",18,LocalDate.of(2019, 6, 17));
	
		System.out.println(chimica + " doppione di "+ chimicaDoppio + " -> " + libretto.esisteDuplicato(chimicaDoppio));
		System.out.println(chimica + " doppione di "+ chimicaConflitto + " -> " + libretto.esisteDuplicato(chimicaConflitto));
		
		System.out.println(chimica + " in conflitto con "+ chimicaDoppio + " -> " + libretto.esisteConflitto(chimicaDoppio));
		System.out.println(chimica + " in conflitto con "+ chimicaConflitto + " -> " + libretto.esisteConflitto(chimicaConflitto));
	}
}
