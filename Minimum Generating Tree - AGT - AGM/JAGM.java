
package Pratica06;

public class JAGM {
  private int antecessor[];
  private double p[];
  private JGrafo grafo;

  public JAGM (JGrafo grafo) { this.grafo = grafo; }  
  
  public void obterAgm (int raiz) throws Exception { 
    int n = this.grafo.numVertices();
    this.p = new double[n]; 
    int vs[] = new int[n+1]; 
    boolean itensHeap[] = new boolean[n]; this.antecessor = new int[n];
    for (int u = 0; u < n; u ++) {
      this.antecessor[u] = -1;
      p[u] = Double.MAX_VALUE; 
      vs[u+1] = u; 
      itensHeap[u] = true;
    }
    p[raiz] = 0;
    
    FPHeapMinIndireto heap = new FPHeapMinIndireto (p, vs);
    
    heap.constroi ();
    while (!heap.vazio ()) {
      int u = heap.retiraMin (); itensHeap[u] = false;
      if (!this.grafo.listaAdjVazia (u)) {
        JGrafo.Aresta adj = grafo.primeiroListaAdj (u);
        while (adj != null) {
          int v = adj.v2 ();
          if (itensHeap[v] && (adj.peso () < this.peso (v))) {
            antecessor[v] = u; heap.diminuiChave (v, adj.peso ());
          }
          adj = grafo.proxAdj (u);
        }
      }
    }
  }
  public int antecessor (int u) { return this.antecessor[u]; }
  
  public double peso (int u) { return this.p[u]; }
  
  public void imprime () {
   
   double auxPeso =0;

    for (int u = 0; u < this.p.length; u++){
      if (this.antecessor[u] != -1) {
        auxPeso += peso(u);
        System.out.println ("(" +antecessor[u]+ "," +u+ ") -- p:" + peso (u));
      }
       
    }
      System.out.println("peso total:" + auxPeso);
  }
}
