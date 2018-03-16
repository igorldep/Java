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

public class ContaPoupanca extends Conta {
	private double rendimento;
	
	public ContaPoupanca(long num){
		super (num);
		this.rendimento = 0.4;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
	
	public void atualizaRendimento(){
		saldo = saldo + ( saldo * rendimento );
	}
}

