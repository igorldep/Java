package exercicio1;

public class ContaCorrente extends Conta{
	private double limite;

	public ContaCorrente(long num, double limite) {

		super(num);
		if (limite > 0)
			this.limite = limite;
	}

	public void setLimite(double l){
		if ( l > 0 )
			limite = l;
	}

	public boolean sacar(double v){
		if (v>0 && ((this.getSaldoTotal() - v ) >= 0) ){
			saldo = saldo - v;
			return true;
		}
		else
			return false;
	}

	public double getSaldoTotal(){
		return(saldo + limite);
	}

	@Override
	public String toString() {
		return "ContaCorrente [limite=" + limite + ", getSaldoTotal()=" + getSaldoTotal() + "]";
	}


}
