/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2;
/**
 *
 * @author alunoccc
 */
public class Time {
    
    public Atleta[] atletas;
    
    public Time (Atleta [] a){
        this.atletas = a;
    }
       
    public double [] getIMCAtletas(){
        double [] imcs = new double [atletas.length];
        
        for (int i = 0; i < imcs.length; i++){
            imcs[i] = atletas[i].getIMC();
        }
        
        return imcs;
    }
    
    public double getMediaIMC(double acumulador, double [] imcs2){
        acumulador = 0;
        imcs2 = getIMCAtletas();
        for (int i = 0; i < imcs2.length; i++){
            acumulador = acumulador + imcs2[i];
        }
        
        return (acumulador / imcs2.length);
    }
    
    public double getMaximoIMC(double [] imcs2){
        imcs2 = getIMCAtletas();
        double max = imcs2[0];
        for (int i = 0; i < imcs2.length; i++){
            if(max < imcs2[i])
                max = imcs2[i];
        }
        
        return max;
    }
    
    public double getMinimoIMC(double [] imcs2){
        imcs2 = getIMCAtletas();
        double min = imcs2[0];
        for (int i = 0; i < imcs2.length; i++){
            if(min < imcs2[i])
                min = imcs2[i];
        }
        
        return min;
    }
}
