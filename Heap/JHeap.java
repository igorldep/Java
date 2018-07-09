package Pratica04;
//Pega um vetor qualquer, constroi-se um heap e conta o numero de comparacoes realizadas
public class JHeap{
  public Item v[];
  private int  n;
  public int NumeroComp;
  public JHeap (int maxTam) { 
    this.v = new Item[maxTam + 1]; this.n = 0;this.NumeroComp++;
  }
  public JHeap (Item v[]) { 
    this.v = v; this.n = this.v.length - 1;
  }
  //Heap e construido visando sempre tornar o pai maior que os filhos
  public void refaz (int esq, int dir) {
    int j = esq * 2; Item x = this.v[esq];
    while (j <= dir) {
      if ((j < dir) && (this.v[j].compara (this.v[j + 1]) < 0)) j++;
      if (x.compara (this.v[j]) >= 0) break;
      this.v[esq] = this.v[j];
      esq = j; j = esq * 2;
      this.NumeroComp++;
    }
    this.v[esq] = x;
  }
  //aqui e um metodo no qual define a esquerda e chama o metodo refaz;
  public void constroi () {
    int esq = n / 2 + 1;
    while (esq > 1) {
      esq--; this.refaz (esq, this.n);
      this.NumeroComp++;
    }
  }
  public Item max () { return this.v[1]; }
  public Item retiraMax () throws Exception {
    Item maximo;
    if (this.n < 1) throw new Exception ("Erro: Heap Vazio");
    else {
      maximo = this.v[1]; this.v[1] = this.v[this.n--];
      refaz (1, this.n);
    }
    return maximo;
  }

}
