/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica2;

/**
 *
 * @author igor
 */
public class ArvoreSBB {
    
    int cont = 0;
    
    private static class No {
        Item reg;
        No esq, dir;
        byte incE, incD;
    }
    
    private static final byte Horizontal = 0;
    private static final byte Vertical = 1;
    private No raiz ; private boolean propSBB;
    
    //Construtor: Inicialização
    public ArvoreSBB(){
        this.raiz = null;
        this.propSBB = true;
    }
    
  /*  public void pre_order(No no){
        this.raiz = this.pre_order(no);
    }*/
    
    public Item pesquisa(Item reg){ // PQ REG E THIS.RAIZ? DEVERIA TER 1 SÓ: REG
        return this.pesquisa (reg, this.raiz);
    }
   
    public void insere (Item reg){
        this.raiz = this.insere(reg, null, this.raiz, true);
    }
    
    /*public void retira (Item reg){
        this.raiz = this.retira(reg, this.raiz);
    }*/
    
    private Item pesquisa (Item reg, No p){
        cont++; //conta antes de fazer cada comparação
        if (p == null){ //Não encotrado - folha
            System.out.print(cont + ", ");
            return null;
        }
        cont++;
        if (reg.compara(p.reg) < 0) return pesquisa (reg, p.esq);//se menor, busca na sub-árvore da esquerda
        cont++;
        if (reg.compara(p.reg) > 0) return pesquisa (reg, p.dir);//Se menor, busca na sub-árvore da direita
        
        return p.reg; //Encontrado
    }
    /* binária
    private No insere(Item reg, No p){
        if (p == null){ //Insere em uma folha
            p = new No(); p.reg = reg; //Instância novo nó
            p.esq = null; p.dir = null; //Filhos nulos
        }
        //pesquisa na sub-árvore devida, assim como na pesquisa, até null
        else if (reg.compara(p.reg) < 0)
            p.esq = insere(reg, p.esq);
        else if (reg.compara(p.reg) > 0)
            p.dir = insere(reg, p.dir);
        else System.out.println("Erro: Registro já existe"); //Senão, já existe

        return p;
    } */
    
    private No insere (Item reg , No pai , No filho , boolean filhoEsq ) {
        if ( filho == null ) {
            filho = new No ( ) ; filho .reg = reg;
            filho .incE = Vertical ; filho .incD = Vertical ;
            filho .esq = null ; filho . dir = null ;
            
            if ( pai != null)
                if ( filhoEsq ) pai .incE = Horizontal ; else pai .incD = Horizontal;
            
            this .propSBB = false;
        } 
        else if (reg.compara ( filho .reg) < 0) {
            filho .esq = insere (reg , filho , filho .esq, true);
            if ( ! this .propSBB)
                if ( filho .incE == Horizontal ) {
                    if ( filho .esq.incE == Horizontal ) {
                        filho = this .ee ( filho ) ; // transformação esquerda-esquerda
                        if ( pai != null)
                            if ( filhoEsq ) pai .incE=Horizontal ; else pai .incD=Horizontal;
                    }
                    else if ( filho .esq.incD == Horizontal ) {
                        filho = this .ed ( filho ) ; // transformação esquerda-direita
                        if ( pai != null)
                            if ( filhoEsq ) pai .incE=Horizontal;
                        else pai .incD=Horizontal;
                    }
                }
            else this .propSBB = true;
        }
        else if (reg.compara ( filho .reg) > 0) {
            filho . dir = insere (reg , filho , filho . dir , false );
            if ( ! this .propSBB)
                if ( filho .incD == Horizontal ) {
                    if ( filho . dir .incD == Horizontal ) {
                      filho = this .dd ( filho ) ; // transformação direita-direita
                        if ( pai != null)
                            if ( filhoEsq ) pai .incE=Horizontal ; else pai .incD=Horizontal;
                    }
                    else if ( filho . dir .incE == Horizontal ) {
                        filho = this .de ( filho ) ; // transformação direita-esquerda
                        if ( pai != null)
                            if ( filhoEsq ) pai .incE=Horizontal ; else pai .incD=Horizontal;
                    }
                }
                else this .propSBB = true;
        }
        else {
            //System.out. println ( "Erro : Registro ja existente" );
            this .propSBB = true;
        }

        return filho ;
    }
    
    private void pre_order(No no){
        if(no != null){
            System.out.print(no.reg + " ");
            pre_order(no.esq);
            pre_order(no.dir);
        }
    }
    
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
