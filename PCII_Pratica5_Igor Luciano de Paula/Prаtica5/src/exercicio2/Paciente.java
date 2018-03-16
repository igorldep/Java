package exercicio2;

public class Paciente extends Pessoa{
    protected Convenio convenio;
    
    public Paciente(int cpf, String rg, String nome, String cidade, String estado, String telefone, String estadoCivil, Convenio convenio) {
        super(cpf, rg, nome, cidade, estado, telefone, estadoCivil);
        this.convenio = convenio;
    }

    @Override
    public String toString() {
        return "Paciente [ convenio = " + convenio + Pessoa.toString() + " ]";
    }
    
    
}
