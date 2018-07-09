package tp3;

import java.util.Random;
import lexical.Lexeme;
import lexical.TokenType;
import lexical.LexicalAnalysis;

public class ConstruirGrafo {
    private String arquivo;
    private int cidades;
    private int[][] matriz;
    private boolean obterDados;
    private boolean diagonalType;
    
    public ConstruirGrafo() {
        this.cidades = -1;
        this.matriz = new int[0][0];
        this.obterDados = false;
        this.diagonalType = false;
    }
    
    public ConstruirGrafo(String arquivo) {
        this.arquivo = arquivo;
        this.cidades = -1;
        this.matriz = new int[0][0];
        this.obterDados = false;
        this.diagonalType = false;
        
        carregar();
    }
    
    public int[][] getMatriz() {
        return this.matriz;
    }
    
    public void carregar() {
        int i = 0;
        int j = 0;
        int eLinha = 0;
        
        //System.out.println("Carregando Arquivo: " + arquivo);
        
        try (LexicalAnalysis l = new LexicalAnalysis(arquivo)) {
            Lexeme lex;
            while (checkType((lex = l.nextToken()).type)) {
                //System.out.printf("(\"%s\", %s)\n", lex.token, lex.type);

                if (lex.token.equals("UPPER_DIAG_ROW")) {
                    diagonalType = true;
                }

                // DIMENSION : "num", onde "num" é o número de cidades
                if (cidades == 0 && lex.type == TokenType.NUMBER) {
                    cidades = Integer.parseInt(lex.token); // Número de cidades
                    matriz = new int[cidades][cidades];

                    for (i = 0; i < cidades; i++) {
                        for (j = 0; j < cidades; j++) {
                            matriz[i][j] = 0; // Inicializa com zeros
                        }
                    }
                    i = 0;
                    j = 0;
                    System.out.println(arquivo + ": Numero de cidades = " + cidades);
                }

                // Se for encontrado o Token DIMENSION, então cidades == 0
                if (cidades == -1 && lex.token.equals("DIMENSION")) {
                    cidades = 0;
                }

                if (obterDados) { // A coleta dos dados é realizada após encontrar o Token: "EDGE_WEIGHT_SECTION"
                    if (lex.type == TokenType.NUMBER) {
                        int num = Integer.parseInt(lex.token);
                        //System.out.println("i "+ i + " j " + j);
                        matriz[i][j] = num;
                        matriz[j][i] = num;
                        eLinha++;
                        j++;

                        if (diagonalType) { // Se UPPER_DIAG_ROW
                            if (eLinha == cidades - i) {
                                eLinha = 0;
                                i++;
                                j = i;
                            }
                        } else if (!diagonalType) { // Se LOWER_DIAG_ROW
                            if (j == i + 1 && i + 1 < cidades) {
                                i++;
                                j = 0;
                            }
                        }
                    } else if (lex.type != TokenType.NEW_LINE) {
                        break; // A matriz termina quando é encontrado um Token diferente de NEW_LINE e de NUMBER
                    }
                }

                if (lex.token.equals("EDGE_WEIGHT_SECTION")) { // Inicio da matriz de adjascencia
                    obterDados = true;
                    //i = -1; // O próximo Token é "\n", onde i será incrementado para zero na condição acima
                }
            }

            switch (lex.type) {
                case INVALID_TOKEN:
                    System.out.printf("%02d: Lexema inválido [%s]\n", l.line(), lex.token);
                    break;
                case UNEXPECTED_EOF:
                    System.out.printf("%02d: Fim de arquivo inesperado\n", l.line());
                    break;
                default:
                    //System.out.printf("(\"%s\", %s)\n", lex.token, lex.type);
                    //System.out.println("\nArquivo Carregado!\n");
                    break;
            }
        } catch (Exception e) { //Print pilha de chamadas
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public int[][] gerarGrafo(int tamaho) {
        Random rand = new Random();
        int [][] matriz = new int[tamaho][tamaho];
        
        for (int i = 0; i < tamaho; i++)
            for (int j = 0; j < tamaho; j++)
                if (i != 0)
                    matriz[i][j] = rand.nextInt() % 1000;
                else
                    matriz[i][j] = 0;
        
        return matriz;
    }
    
    private static boolean checkType(TokenType type) {
        return !(type == TokenType.END_OF_FILE
                || type == TokenType.INVALID_TOKEN
                || type == TokenType.UNEXPECTED_EOF);
    }
}
