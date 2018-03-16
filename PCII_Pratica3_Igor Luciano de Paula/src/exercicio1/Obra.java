package exercicio1;

import java.util.GregorianCalendar;

public class Obra {
	public String nomeObra;
	public int codigoISBN;
	GregorianCalendar anoDePulica��o = new GregorianCalendar();
	
	public Obra(String nomeObra, int codigoISBN, GregorianCalendar anoDePulica��o) {
		this.nomeObra = nomeObra;
		this.codigoISBN = codigoISBN;
		this.anoDePulica��o = anoDePulica��o;
	}

	public String getNomeObra() {
		return nomeObra;
	}

	public int getCodigoISBN() {
		return codigoISBN;
	}


	public GregorianCalendar getAnoDePulica��o() {
		return anoDePulica��o;
	}

	public String toString() {
		return "Obra [ nomeObra = " + nomeObra + ",  codigoISBN = " + codigoISBN + ",  anoDePulica��o = " + anoDePulica��o + " ]";
	}
	
	
}
