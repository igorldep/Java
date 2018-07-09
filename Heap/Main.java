
package Pratica04;

//Cria um vetor do tipo Item e um vetor com todos n valores a serem testados de forma crescente, decrescente e aleatorio
public class Main {
    public static void main(String args[]){
     JHeapSort HS;
     int[] vetor1={10000,20000,30000,40000,50000,60000,70000,80000,90000,100000}; 
     int[] vetor2;
     Item[] x;
     int i,j;
     
     System.out.println("Vetor Ordem Crescente:\n");
     for(i=0;i<10;i++){
         HS= new JHeapSort();
         x = new Item[vetor1[i]+1];
         x[0] = new Item(0);
         for(j=1;j<=vetor1[i];j++){
             x[j] = new Item(j);
         }
         HS.heapSort(x,vetor1[i]);
     }
     
     
     System.out.println("\n\nVetor Ordem Decrecente:\n");
     for(i=0;i<10;i++){
         HS= new JHeapSort();
         x = new Item[vetor1[i]+1];
         x[0] = new Item(0);
         for(j=0;j<=vetor1[i];j++){
             x[j] = new Item(vetor1[i]-j);
         }
         HS.heapSort(x,vetor1[i]);
     }
     

     
          System.out.println("\n\nVetor Ordem Aleatoria:\n");
        for(i=0;i<10;i++){
            HS= new JHeapSort();
            vetor2= new int[vetor1[i]];
         
         for(j=0;j<vetor1[i];j++){
             vetor2[j]=j+1;
         }
         PermutacaoRandomica.permut (vetor2, vetor1[i]);
         x = new Item[vetor1[i]+1];
         x[0] = new Item(0);
         for(j=1;j<=vetor1[i];j++){
            x[j]= new Item(vetor2[j-1]);
         }
         HS.heapSort(x,vetor1[i]);
     }

    }
}
