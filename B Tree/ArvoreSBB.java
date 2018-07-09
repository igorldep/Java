
package Pratica03;
//ArvoreSBB: possui raiz e os métodos pesquisa, insere e imprime.
public class ArvoreSBB {
    //Celula: possui uma variável do tipo Item, onde se armazena os registros e apontadores do tipo No para montar a árvore
    private static class No {
        Item reg;
        No esq, dir;
        byte incE, incD;
    }
    private static final byte Horizontal = 0;
    private static final byte Vertical = 1;
    private No raiz;
    private boolean propSBB;
    private int numerocomp;

public ArvoreSBB(){
    this.raiz=null;
    this.propSBB=true;
    this.numerocomp=0;
}
public void insere(Item reg){
    this.raiz = insere(reg,null,this.raiz,true);
}
public Item pesquisa (Item reg) {
    return this.pesquisa (reg, this.raiz);
  }
public void imprime () {
    this.pre_order (this.raiz);
  }
//Este método imprime de forma recursiva e em ordem as chaves registradas nos Nos
private void pre_order (No p) {
    if (p != null) {
      System.out.println("No:" + p.reg.toString());
      pre_order (p.esq);
      pre_order (p.dir);
    }
  }
// Este método recebe como parametro um tipo Item, para verificar de forma recursiva se tal Item existe na raiz e conta o número de comparações feitas no método pesquisa.
private Item pesquisa (Item reg, No p) {
    if (p == null){
        System.out.println("Comparações: "+numerocomp);
        return null;
    } 
    else if (reg.compara (p.reg) < 0){
        this.numerocomp++;
        return pesquisa (reg, p.esq);
        
    }
    else if (reg.compara (p.reg) > 0){
        this.numerocomp++;
        return pesquisa (reg, p.dir);
        
    }
    else return p.reg;
}
// Este método insere um novo No(folha) a árvore.
private No insere (Item reg, No pai, No filho, boolean filhoEsq) {
    // um No e inserido na vertical, quando a altura aumenta para 1 trasnforma em uma ligacao horizontal.
    if (filho == null) {
      filho = new No (); filho.reg = reg; 
      filho.incE = Vertical; filho.incD = Vertical;
      filho.esq = null; filho.dir = null;
      if (pai != null)
        if (filhoEsq) pai.incE = Horizontal; else pai.incD = Horizontal;
      this.propSBB = false;
    }
    //aqui verifica para a esquerda de forma recursiva se a transformacao seja realizadas se necessario.
    else if (reg.compara (filho.reg) < 0) {
      filho.esq = insere (reg, filho, filho.esq, true);
      if (!this.propSBB) 
        if (filho.incE == Horizontal) { 
          if (filho.esq.incE == Horizontal) {
            filho = this.ee (filho); 
            if (pai != null)
              if (filhoEsq) pai.incE=Horizontal; else pai.incD=Horizontal;
          }
          else if (filho.esq.incD == Horizontal) {
            filho = this.ed (filho); 
            if (pai != null) 
              if (filhoEsq) pai.incE=Horizontal; else pai.incD=Horizontal;            
          }
        }
        else this.propSBB = true;
    }
    //aqui verifica para a direita de forma recursiva se a transformacao seja realizadas se necessario.
    else if (reg.compara (filho.reg) > 0) {
      filho.dir = insere (reg, filho, filho.dir, false);
      if (!this.propSBB) 
        if (filho.incD == Horizontal) {
          if (filho.dir.incD == Horizontal) {
            filho = this.dd (filho); // @{\it trasforma\c{c}\~ao direita-direita}@
            if (pai != null)
              if (filhoEsq) pai.incE=Horizontal; else pai.incD=Horizontal;
          }
          else if (filho.dir.incE == Horizontal) {
            filho = this.de (filho); // @{\it trasforma\c{c}\~ao direita-esquerda}@
            if (pai != null)
              if (filhoEsq) pai.incE=Horizontal; else pai.incD=Horizontal;            
          }
        }
        else this.propSBB = true;
    }
    else {      
      System.out.println ("Erro: Registro ja existente"); 
      this.propSBB = true;
    }
    return filho; 
  }
//Realiza as movimentacõe   s necessarias das "subarvores" horizontais necessarias durate a insercão.
private No ee(No ap) {
    No ap1 = ap.esq;
    ap.esq = ap1.dir;
    ap1.dir = ap;
    ap1.incE = Vertical;
    ap.incE = Vertical;
    ap = ap1;
    
    return ap;
}
private No ed(No ap) {
    No ap1 = ap.esq;
    No ap2 = ap1.dir;
    ap1.incD = Vertical;
    ap.incE = Vertical;
    ap1.dir = ap2.esq;
    ap2.esq = ap1;
    ap.esq = ap2.dir;
    ap2.dir = ap;
    ap = ap2;
    
    return ap;
}
    private No dd(No ap) {
    No ap1 = ap.dir;
    ap.dir = ap1.esq;
    ap1.esq = ap;
    ap1.incD = Vertical;
    ap.incD = Vertical;
    ap = ap1;

    return ap;
}
private No de(No ap) {
    No ap1 = ap.dir;
    No ap2 = ap1.esq;
    ap1.incE = Vertical;
    ap.incD = Vertical;
    ap1.esq = ap2.dir;
    ap2.dir = ap1;
    ap.dir = ap2.esq;
    ap2.esq = ap;
    ap = ap2;
    
    return ap;
}   
     
}
