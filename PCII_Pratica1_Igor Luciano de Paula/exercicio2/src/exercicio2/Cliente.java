package exercicio2;

public class Cliente {

    public int codigo;
    public String nome;
    public boolean eClienteEspecial;
    public double limiteCredito;

    public Cliente(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
        limiteCredito = 0;
        eClienteEspecial = false;
    }
 
    public String getNome(){
        return nome;
    }
    
    public boolean atualizaLimite ( boolean eClienteEspecial, double limiteCredito ){
        if (eClienteEspecial){
            this.limiteCredito = limiteCredito;
            return (true);
            break;
        }
        
        return (false);
    }
    
    public boolean atualizaSituacao ( boolean eClienteEspecial ) {
        if (atualizaLimite(false, 0)){
            eClienteEspecial = true;
        }
        else{
            limiteCredito = 0;
        }
    }
    
    public String toString(){
        String strCliente = "\nNome: " +this.nome;
        strCliente += "\nCódigo: " +this.codigo;
        strCliente += "\nCliente Especial: " +this.eClienteEspecial;
        strCliente += "\nLimite de Crédito: " +this.limiteCredito;
        
        return strCliente;
    }
    

}
