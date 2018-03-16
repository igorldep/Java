package geo;

public class Cidade {
    private String nome;
    private Estado estado;
    public Cidade(String nome,Estado e)
    {
        this.nome = nome;
        this.estado = e;
        this.estado.adicionaCidade(this);
    }
    public String getNome()
    {
        return this.nome;
    }
    public String toString()
    {
        //retorna uma string com: nome da cidade/sigla_estado - nome_pais
        return this.nome+"/"+this.estado.getSigla();
    }
    public boolean equals(Object o)
    {
        if(o instanceof Cidade)
        {
            Cidade c = (Cidade) o;
            return this.nome.equalsIgnoreCase(c.getNome());
        }
        return false;
    }
}
