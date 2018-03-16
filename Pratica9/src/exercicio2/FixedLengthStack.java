package exercicio2;

/**
 *
 * @author Igor Luciano de Paula
 */
public class FixedLengthStack implements ISimpleStack{
    private final char[] data; //esse array contém a pilha
    private final int tos; //índice do topo da pilha

    public FixedLengthStack(char[] data, int tos) {
        this.data = data;
        this.tos = tos;
    }
    
    

    @Override
    public void push(char ch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
