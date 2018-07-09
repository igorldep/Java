package tp02;

public class Main {
    public static void main(String[] args) {
        //TESTE 1
        int A1[] = {3,5,7,10,5,9,11,9,5,2,6};
        int A2[] = {2,6,3,9,11,4,9,3,12,4,5};
        int T1[] = {3,5,4,2,7,5,8,1};
        int T2[] = {5,3,7,5,6,2,5,2};
        
        LM Teste1 = new LM(A1,A2,T1,T2);
        System.out.println("TESTE 1:");
        //Teste1.imprimir();
        Teste1.Guloso();
        Teste1.ProgDinamica();
        
        //TESTE 2
        int B1[] = {5,10,6,3,8,5,3,7,12,8};
        int B2[] = {7, 3,5,3,7,6,4,9,10,9};
        int U1[] = {4,2,7,2,5,8,2};
        int U2[] = {6,1,7,3,6,4,5};
        
        LM Teste2 = new LM(B1,B2,U1,U2);
        System.out.println("TESTE 2:");
        //Teste2.imprimir();
        Teste2.Guloso();
        Teste2.ProgDinamica();
        
        //TESTE 3 - O MESMO DO SLIDE PASSADO PELO PROFESSOR
//        int C1[] = {2,7,9,3,4,8,4,3};
//        int C2[] = {4,8,5,6,4,5,7,2};
//        int V1[] = {2,3,1,3,4};
//        int V2[] = {2,1,2,2,1};
//
//        LM Teste3 = new LM(C1,C2,V1,V2);
//        System.out.println("TESTE 3:");
//        //Teste3.imprimir();
//        Teste3.Guloso();
//        Teste3.ProgDinamica();
    }
    
}