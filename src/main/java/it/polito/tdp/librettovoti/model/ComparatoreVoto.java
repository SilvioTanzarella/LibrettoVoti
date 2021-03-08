package it.polito.tdp.librettovoti.model;

import java.util.Comparator;

public class ComparatoreVoto implements Comparator<Voto>{

	@Override
	public int compare(Voto a1, Voto a2) {
		return -(a1.getVoto()-a2.getVoto());
	}
	

}
