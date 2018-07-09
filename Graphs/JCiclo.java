package Pratica05;

public class JCiclo {

    public static final byte branco = 0;
    public static final byte cinza = 1;
    public static final byte preto = 2;
    private int d[], t[], antecessor[];
    private JGrafo grafo;

    public JCiclo(JGrafo grafo) {
        this.grafo = grafo;
        int n = this.grafo.numVertices();
        d = new int[n];
        t = new int[n];
        antecessor = new int[n];
    }

    private int visitaDfs(int u, int tempo, int cor[],int tipo) {
        cor[u] = cinza;
        this.d[u] = ++tempo;
        if (!this.grafo.listaAdjVazia(u)) {
            JGrafo.Aresta a = this.grafo.primeiroListaAdj(u);
            while (a != null) {
                int v = a.v2();
                //tipo = 0 (Não Direcionado) || tipo = 1 (Direcionado) 
                if(tipo == 0){
                    if (cor[v] == cinza && this.d[u] - this.d[v] > 1 ) {
                        this.grafo.Ciclico = true;
                    }
                }
                else{
                    if (cor[v] == cinza ) {
                        this.grafo.Ciclico = true;
                    }  
                }
                
                if (cor[v] == branco) {
                    this.antecessor[v] = u;
                    tempo = this.visitaDfs(v, tempo, cor, tipo);
                }
                
                a = this.grafo.proxAdj(u);
            }
        }
        cor[u] = preto;
        this.t[u] = ++tempo;

        return tempo;
    }

    public void JCiclo(int i) {
        int tempo = 0;
        int cor[] = new int[this.grafo.numVertices()];
        for (int u = 0; u < grafo.numVertices(); u++) {
            cor[u] = branco;
            this.antecessor[u] = -1;
        }
        for (int u = 0; u < grafo.numVertices(); u++) {
            if (cor[u] == branco) {
                tempo = this.visitaDfs(u, tempo, cor, i);
            }
        }
    }

    public int d(int v) {
        return this.d[v];
    }

    public int t(int v) {
        return this.t[v];
    }

    public int antecessor(int v) {
        return this.antecessor[v];
    }
}