package exercicio1;

import java.util.GregorianCalendar;

public class Obra {
	public String nomeObra;
	public int codigoISBN;
	GregorianCalendar anoDePulicação = new GregorianCalendar();
	
	public Obra(String nomeObra, int codigoISBN, GregorianCalendar anoDePulicação) {
		this.nomeObra = nomeObra;
		this.codigoISBN = codigoISBN;
		this.anoDePulicação = anoDePulicação;
	}

	public String getNomeObra() {
		return nomeObra;
	}

	public int getCodigoISBN() {
		return codigoISBN;
	}


	public GregorianCalendar getAnoDePulicação() {
		return anoDePulicação;
	}

	public String toString() {
		return "Obra [ nomeObra = " + nomeObra + ",  codigoISBN = " + codigoISBN + ",  anoDePulicação = " + anoDePulicação + " ]";
	}
	
	
}
