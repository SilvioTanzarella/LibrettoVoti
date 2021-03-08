package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Libretto {

	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<>();
	}
	
	public void add(Voto v) {
		for(Voto vi: this.voti) {
			if(vi.getNome().equals(v.getNome()))
				return;
		}
		this.voti.add(v);
	}
	
	/* queste due funzioni FANNO SCHIFO
	public void stampaVotiUguali(int punteggio) {
		//il libretto stampa da solo i voti
	}
	
	public String votiUguali(int punteggio) {
		//calcola una stringa che contiene i voti
		//sarà poi il chiamante a stamparli
		//-> solo il nome?
		//->tutto il voto.toString()
	}
	*/
	public List<Voto> listaVotiUguali(int punteggio){
		//espone all'esterno il tipo di struttura interna utilizzata
		List<Voto> risultato = new ArrayList<>();
		for(Voto v:this.voti) {
			if(v.getVoto() == punteggio) {
				risultato.add(v);
			}
		}
		return risultato;
	}
	
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato = new Libretto();
		for(Voto v:this.voti) {
			if(v.getVoto() == punteggio) {
				risultato.add(v);
			}
		}
		return risultato;
	}
	
	
	public String toString() {
		String s = "";
		for(Voto v: this.voti) {
			s = s + v.toString() + "\n";
		}
		return s;
	}
	/**
	 * Ricerca un Voto del corso di cui è specificato il nome
	 * Se il corso non esiste, restituisce null
	 * @param nomeCorso
	 * @return
	 */
	public Voto ricercaCorso(String nomeCorso) {
		Voto risultato = null;
		for(Voto v:this.voti) {
			if(v.getNome().equals(nomeCorso)) {
				risultato = v;
			}
		}
		return risultato;
	}
	
	public Libretto librettoMigliorato() {
		Libretto l = new Libretto();
		for(Voto v:this.voti)
		{
			
			l.add(new Voto(v.getNome(), v.getVoto(), v.getData()));
		}
		
		for(Voto vi : l.voti) {
			if(vi.getVoto() <= 23)
				vi.setVoto(vi.getVoto()+1);
			if((vi.getVoto() > 23) && (vi.getVoto() <= 28))
				vi.setVoto(vi.getVoto()+2);
			if(vi.getVoto() == 29)
				vi.setVoto(30);
		}
		return l;
		
	}
	
	public String librettoOrdinatoPerNome() {
		Collections.sort(this.voti);
		String s = "";
		for(Voto v:this.voti) {
			s += "Esame "+v.getNome()+" superato con "+v.getVoto()+" il "+v.getData()+"\n";
		}
		return s;
	}
	
	public String librettoOrdinatoPerVoto() {
		ComparatoreVoto com = new ComparatoreVoto();
		Collections.sort(this.voti, com);
		String s = "";
		for(Voto v:this.voti) {
			s += "Esame "+v.getNome()+" superato con "+v.getVoto()+" il "+v.getData()+"\n";
		}
		return s;
	}
	
	public void cancellaVotiInferiore(int valore) {
		for(int i=0;i<this.voti.size();i++)
		{
			if(voti.get(i).getVoto() < valore)
				{
					voti.remove(i);
				}
		}
	}
}
