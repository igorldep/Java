package tp3;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n================ PARTE 1 ================\n");
        
        int n = 14;
        ConstruirGrafo grafo = new ConstruirGrafo();
        for (int i = 2; i <= n; i++) {
            System.out.println("Tamanho = " + i);
            CaixeiroViajante cv = new CaixeiroViajante(grafo.gerarGrafo(i));
            cv.executar();
        }
        
        System.out.println("\n================ PARTE 2 ================\n");
        
        ConstruirGrafo grafo1 = new ConstruirGrafo("pa561.tsp");
        ConstruirGrafo grafo2 = new ConstruirGrafo("si535.tsp");
        ConstruirGrafo grafo3 = new ConstruirGrafo("si1032.tsp");
        
        TSPNearestNeighbour tsp = new TSPNearestNeighbour();
        System.out.println("\npa561.tsp:");
        tsp.tsp(grafo1.getMatriz());
        System.out.println("\n\nsi535.tsp:");
        tsp.tsp(grafo2.getMatriz());
        System.out.println("\n\nsi1032.tsp:");
        tsp.tsp(grafo3.getMatriz());
    }
}