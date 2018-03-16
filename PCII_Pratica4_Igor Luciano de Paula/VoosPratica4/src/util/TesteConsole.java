package util;

public class TesteConsole {

    public static void main(String[] args)
    {
        for(int i =0; i < 3 ; i++)
        {
            String nome = Console.readString("Entre com o nome: ");
            int n = Console.readInt("Entre com o numero1: ");
            double x = Console.readInt("Entre com o numero2: ");
            System.out.println("Nome: "+nome+" n: "+n+" x:"+x);
        }
    }
}
