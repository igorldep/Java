package geo;

import java.util.ArrayList;
import java.util.List;

public class Estado {
    private String nome;
    private String sigla;
    private List<Cidade> lstCidades = new ArrayList<Cidade>();
    
    public Estado(String nome, String sigla)
    {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public List<Cidade> getLstCidades()
    {
        return lstCidades;
    }
    
    public void adicionaCidade(Cidade c)
    {
        this.lstCidades.add(c);
    }
}
