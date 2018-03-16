package exercicio1;

public class Conta{
    protected long numero;
    protected double saldo;
    
    public Conta(long num) {
        numero = num;
        saldo = 0;
    }
    
    public void depositar(double v){
        if ( v > 0)
            saldo = saldo + v;
    }
    public boolean sacar(double v){
    
        if( v > 0 && (( saldo - v) >= 0) ){
            saldo = saldo - v;
            return true;
        }
        else
            return false;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    public double getSaldoTotal(){
    	return saldo;
    }

    public String toString() {
        return "Conta [ numero = " + numero + " saldo = " + saldo + " ]";
    }
    
    
}
