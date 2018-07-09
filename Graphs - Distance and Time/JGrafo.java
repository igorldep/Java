package Pratica07;

public class JGrafo {

    public static class Aresta {

        private int v1, v2, peso;
        
        //construtor
        public Aresta(int v1, int v2, int peso) {
            this.v1 = v1;
            this.v2 = v2;
            this.peso = peso;
        }
        //retorna peso
        public int peso() {
            return this.peso;
        }
        //retorna v1
        public int v1() {
            return this.v1;
        }
        //retorna v2
        public int v2() {
            return this.v2;
        }
    }
    private int tipo=0;
    private int mat[][];
    private int matD[][];  //matriz de distancia
    private int matT[][];  //matriz de tempo
    private int numVertices;
    private int pos[];
    
    public int getDistancia(int i,int j) {
            return this.matD[i][j];
    }
    
    public int getTempo(int i,int j) {
            return this.matT[i][j];
    }
    
    //construtor do Grafo
    public JGrafo(int numVertices) {
        this.matD = new int[numVertices][numVertices];
        this.matT = new int[numVertices][numVertices];
        this.mat= new int[numVertices][numVertices];
        this.pos = new int[numVertices];
        this.numVertices = numVertices;
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.matD[i][j] = 0;
                this.matT[i][j] = 0;
            }
            this.pos[i] = -1;
        }
    }
    
    //escolhe qual peso vai ser analizado
    public void trocaTempoDistancia() {
        tipo = -tipo;
        if (tipo == 1) {
            this.mat = matD;
        } else {
            this.mat = matT;
        }
    }
    
    //Insere a aresta em 3 matrizes que representa a padrão e a de distancia e a de tempo, é inicializado na de distancia
    public void insereAresta(int v1, int v2, int distancia, int tempo) {
        
        this.mat[v1][v2]= distancia;
        this.matD[v1][v2] = distancia;
        this.matT[v1][v2] = tempo;
    }

    public boolean existeAresta(int v1, int v2) {
        return (this.mat[v1][v2] > 0);
    }

    public boolean listaAdjVazia(int v) {
        for (int i = 0; i < this.numVertices; i++) {
            if (this.mat[v][i] > 0) {
                return false;
            }
        }
        return true;
    }

    public Aresta primeiroListaAdj(int v) {
        this.pos[v] = -1;
        return this.proxAdj(v);
    }

    public Aresta proxAdj(int v) {
        this.pos[v]++;
        while ((this.pos[v] < this.numVertices)
                && (this.mat[v][this.pos[v]] == 0)) {
            this.pos[v]++;
        }
        if (this.pos[v] == this.numVertices) {
            return null;
        } else {
            return new Aresta(v, this.pos[v], this.mat[v][this.pos[v]]);
        }
    }

    public Aresta retiraAresta(int v1, int v2) {
        if (this.mat[v1][v2] == 0) {
            return null;
        } else {
            Aresta aresta = new Aresta(v1, v2, this.mat[v1][v2]);
            this.mat[v1][v2] = 0;
            return aresta;
        }
    }

    public void imprime() {
        System.out.print("   ");
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(this.mat[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public int numVertices() {
        return this.numVertices;
    }

}
