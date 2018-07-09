/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica1;

/**
 *
 * @author Igor Luciano de Paula & Eduardo Junqueira
 */

import java.util.Random;
import java.util.Arrays;

public class Pratica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
    
        ArvoreBinaria  binarytree = new ArvoreBinaria();
        Random gerador = new Random();
        
        int n, i, x, num;
        n = 9000; i = 0; x = 1000000000;
        
        int [] v = new int [n];
        
        while(i < n){
            num = positivo(gerador.nextInt());
            
            if ( num != x) //x: elemento que não existe na árvore.
                v[i] = num;
            
            i++;
        }
        
        //Aleatórios
        //Arrays.sort(v);
                
        //Inserção
        for (i = 0; i < n; i++){
            Item item_int = new Item (v[i]);//Cria item item_int passado int como chave para fazer a mudança: int -> item
            binarytree.insere(item_int); //Adiciona elemento (item) na árvore.
        }
        
        //Pesquisa
        Item item_int = new Item (x);
        
        double timein = System.nanoTime();
        binarytree.pesquisa(item_int);
        double timeout = System.nanoTime();
        
        double timetotal = timeout-timein;
        
        System.out.println(timetotal);
    }
    
    //Transforma em positivo, caso não seja
    public static int positivo(int x){
        if(x < 0)
            return (x * (-1));
        else
            return x;
    }
    
}

/*//Verificando Ordenação
        for(i = 0; i < n; i++){            
            System.out.print(Arrays.asList(v[i]));
        }*/
        
        /* Teste Positivo
        int n = 10 - 12;
        n = positivo(n);
        System.out.println(n);
*/