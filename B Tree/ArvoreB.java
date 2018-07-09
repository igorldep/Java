
package Pratica03;

public class ArvoreB {
    // Página: insere item
    private static class Pagina {
    int n; 
    Item r[]; 
    Pagina p[];
    
    public Pagina (int mm) {
      this.n = 0; 
      this.r = new Item[mm];
      this.p = new Pagina[mm+1];
      
    }
  }
    private Pagina raiz;
    private int m, mm;
    private int numerocomp;



public ArvoreB (int m) {
    this.raiz = null;
    this.m = m; this.mm = 2*m;
    this.numerocomp=0;
  }
  
  public Item pesquisa (Item reg) {
    return this.pesquisa(reg, this.raiz);
  }

  //Verifica crescimento na raiz
  public void insere (Item reg) {
    Item regRetorno[] = new Item[1];
    boolean cresceu[] = new boolean[1];
    Pagina apRetorno = this.insere (reg, this.raiz, regRetorno, cresceu);
    if (cresceu[0]) {
      Pagina apTemp = new Pagina(this.mm);
      apTemp.r[0] = regRetorno[0];
      apTemp.p[0] = this.raiz;
      apTemp.p[1] = apRetorno;
      this.raiz = apTemp; this.raiz.n++;
    } else this.raiz = apRetorno;
  }




//Desloca os elemtnos r e p para a direta até que a posicão correta seja encontrada.
private void insereNaPagina (Pagina ap, Item reg, Pagina apDir) {
    int k = ap.n - 1;
    while ((k >= 0) && (reg.compara (ap.r[k]) < 0)) {
      ap.r[k+1] = ap.r[k]; ap.p[k+2] = ap.p[k+1]; k--; 
    }
    ap.r[k+1] = reg; ap.p[k+2] = apDir; ap.n++;     
  }

//Este método insere um novo registro
  private Pagina insere (Item reg, Pagina ap, Item[] regRetorno, 
                         boolean[] cresceu) {
    Pagina apRetorno = null;
    
    //A pagina onde deve inserir o item enviado como parametro caso ap seja nulo
    if (ap == null) { cresceu[0] = true; regRetorno[0] = reg; } 
    else {
      int i = 0;
    //Busca chave maior ou igual que a chave a ser inserida na pagina
      while ((i < ap.n-1) && (reg.compara (ap.r[i]) > 0)) i++;      
      if (reg.compara (ap.r[i]) == 0) {
        System.out.println ("Erro: Registro ja existente");
        cresceu[0] = false;
      } 
      else {
        //Página: esquerda ou direita
        if (reg.compara (ap.r[i]) > 0) i++;
        apRetorno = insere (reg, ap.p[i], regRetorno, cresceu);
        if (cresceu[0]) 
            
         //regRetorno[0] = Item enviado como parametro após a chamada recursiva.
          if (ap.n < this.mm) { 
            this.insereNaPagina (ap, regRetorno[0], apRetorno);
            cresceu[0] = false; apRetorno = ap;
          } 
          else { 
              //Cria uma nova pagina
            Pagina apTemp = new Pagina (this.mm); apTemp.p[0] = null;
           //verifica se o item deve ficar na pagina atual ou na nova
            if (i <= this.m) {
              this.insereNaPagina (apTemp, ap.r[this.mm-1], ap.p[this.mm]);
              ap.n--;
              this.insereNaPagina (ap, regRetorno[0], apRetorno);
            //muda os itens da metade direita para nova pagina
            } else this.insereNaPagina (apTemp, regRetorno[0], apRetorno);
            for (int j = this.m+1; j < this.mm; j++) {
              this.insereNaPagina (apTemp, ap.r[j], ap.p[j+1]);
              ap.p[j+1] = null;
            }
            ap.n = this.m; apTemp.p[0] = ap.p[this.m+1]; 
            //Atribui o Item do meio a regRetorno e atribui o objeto apTempo a apRetorno
            regRetorno[0] = ap.r[this.m]; apRetorno = apTemp;
          }
      }        
    }
    return (cresceu[0] ? apRetorno : ap);
  }
 //Pesquisa na árvore de forma recursiva 
    private Item pesquisa (Item reg, Pagina ap) {
    if (ap == null){
        System.out.println("num comp: "+numerocomp);
        return null;
    } 
    else {
      int i = 0;
      while ((i < ap.n-1) && (reg.compara (ap.r[i]) > 0)) i++;
      if (reg.compara (ap.r[i]) == 0){
          this.numerocomp++;
          return ap.r[i];
      }
      else if (reg.compara (ap.r[i]) < 0){
          this.numerocomp++;
          return pesquisa (reg, ap.p[i]);
      }
      else{
          this.numerocomp++;
          return pesquisa (reg, ap.p[i+1]);
      }
    }
  }
  
}

