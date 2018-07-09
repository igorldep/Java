
package Pratica07;

public class Main {

    public static void main(String[] args) throws Exception {

        JGrafo jg1 = new JGrafo(6);
        int v1=1,v2=2,v3=3,v4=4,v5=5;
        jg1.insereAresta(v1, v2, 8, 3); 
        jg1.insereAresta(v1, v3, 4, 10);
        jg1.insereAresta(v1, v4, 5, 2); 
        jg1.insereAresta(v2, v5, 9, 5); 
        jg1.insereAresta(v3, v5, 5, 2); 
        jg1.insereAresta(v4, v2, 3, 8); 
        jg1.insereAresta(v4, v5, 2, 7); 
        
        System.out.println( "Primeiro Grafo");
        JAEDsMaps j1 = new JAEDsMaps(jg1,v1,v5);
        j1.obterArvoreCMC(v1);
        System.out.println("Arvore p/ destino: \n ");
        j1.imprimeCaminho(v1, v5);
        j1.imprimeTotal();
        j1.mudarEstado();
        j1.obterArvoreCMC(v1);
        System.out.println("\nArvore p/ tempo: \n ");
        j1.imprimeCaminho(v1, v5);
        j1.imprimeTotal();
       
        
        JGrafo jg2 = new JGrafo(6);
        int a=1,b=2,c=3,d=4,e=5;
        jg2.insereAresta(a, b, 3, 3); 
        jg2.insereAresta(a, d, 5, 5); 
        jg2.insereAresta(b, c, 2, 6); 
        jg2.insereAresta(b, d, 2, 2); 
        jg2.insereAresta(c, e, 2, 2); 
        jg2.insereAresta(d, b, 3, a); 
        jg2.insereAresta(d, c, 5, 4);
        jg2.insereAresta(d, e, 9, 6); 
        jg2.insereAresta(e, a, 6, 3);
        jg2.insereAresta(e, c, 4, 7); 
        
        System.out.println("Segundo Grafo");
        JAEDsMaps j2 = new JAEDsMaps(jg2,d,a);
        j2.obterArvoreCMC(v1);
        System.out.println("Arvore p/ destino: \n ");
        j2.imprimeCaminho(v1, v5);
        j2.imprimeTotal();
        j2.mudarEstado();
        j2.obterArvoreCMC(d);
        System.out.println("\nArvore p/ tempo: ");
        j2.imprimeCaminho(d,a);
        j2.imprimeTotal();
    }
    
}
