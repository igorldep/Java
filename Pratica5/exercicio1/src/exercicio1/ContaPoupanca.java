package exercicio1;

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
