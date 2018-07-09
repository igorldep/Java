package tp3;

import java.util.*;

public class CaixeiroViajante {
    private int numVertices;            /* número de vértices do grafo */
    private int [][] matrizAdjacencia;  /* matriz de adjacência do grafo */
    private int [] ciclo;               /* ciclo atual */
    private int [] melhorCiclo;         /* melhor ciclo encontrado */
    private int [] explorado;           /* vetor para armazenar se o vertice foi explorado pelo DFS*/
    private int nivel;                  /* profundidade alcancada pelo DFS*/
    private int min;
    
    public CaixeiroViajante(int[][] matriz) {
        this.numVertices = matriz.length;
        this.matrizAdjacencia = matriz;
        this.ciclo = new int[numVertices];
        this.melhorCiclo = new int[numVertices];
        this.explorado = new int[numVertices];
    }
    
    public void executar() {
        int i, j;
        
        Date horaInicio = new Date();
        long horaInicioLong = horaInicio.getTime();
        
        for(i = 0; i < numVertices; i++)
            explorado[i] = 0;
        
        nivel = 0;    /* inicializa nivel */
        min = 1000000;/* inicializa min */
        
        dfs(0,0);
        
        // Resultado
        System.out.println("Melhor ciclo obtido para " + Integer.toString(numVertices) + " vértices:");
        for(i=0;i<numVertices;i++) {
            if(i>0)
                System.out.print("-");
            System.out.print(Integer.toString(melhorCiclo[i]));
        }
        
        // Mostra o tempo de execução
        Date horaFinal = new Date();
        long horaFinalLong = horaFinal.getTime();
        long tempoExecucaoMili = (horaFinalLong-horaInicioLong);
        Double tempoExecucaoSeg = tempoExecucaoMili/1000.0;

        System.out.println("\nTempo de execução: " + Double.toString(tempoExecucaoSeg) + " segundos (" + tempoExecucaoMili + " milisegundos)\n");
    }
    
    private int medeCiclo(int[] t) {
        int i;
        int l=0;
        
        for(i=0;i<numVertices-1;i++)
            l=l+matrizAdjacencia[t[i]][t[i+1]];
        l=l+matrizAdjacencia[t[numVertices-1]][t[0]];
        
        return l;
    }
    
    /*  Esta funcao implementa o algoritmo DFS modificado para
    poder percorrer todos os caminhos possiveis. Apos o retorno, o vertice
    eh desmarcado como explorado, permitindo que ele seja explorado novamente */
    private void dfs(int v, int nivel) {
        int i,j,dist;
        explorado[v]=1;
        ciclo[nivel]=v;
        
        if(nivel==(numVertices-1)){
            /* completou um ciclo */
            dist = medeCiclo(ciclo);
            if(dist<min){
                min=dist;
                for(j=0;j<numVertices;j++)
                    melhorCiclo[j]=ciclo[j];
            }
        }
        for(i=0;i<numVertices;i++){
            if(explorado[i]!=1){
                dfs(i,nivel+1);
                explorado[i]=0;
            }
        }
    }
}
