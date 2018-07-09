package tp01;

import java.util.ArrayList;

public class ArvorePatricia {

    public class Position {
        public int linha;
        public int coluna;

        public Position(int linha, int coluna) {
            this.linha = linha;
            this.coluna = coluna;
        }
    }

    private static abstract class PatNo {
    }

    private static class PatNoInt extends PatNo {
        int index;
        PatNo esq, dir;
    }

    private static class PatNoExt extends PatNo {
        ArrayList positions = new ArrayList<Position>();
        String chave;
    }

    private PatNo raiz;
    private int nbitsChave;

    public static String convert(String s) {
        String aux = new String();
        int bytes = s.length() / 8;
        for (int i = 0; i < bytes; i++) {
            int valueByte = 0;
            String temp = s.substring(i * 8, i * 8 + 8);
            for (int j = 0; j < 8; j++) {
                valueByte += Math.pow(2, 7 - j) * (temp.charAt(j) - 48);
            }
            if (valueByte != 0) {
                aux = aux + (char) valueByte;
            }
        }
        return aux;
    }
    
    private int bit(int i, String k) {
        return k.charAt(i) - 48;
    }

    private boolean eExterno(PatNo p) {
        Class classe = p.getClass();
        return classe.getName().equals(PatNoExt.class.getName());
    }

    private PatNo criaNoInt(int i, PatNo esq, PatNo dir) {
        PatNoInt p = new PatNoInt();
        p.index = i;
        p.esq = esq;
        p.dir = dir;
        return p;
    }

    private PatNo criaNoExt(String k , Position pt) {
        PatNoExt p = new PatNoExt();
        p.positions.add(pt);
        p.chave = k;
        return p;
    }

    private void pesquisa(String k, PatNo t) {
        if (this.eExterno(t)) {
            PatNoExt aux = (PatNoExt) t;
            if (aux.chave.equals(k)) {
                System.out.println("Palavra \""+ convert(aux.chave) +"\" encontrada nas seguintes posicoes:");
                aux.positions.forEach(p->System.out.println( "Linha: " + ((Position)p).linha + "\tColuna: " + ((Position)p).coluna));
            } else {
                System.out.println("Palavra \""+ convert(aux.chave) +"\" nao encontrada");
            }
            System.out.println("");
        } else {
            PatNoInt aux = (PatNoInt) t;
            if (this.bit(aux.index, k) == 0) {
                pesquisa(k, aux.esq);
            } else {
                pesquisa(k, aux.dir);
            }
        }
    }

    private PatNo insereEntre(String k, Position pt, PatNo t, int i) {
        PatNoInt aux = null;
        if (!this.eExterno(t)) {
            aux = (PatNoInt) t;
        }
        if (this.eExterno(t) || (i < aux.index)) {
            PatNo p = this.criaNoExt(k, pt);
            if (this.bit(i, k) == 1) {
                return this.criaNoInt(i, t, p);
            } else {
                return this.criaNoInt(i, p, t);
            }
        } else {
            if (this.bit(aux.index, k) == 1) {
                aux.dir = this.insereEntre(k, pt, aux.dir, i);
            } else {
                aux.esq = this.insereEntre(k, pt, aux.esq, i);
            }
            return aux;
        }
    }

    private PatNo insere(String k, Position pt, PatNo t) {
        if (t == null) {
            return this.criaNoExt(k, pt);
        } else {
            PatNo p = t;
            while (!this.eExterno(p)) {
                PatNoInt aux = (PatNoInt) p;
                if (this.bit(aux.index, k) == 1) {
                    p = aux.dir;
                } else {
                    p = aux.esq;
                }
            }
            PatNoExt aux = (PatNoExt) p;
            int i = 0;
            while ((i < this.nbitsChave)
                    && (this.bit(i, k) == this.bit(i, aux.chave))) {
                i++;
            }
            if (i == this.nbitsChave) {
                aux.positions.add(pt);
                return t;
            } else {
                return this.insereEntre(k, pt, t, i);
            }
        }
    }
    
    public ArvorePatricia(int nbitsChave) {
        this.raiz = null;
        this.nbitsChave = nbitsChave;
    }

    public void pesquisa(String k) {
        this.pesquisa(k, this.raiz);
    }

    public void insere(String k, int linha, int coluna) {
        Position p = new Position(linha, coluna);
        this.raiz = this.insere(k, p, this.raiz);
    }
}
