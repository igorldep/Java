package tp01;

public class Main {

    public static String Binarify(int a) {
        String aux = Integer.toBinaryString(a);
        int tamanho = aux.length();
        for (int i = tamanho; i < 8; i++) {
            aux = "0" + aux;
        }
        return aux;
    }

    public static String generateBinary(String s) {
        String binary = new String();
        String zeros = new String();
        int i;
        if (s.length() < 16) {
            for (i = s.length(); i < 16; i++) {
                zeros +=  "00000000";
            }
        }    
        for (i = 0; i < s.length(); i++) {
            int character = (int) s.charAt(i);
            binary = binary + Binarify(character);
        }
        binary = binary + zeros;
        return binary;
    }
    

    public static void main(String[] args) throws Exception {
        
        String texto[] = {"exemplo01.txt", "exemplo02.txt"}; 
        
        // Criacao do Patricia para o texto 1
        ExtraiPalavras EP = new ExtraiPalavras("delim.txt", texto[0]);
        ArvorePatricia ap = new ArvorePatricia(128);
        String s = EP.proximaPalavra();
        while(s!=null){
            if(s!=""){
                ap.insere(generateBinary(s), EP.linha, EP.coluna);                
            }
            s = EP.proximaPalavra();
        }
        // Pesquisa de palavras do texto 1
        System.out.println("PESQUISA DE PALAVRAS NO TEXTO 1\n");
        ap.pesquisa(generateBinary("trabalho"));
        ap.pesquisa(generateBinary("computacao"));
        ap.pesquisa(generateBinary("governo"));
        ap.pesquisa(generateBinary("educacao"));
        ap.pesquisa(generateBinary("tecnologia"));
        ap.pesquisa(generateBinary("formacao"));
        ap.pesquisa(generateBinary("desenvolvimento"));
        ap.pesquisa(generateBinary("que"));
        ap.pesquisa(generateBinary("informatica"));
        ap.pesquisa(generateBinary("em"));
        ap.pesquisa(generateBinary("crise"));
        
        EP.fecharArquivos(); 
        
        // Criacao do Patricia para o texto 2
        EP = new ExtraiPalavras("delim.txt", texto[1]);
        ap = new ArvorePatricia(128);
        s = EP.proximaPalavra();
        while(s!=null){
            if(s != ""){
                ap.insere(generateBinary(s), EP.linha, EP.coluna);                
            }
            s = EP.proximaPalavra();
        }
        // Pesquisa de palavras do texto 2
        System.out.println("\n\nPESQUISA DE PALAVRAS NO TEXTO 2\n");
        ap.pesquisa(generateBinary("sociedade"));
        ap.pesquisa(generateBinary("software"));
        ap.pesquisa(generateBinary("ideia"));
        ap.pesquisa(generateBinary("pessoa"));
        ap.pesquisa(generateBinary("informatica"));
        ap.pesquisa(generateBinary("etica"));
        ap.pesquisa(generateBinary("muito"));
        ap.pesquisa(generateBinary("ciencia"));
        ap.pesquisa(generateBinary("computacao"));
        ap.pesquisa(generateBinary("que"));
        ap.pesquisa(generateBinary("area"));
        ap.pesquisa(generateBinary("Moral"));

        EP.fecharArquivos(); 
    }
}