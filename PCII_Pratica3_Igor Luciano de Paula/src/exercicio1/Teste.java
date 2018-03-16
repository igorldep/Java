package exercicio1;

import java.util.GregorianCalendar;

public class Teste {
	
	public static void main (String[], args){
	
	Pais p = new Pais ("Brazil");
	
	Cidade c = new Cidade ("Belo Horizonte");
	
	Editora e = new Editora ("XPTO");
	
	Autor a1 = new Autor ("Igor","L de Paula",new GregorianCalendar (1996, 10, 3));
	Obra o1 = new Obra ("O mundo assombrado pelos demonios", 13131329, new GregorianCalendar (2000, 10, 3));
	
	Autor a2 = new Autor ("Daniel", "Bruno", new GregorianCalendar (1990, 7, 8));
	Obra o2 = new Obra ("Programação Orientada a Objetos", 3231169, new GregorianCalendar (2003, 1, 5));
	
	Autor a3 = new Autor ("Sandra", "Mara", new GregorianCalendar (1993, 6, 2));
	Obra o3 = new Obra ("Cálculo 1", 3231169, new GregorianCalendar (2001, 11, 9));
	
	System.out.println("\n\tDados da agenda: " +o1.toString());
	System.out.println("\n\tDados da agenda: " +o2.toString());
	System.out.println("\n\tDados da agenda: " +o3.toString());
	}
	}