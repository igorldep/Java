/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;

import java.util.Scanner;

/**
 * @author: Igor Luciano de Paula
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Scanner in = new Scanner (System.in);
        
        System.out.println("\nDigite o tamanho do vetor: ");
        int tamanho = in.nextInt();
        
        double[] valores = new double[tamanho];
        
        for ( int i = 0; i < tamanho; i++  ){
            System.out.printf("\nDigite o valor do %d número: ", i+1);
            valores[i] = in.nextDouble();
        }
               
        System.out.println("\nMedia do vetor: " +Estatistica.media(valores));
        System.out.println("\nMaior valor do vetor: " +Estatistica.max(valores));
        System.out.println("\nMenor valor do vetor: " +Estatistica.min(valores));
    }
}