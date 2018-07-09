
package Pratica04;
//Ordena um vetor utilizando o heap de N vezes
public class JHeapSort {
        
    
    public void heapSort (Item v[], int n) {
    JHeap fpHeap = new JHeap (v);
    int dir = n;
    fpHeap.constroi (); 
    while (dir > 1) { 
      Item x = v[1]; 
      v[1] = v[dir];
      v[dir] = x;
      dir--; 
      fpHeap.refaz (1, dir);
      
    }
    System.out.println("Tamanho: "+n+"\nN. Comp: "+fpHeap.NumeroComp);
  }
}
