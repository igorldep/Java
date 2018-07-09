/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica1;

/**
 *
 * @author Igor Luciano de Paula
 */

public class ArvoreBinaria {
    int cont = 0;
    private static class No {
        Item reg;
        No esq, dir;
    }
    
    private No raiz;
    
    //Construtor: Inicialização
    public ArvoreBinaria(){
        this.raiz = null;
    }
    
    public Item pesquisa(Item reg){ // PQ REG E THIS.RAIZ? DEVERIA TER 1 SÓ: REG
        return this.pesquisa (reg, this.raiz);
    }
   
    public void insere (Item reg){
        this.raiz = this.insere(reg, this.raiz);
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
    }
}



