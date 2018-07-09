package tp01;

import java.io.*;
import java.util.ArrayList;

public class ExtraiPalavras {
    
    public class StringTokenizer {
        
        public class Tokem{
            int inicio, fim;

            public Tokem(int inicio, int fim) {
                this.inicio = inicio;
                this.fim = fim;
            }
        }
        
        public StringTokenizer(String linha_atual, String delimitadores) {
            this.linha_atual = linha_atual;
            this.delimitadores = delimitadores;
            this.coluna = 1;
            this.hasMoreTokens = false;
            this.numTokens = 0;
            this.tokenAtual = 0;
            this.tokens = new ArrayList<>();
            
            int i = 0;
            while(i<linha_atual.length()){
                boolean foundWord = false;
                String word = new String(); 
                
                boolean foundCharacter = verify(linha_atual.charAt(i), delimitadores);      
                if(foundCharacter){
                    foundWord = true;
                }
                int j = i;
                while(foundCharacter && j<linha_atual.length()){
                    foundCharacter = verify(linha_atual.charAt(j), delimitadores);
                    if(foundCharacter){
                        word = word + linha_atual.charAt(j);
                    }
                    j++;
                }
                if(foundWord){
                    this.hasMoreTokens = true;
                    this.numTokens++;
                    this.tokens.add(new Tokem(i, i + word.length() - 1 ));
                    i+=word.length();
                }
                else{
                    i++;
                }
            }
        }
        
        public ArrayList tokens;
        public String linha_atual, delimitadores;
        public int coluna, numTokens, tokenAtual;
        public boolean hasMoreTokens;

        public boolean verify(char c ,String delimitadores){
            boolean foundCharacter = true;
            for(char delim : delimitadores.toCharArray()){
                    if(c == delim){
                        foundCharacter = false;
                        break;
                    }
            }
            return foundCharacter;
        }

        
        
        public String nextToken(){
            int inicio = ((Tokem)this.tokens.get(this.tokenAtual)).inicio;
            int fim = ((Tokem)this.tokens.get(this.tokenAtual)).fim ;
            int i = inicio;
            String word = new String();
            while(i<=fim){
                word = word + linha_atual.charAt(i);   
                i++;
            }
            this.coluna = inicio + 1; 
            this.tokenAtual++;
            if(this.tokenAtual == this.numTokens){
                this.hasMoreTokens = false;
            }
            return word;
        }
        
    }
    
    public int linha, coluna;
    private BufferedReader arqDelim, arqTxt;
    private StringTokenizer palavras;
    private String delimitadores;

    public ExtraiPalavras(String nomeArqDelim, String nomeArqTxt) throws Exception {
        this.arqDelim = new BufferedReader(new FileReader(nomeArqDelim));
        this.arqTxt = new BufferedReader(new FileReader(nomeArqTxt));
        this.delimitadores = arqDelim.readLine() + "\r\n";
        this.palavras = null;
        this.linha = 0;
        this.coluna = 0;
    }

    public String proximaPalavra() throws Exception {
        if (palavras == null || !palavras.hasMoreTokens) {
            String linha = arqTxt.readLine();
            if (linha == null) {
                return null;
            }
            this.linha++;
            this.palavras = new StringTokenizer(linha, this.delimitadores);
            if (!palavras.hasMoreTokens) {
                return ""; 
            }
        }
        
        String word =  this.palavras.nextToken();
        this.coluna = palavras.coluna;
        return word;
    }

    public void fecharArquivos() throws Exception {
        this.arqDelim.close();
        this.arqTxt.close();
    }
}
