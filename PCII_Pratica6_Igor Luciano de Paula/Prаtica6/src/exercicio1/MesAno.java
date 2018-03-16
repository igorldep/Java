package exercicio1;

public class MesAno {
	protected int mes;
	protected int ano;
	
	public MesAno (int mes, int ano){
		this.mes = mes;
		this.ano = ano;
	}
	
	public MesAno (int ano){
		this.mes = 1;
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}
	
	public void mudouMes(){
		if (mes < 12)
			mes ++;
		else{ //mes = 12
			mes = 1;
			mes ++;
		}
	}

	@Override
	public String toString() {
		return "MesAno [ mes = " + mes + ", ano = " + ano + " ]";
	}
	
	
}
