package exercicio1;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        
        float raio;
        float altura;
        
        Scanner in = new Scanner (System.in);
        
        System.out.print("Digite o valor do raio do cilindro: ");
        raio = in.nextFloat();
        System.out.print("Digite o valor da altura do cilindro: ");
        altura = in.nextFloat();
        
        Cilindro c = new Cilindro(raio, altura);
        //c.setAltura(12);
        
        System.out.println("O valor do raio é: " +c.getRaio());
        System.out.println("O valor da altura é: " +c.getAltura());
        System.out.println("O valor da área lateral é: " +c.a_lateral());
        System.out.println("O valor da área da base é: " +c.a_base());
        System.out.println("O valor da área total é: " +c.a_total());
        
    }
}
