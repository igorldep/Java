package exercicio1;

import java.util.GregorianCalendar;

public class Autor {
	public String nomeAutor;
	public String Sobrenome;
	GregorianCalendar dataDeNascimento = new GregorianCalendar();
	
	public Autor(String nomeAutor, String sobrenome, GregorianCalendar dataDeNascimento) {
		super();
		this.nomeAutor = nomeAutor;
		this.Sobrenome = sobrenome;
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getSobrenome() {
		return Sobrenome;
	}

	public GregorianCalendar getDataDeNascimento() {
		return dataDeNascimento;
	}

}
