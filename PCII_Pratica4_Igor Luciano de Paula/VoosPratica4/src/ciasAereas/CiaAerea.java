package ciasAereas;

public class CiaAerea {
    private String nome;
    private String sigla;
    
    public CiaAerea(String sigla, String nome){
        this.sigla = sigla;
        this.nome = nome;
    }
    
    public String toString(){
        return sigla+" - "+nome;
    }
}
