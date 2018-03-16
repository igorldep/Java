package exercicio2;

public class Medico extends Pessoa {
    protected int crm;
    protected Especialidade especialidade;
    
    public Medico(int cpf, String rg, String nome, String cidade, String estado, String telefone, String estadoCivil, int crm, Especialidade especialidade) {
        super(cpf, rg, nome, cidade, estado, telefone, estadoCivil);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return " Medico [ crm = " + crm + ", especialidade = " + especialidade + Pessoa.toString() + " ]";
    }
    
}
