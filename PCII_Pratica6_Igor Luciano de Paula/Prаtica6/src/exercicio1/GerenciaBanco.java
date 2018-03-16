package exercicio1;

import java.awt.List;
import java.util.ArrayList;

public class GerenciaBanco {
	MesAno obja;
	
	List<Conta> listContas = new ArrayList<>();
		
	public GerenciaBanco(int mes, int ano){
		obja = new MesAno(mes, ano);
	}
	
	public GerenciaBanco(MesAno obja){
		if (obja == null)
			this.obja = new MesAno(1, 200);
		else
			this.obja = obja;
	}
	


}
