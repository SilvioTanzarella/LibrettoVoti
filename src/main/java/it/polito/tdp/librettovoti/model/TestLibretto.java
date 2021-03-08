package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

public class TestLibretto {
	
	public static void main(String[] args) {

	System.out.println("Test metodi di Libretto");
	Libretto libretto = new Libretto();
	
	Voto voto1 = new Voto("Analisi 1", 30, LocalDate.of(2019, 2, 15));
	libretto.add(voto1);
	libretto.add(new Voto("Informatica", 24, LocalDate.of(2019, 9, 15)));
	libretto.add(new Voto("Chimica", 22, LocalDate.of(2019, 2, 20)));
	libretto.add(new Voto("Fisica 1", 28, LocalDate.of(2019, 7, 15)));
	System.out.println("Punto 1");
	System.out.println(libretto);
	
	Libretto librettoventicinque = libretto.votiUguali(25);
	System.out.println("Punto 2\n"+librettoventicinque);
	
	Voto voto2 = libretto.ricercaCorso("Informatica");
	System.out.println("Punto 3");
	System.out.println(voto2);
	
	System.out.println("Libretto migliorato:\n"+libretto.librettoMigliorato());
	System.out.println("Libretto normale:\n"+libretto);
	
	System.out.println(libretto.librettoOrdinatoPerNome());
	
	System.out.println(libretto.librettoOrdinatoPerVoto());
	
	libretto.cancellaVotiInferiore(24);
	System.out.println("Libretto con voti sotto il 24 eliminati\n"+libretto);
	
	
	
	


	
	}
}