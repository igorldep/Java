package exercicio1;

/**
 *
 * @author Igor Luciano de Paula
 */
public class Main {
    public static void main (String[] args){
        
        ContaCorrente cc1 = new ContaCorrente(1222, 23467444, 30000.0);
        ContaCorrente cc2 = new ContaCorrente(1223, 22137434, 1000.0);
        
        ContaPoupanca cp1 = new ContaPoupanca(1222, 23467444, 0.2);
        ContaPoupanca cp2 = new ContaPoupanca(1222, 23467444, 0.3);
        
        cc1.setSaldo(8000);
        System.out.println("\nSaldo total de cc1: " +cc1.getSaldoTotal());
        cp2.setRendimento(0.6);
        System.out.println("Rendimento de cp2: " +cp2.getRendimento() + "\n\n");
    }
}
