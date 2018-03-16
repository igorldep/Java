package exercicio2;

public class Pessoa {
    protected int cpf;
    protected String rg;
    protected String nome;
    protected String cidade;
    protected String estado;
    protected String telefone;
    protected String estadoCivil;
        
    public Pessoa(int cpf, String rg, String nome, String cidade, String estado, String telefone, String estadoCivil) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.estadoCivil = estadoCivil;
    }
    
    //Não faz sentido alterar o conteúdo algumas variáveis 
    public int getCpf() {
        return cpf;
    }
    public String getRg() {
        return rg;
    }
    public String getNome() {
        return nome;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String toString() {
        return "Pessoa [ cpf=" + cpf + ", rg=" + rg + ", nome=" + nome + ", cidade=" + cidade + ", estado=" + estado
                + ", telefone=" + telefone + ", estadoCivil=" + estadoCivil + " ]";
    }
    
    
}
