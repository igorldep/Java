package exercicio1;

/**
 *
 * @author Igor Luciano de Paula
 */
public class ContaCorrente extends Conta{
        
    public double limite;
    
    public ContaCorrente(int agencia, long num, double limite) {
        super (agencia, num);
        this.limite = limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }
    
    @Override
    public double getSaldoTotal(){
        return ( saldo + limite );
    }
}
