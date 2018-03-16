/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;

/**
 *
 * @author Igor Luciano de Paula
 */

public class Teste {
	public static void main (String [] args){
		ContaPoupanca c1 = new ContaPoupanca(12548610);
		c1.setSaldo(100);
		System.out.println(c1.toString());
		c1.atualizaRendimento();
		System.out.println(c1.toString());
	}
}

