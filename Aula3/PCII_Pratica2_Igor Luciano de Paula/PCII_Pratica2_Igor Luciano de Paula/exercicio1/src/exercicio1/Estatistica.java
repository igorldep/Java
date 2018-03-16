package exercicio1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author: Igor Luciano de Paula
 */
public class Estatistica {
      
    public static double media ( double[] valores ){
        
        double media, acumulador = 0;
        
        for( int i = 0; i < valores.length; i++ )
            acumulador = ( acumulador + valores[i] );

        return media = ( acumulador/valores.length );
    }
    
    public static double max( double[] valores ){
        
        double max = valores[0];
        
        for( int i = 1; i < valores.length; i++ ){
            if ( valores[i] > max)
                max = valores[i];
        }

        return max;
    }
    
    public static double min( double[] valores ){
        
        double min = valores[0];
        
        for( int i = 1; i < valores.length; i++ ){
            if ( valores[i] < min)
                min = valores[i];
        }

        return min;
    }
}
