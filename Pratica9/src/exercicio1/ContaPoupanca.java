package exercicio1;

/**
 *
 * @author Igor Luciano de Paula
 */
public class ContaPoupanca extends Conta {
    
    public double rendimento;
    
    public ContaPoupanca(int agencia, long num, double rendimento) {
        super (agencia, num);
        this.rendimento = rendimento;
    }
    
    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public double getRendimento() {
        return rendimento;
    }
 
    @Override
    public double getSaldoTotal(){
        return ( saldo + rendimento );
    }
}
