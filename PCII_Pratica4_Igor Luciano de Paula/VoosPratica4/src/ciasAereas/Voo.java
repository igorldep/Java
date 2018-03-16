package ciasAereas;

import geo.Cidade;

public class Voo {
    private CiaAerea ciaAerea;
    private Cidade cidOrigem;
    private Cidade cidDestino;
    private int numVoo;
    public Voo(int numero,CiaAerea ciaAerea,Cidade cidOrigem,Cidade cidDestino)
    {
        this.numVoo = numero;
        this.ciaAerea = ciaAerea;
        this.cidOrigem = cidOrigem;
        this.cidDestino = cidDestino;
    }
    public int getNumVoo() {
        return numVoo;
    }
    public void setNumVoo(int numVoo) {
        this.numVoo = numVoo;
    }
    public CiaAerea getCiaAerea() {
        return ciaAerea;
    }
    public Cidade getCidOrigem() {
        return cidOrigem;
    }
    public Cidade getCidDestino() {
        return cidDestino;
    }
    
    public String toString()
    {
        return numVoo+" - De: "+cidOrigem+" Para: "+cidDestino;
    }
}
