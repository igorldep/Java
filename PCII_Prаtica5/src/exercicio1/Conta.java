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
public class Conta{
	protected long numero;
	protected double saldo;
	
	public Conta(long num) {
		numero = num;
		saldo = 0;
	}
	
	public void depositar(double v){
		if ( v > 0)
			saldo = saldo + v;
	}
	public boolean sacar(double v){
	
		if( v > 0 && (( saldo - v) >= 0) ){
			saldo = saldo - v;
			return true;
		}
		else
			return false;
	}
	
	public void setSaldo(double saldo){
		this.saldo = saldo;
	}

	public String toString() {
		return "Conta [ numero = " + numero + " saldo = " + saldo + " ]";
	}
	
	
}
