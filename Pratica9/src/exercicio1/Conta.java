package exercicio1;

/**
 *
 * @author Igor Luciano de Paula
 */
public abstract class Conta {
    
    public int agencia;
    public long num;
    public double saldo;

    public Conta(int agencia, long num) {
        this.agencia = agencia;
        this.num = num;
        this.saldo = 0;
    }
    
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
        
    public double getAgencia() {
        return agencia;
    }

    public double getNum() {
        return num;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public abstract double getSaldoTotal();
    
}