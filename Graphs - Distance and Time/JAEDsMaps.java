
package Pratica07;

public class JAEDsMaps {
  
  private int tempo_total=0,peso_total=0;
  private int origem, destino;
  private int antecessor[];
  private double p[];
  private JGrafo grafo;
  
  public void mudarEstado(){
      grafo.trocaTempoDistancia();
  }
  public JAEDsMaps(JGrafo grafo, int origem, int destino) {
        this.grafo = grafo;
        this.origem = origem;
        this.destino = destino;
    }
  public void obterArvoreCMC (int raiz) throws Exception {
    tempo_total=0;
    peso_total=0;
    int n = this.grafo.numVertices();
    this.p = new double[n]; 
    int vs[] = new int[n+1]; 
    this.antecessor = new int[n];
    for (int u = 0; u < n; u ++) {
      this.antecessor[u] = -1;
      p[u] = Double.MAX_VALUE; 
      vs[u+1] = u; 
    }
    p[raiz] = 0;
    FPHeapMinIndireto heap = new FPHeapMinIndireto (p, vs); 
    heap.constroi ();
    while (!heap.vazio ()) {
      int u = heap.retiraMin (); 
      if (!this.grafo.listaAdjVazia (u)) {
        JGrafo.Aresta adj = grafo.primeiroListaAdj (u);
        while (adj != null) {
          int v = adj.v2 ();
          if (this.p[v] > (this.p[u] + adj.peso ())) {
            antecessor[v] = u; 
            heap.diminuiChave (v, this.p[u] + adj.peso ());
          }
          adj = grafo.proxAdj (u);
        }
      }
    }
  }
  // acha a Arvore menor tempo
  public int antecessor (int u) { return this.antecessor[u]; }
  public double peso (int u) { return this.p[u]; }
  public void imprime () {
    for (int u = 0; u < this.p.length; u++)
      if (this.antecessor[u] != -1) 
        System.out.println ("(" +antecessor[u]+ "," +u+ ") -- p:" +peso (u));

  }
  public void imprimeCaminho(int origem, int v) { 
        if (origem == v) {
        } else if (this.antecessor[v] == -1) {
            System.out.println("Nao existe caminho de " + origem + " ate " + v);
        } else {
            imprimeCaminho(origem, this.antecessor[v]);

            System.out.println("(" +  this.antecessor[v] + "," + v + ") distancia:" + grafo.getDistancia(this.antecessor[v], v) + "  tempo:" + grafo.getTempo(this.antecessor[v], v));
            tempo_total+=grafo.getTempo(this.antecessor[v], v);
            peso_total+=grafo.getDistancia(this.antecessor[v], v);
        }
        
    }
  public void imprimeTotal(){
     System.out.println("Peso Total:" + peso_total + "  Tempo total: " + tempo_total+"\n"); 
  }
}
