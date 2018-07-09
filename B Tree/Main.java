
package Pratica03;

// Computa as comparações e o tempo gasto do método pesquisa para a arvore SBB e as arvores B de ordem 2,4 e 6 respetivamente. 
public class Main {
    public static void main(String args[]){
        long tempoInicio,tempoFinal;
        ArvoreSBB NovaArvoreSBB = null;
        ArvoreB NovaArvoreB;
    
        
        int[] vetor1={10000,20000,30000,40000,50000,60000,70000,80000,90000,100000};
        Item x;
        System.out.println("ARVORE SBB \n\n");
        for(int i=0;i<10;i++){
            NovaArvoreSBB = new ArvoreSBB();
            for(int j=0;j<vetor1[i];j++){
                x= new Item(j+1);
                NovaArvoreSBB.insere(x);
            }
            System.out.println("Tamanho:"+vetor1[i]);
            x = new Item(100001); 
            tempoInicio = System.nanoTime();
            NovaArvoreSBB.pesquisa(x);
            tempoFinal= System.nanoTime();
            System.out.println("Tempo:"+(tempoFinal-tempoInicio));
        }
        System.out.println("ARVORE B 2 \n\n");
        for(int i=0;i<10;i++){
            NovaArvoreB = new ArvoreB (2);
            for(int j=0;j<vetor1[i];j++){
                x= new Item(j+1);
                NovaArvoreB.insere(x);
            }
            System.out.println("Tamanho:"+vetor1[i]);
            x = new Item(100001); 
            tempoInicio = System.nanoTime();
            NovaArvoreB.pesquisa(x);
            tempoFinal= System.nanoTime();
            System.out.println("Tempo:"+(tempoFinal-tempoInicio));
        }
        System.out.println("ARVORE B 4 \n\n");
                
        for(int i=0;i<10;i++){
            NovaArvoreB = new ArvoreB (4);
            for(int j=0;j<vetor1[i];j++){
                x= new Item(j+1);
                NovaArvoreB.insere(x);
            }
            System.out.println("Tamanho:"+vetor1[i]);
            x = new Item(100001); 
            tempoInicio = System.nanoTime();
            NovaArvoreB.pesquisa(x);
            tempoFinal= System.nanoTime();
            System.out.println("Tempo:"+(tempoFinal-tempoInicio));
        }        
                
        System.out.println("ARVORE B 6 \n\n");
        for(int i=0;i<10;i++){
            NovaArvoreB = new ArvoreB (6);
            for(int j=0;j<vetor1[i];j++){
                x= new Item(j+1);
                NovaArvoreB.insere(x);
            }
            System.out.println("Tamanho:"+vetor1[i]);
            x = new Item(100001); 
            tempoInicio = System.nanoTime();
            NovaArvoreB.pesquisa(x);
            tempoFinal= System.nanoTime();
            System.out.println("Tempo:"+(tempoFinal-tempoInicio));
        }        
                
                
    }
}
