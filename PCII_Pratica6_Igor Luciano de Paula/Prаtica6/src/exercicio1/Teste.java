package exercicio1;

public class Teste {
    public static void main (String [] args){
        
        ContaPoupanca c1 = new ContaPoupanca(12548610);
        c1.setSaldo(100);
        System.out.println(c1.toString());
        c1.atualizaRendimento();
        System.out.println(c1.toString());
    }
}
