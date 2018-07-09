package tp02;

public class LM {
    private final int A1[], A2[], T1[], T2[];
    
    //Construtor
    public LM(int A1[], int A2[], int T1[], int T2[]){
        this.A1 = A1;
        this.A2 = A2;
        this.T1 = T1;
        this.T2 = T2;
    }
    
    public void Guloso(){
        int [] estacao;
        estacao = new int [A1.length-2];
        int tempo = 0, i;
        
        if(A1[0] < A2[0]){
                tempo += A1[0] + A1[1];
                estacao[0] = 1;
                //System.out.println("Comeca de A1");
            }else{
                tempo += A2[0] + A2[1];
                estacao[0] = 2;
                //System.out.println("Comeca de A2");
            }
        for(i=2; i<A1.length-1;i++){
            if(estacao[i-2] == 1){
                if(A1[i] <= (T1[i-2] + A2[i])){
                    tempo += A1[i];
                    estacao[i-1] = 1;
                    //System.out.println("Estacao "+ estacao[i-1] + "\tTempo = "+ A1[i] +"\tTempo total = "+ tempo);
                }else{
                    tempo += T1[i-2] + A2[i];
                    estacao[i-1] = 2;
                    //System.out.println("Estacao "+ estacao[i-1] + "\tTempo = "+ (T1[i-2] + A2[i]) +"\tTempo total = "+ tempo);
                }
            }else{
                if(A2[i] <= (T2[i-2] + A1[i])){
                    tempo += A2[i];
                    estacao[i-1] = 2;
                    //System.out.println("Estacao "+ estacao[i-1] + "\tTempo = "+ A2[i] +"\tTempo total = "+ tempo);
                }else{
                    tempo += T2[i-2] + A1[i];
                    estacao[i-1] = 1;
                    //System.out.println("Estacao "+ estacao[i-1] + "\tTempo = "+ (T2[i-2] + A1[i]) +"\tTempo total = "+ tempo);
                }
            }
        }
        // Soma do ultimo tempo
        if(estacao[estacao.length-2] == 1){
            tempo += A1[A1.length-1];
            //System.out.println("Estacao "+ estacao[estacao.length-1] + "\tTempo = "+ A1[A1.length-1] +"\tTempo total = "+ tempo);
        }else{
            tempo += A2[A2.length-1];
            //System.out.println("Estacao "+ estacao[estacao.length-1] + "\tTempo = "+ A2[A2.length-1] +"\tTempo total = "+ tempo);
        }
        System.out.println("ALGORITMO GULOSO:");
        for(i=0; i< estacao.length;i++){
            System.out.print("-> " + estacao[i] +" ");
        }
        System.out.println("\nTEMPO TOTAL GASTO: "+ tempo);
        System.out.println("");
    }
    
    public void ProgDinamica(){
        int [] F1;
        int [] F2;
        int [] L1;
        int [] L2;
        int tempo_final, linha_final, i, n;
        n = A1.length-2; // numero de estacoes em cada linha de montagem
        F1 = new int[n];
        F2 = new int[n];
        L1 = new int[n-1];
        L2 = new int[n-1];
        
        F1[0] = A1[0] + A1[1];
        F2[0] = A2[0] + A2[1];
        
        for(i=1;i<F1.length;i++){
            if((F1[i-1] + A1[i+1]) <= (F2[i-1] + T2[i-1] + A1[i+1])){
                F1[i] = F1[i-1] + A1[i+1];
                L1[i-1] = 1;
            }else{
                F1[i] = F2[i-1] + T2[i-1] + A1[i+1];
                L1[i-1] = 2;
            }
            if((F2[i-1] + A2[i+1]) <= (F1[i-1] + T1[i-1] + A2[i+1])){
                F2[i] = F2[i-1] + A2[i+1];
                L2[i-1] = 2;
            }else{
                F2[i] = F1[i-1] + T1[i-1] + A2[i+1];
                L2[i-1] = 1;
            }
        }
        
        if((F1[n-1] + A1[n+1]) <= (F2[n-1] + A2[n+1])){
            tempo_final = F1[n-1] + A1[n+1];
            linha_final = 1;
        }else{
            tempo_final = F2[n-1] + A2[n+1];
            linha_final = 2;
        }
        
        //Imprimir solucao da Programacao Dinamica
        System.out.println("PROGRAMACAO DINAMICA:");
//PARA IMPRIMIR OS VETORES USADOS NESSE METODO, TIRE OS COMENTARIOS ABAIXO
//        System.out.print("F1:");
//        for(i=0;i<n;i++){
//            System.out.print(" - "+ F1[i]);
//        }
//        System.out.print("\nF2:");
//        for(i=0;i<n;i++){
//            System.out.print(" - "+ F2[i]);
//        }
//        System.out.print("\nL1:");
//        for(i=0;i<n-1;i++){
//            System.out.print(" - "+ L1[i]);
//        }
//        System.out.print("\nL2:");
//        for(i=0;i<n-1;i++){
//            System.out.print(" - "+ L2[i]);
//        }
//        System.out.println("");
        System.out.println("Estacao "+ n +"\tLinha "+ linha_final);
        i = linha_final;
        for(int j=n-2; j>=0; j--){
            if(i == 1){
                i = L1[j];
            }else{
                i = L2[j];
            }
            System.out.println("Estacao "+ (j+1) +"\tLinha "+ i);
        }
        System.out.println("TEMPO TOTAL GASTO: "+ tempo_final);
        System.out.println("\n");
    }
    
    // Apenas imprime os vetores das linhas de montagem e transferencia
    public void imprimir(){
        System.out.print("A1 = ");
        for(int i=0;i<A1.length; i++){ System.out.print(A1[i] + ", "); }
        System.out.print("\nA2 = ");
        for(int i=0;i<A2.length; i++){ System.out.print(A2[i] + ", "); }
        System.out.print("\nT1 = ");
        for(int i=0;i<T1.length; i++){ System.out.print(T1[i] + ", "); }
        System.out.print("\nT2 = ");
        for(int i=0;i<T2.length; i++){ System.out.print(T2[i] + ", "); }
        
    }
}
