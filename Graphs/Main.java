
package Pratica05;


public class Main {

    public static void main(String[] args) throws Exception {
        JGrafo Grafo1 = new JGrafo(8);
        JCiclo c;
        Grafo1.insereAresta(0,1);
        Grafo1.insereAresta(1,0);
        Grafo1.insereAresta(0,3);
        Grafo1.insereAresta(3,0);
        Grafo1.insereAresta(0,4);
        Grafo1.insereAresta(4,0);
        Grafo1.insereAresta(1,2);
        Grafo1.insereAresta(2,1);
        Grafo1.insereAresta(1,5);
        Grafo1.insereAresta(5,1);
        Grafo1.insereAresta(2,6);
        Grafo1.insereAresta(6,2);
        Grafo1.insereAresta(2,3);
        Grafo1.insereAresta(3,2);
        Grafo1.insereAresta(3,7);
        Grafo1.insereAresta(7,3);
        Grafo1.insereAresta(4,5);
        Grafo1.insereAresta(5,4);
        Grafo1.insereAresta(4,7);
        Grafo1.insereAresta(7,4);
        Grafo1.insereAresta(5,6);
        Grafo1.insereAresta(6,5);
        Grafo1.insereAresta(6,7);
        Grafo1.insereAresta(7,6);
        c = new JCiclo(Grafo1);
        c.JCiclo(1); 
        if(Grafo1.Ciclico == true)
            System.out.println("Possui Ciclo");
        else
            System.out.println("Nao Possui Ciclo");
        Grafo1.imprime();
        
        JGrafo Grafo2 = new JGrafo(10);
        Grafo2.insereAresta(9, 6);
        Grafo2.insereAresta(0, 1);
        Grafo2.insereAresta(0, 2);
        Grafo2.insereAresta(0, 3);
        Grafo2.insereAresta(0, 5);
        Grafo2.insereAresta(5, 4);
        Grafo2.insereAresta(5, 6);
        Grafo2.insereAresta(1, 2);
        Grafo2.insereAresta(2, 3);
        Grafo2.insereAresta(2, 4);
        Grafo2.insereAresta(4, 6);
        Grafo2.insereAresta(6, 7);
        Grafo2.insereAresta(6, 8);
        Grafo2.insereAresta(7, 8);
        c = new JCiclo(Grafo2);
        c.JCiclo(0);
        if(Grafo2.Ciclico == true)
            System.out.println("Possui Ciclo");
        else
            System.out.println("Nao Possui Ciclo");
        Grafo2.imprime();
    }
    
}
