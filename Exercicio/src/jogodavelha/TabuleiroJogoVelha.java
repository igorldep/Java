/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

/**
 *
 * @author Igor Luciano de Paula
 */
public class TabuleiroJogoVelha {
    private char[][] tabuleiro;
    
    public TabuleiroJogoVelha(){
        zerarTabuleiro();
    }
    
    public void zerarTabuleiro(){
        for ( int i = 0; i < 2; i++ ){ //Linha
            for ( int j = 0; j < 2; j++ ){ //Coluna
                tabuleiro[i][j] = ' ';
            }
        }
    }
    
    public void imprimirTabuleiro(){
        for ( int i = 0; i < 2; i++ ){ //Linha
            for ( int j = 0; j < 2; j++ ) //Coluna
                System.out.println(" Imprimir a tabela ");
        }
    }
    
    public boolean checarLinhas (){
        int cont = 0, k = 1;
        
        for ( int i = 0; i < 2; i++ ){
            for ( int j = 0; j < 2; j++ ){
                if ( tabuleiro[i][j] = tabuleiro[i][k] ){
                    cont ++;
                    k ++;
                }
            }
        }
        
        if ( cont == 2 )
            return true;
        else
            return false;
    }
}