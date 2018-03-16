package util;

import java.util.Scanner;

public class Console {
    private static Scanner in = new Scanner(System.in);
    
    
    public static String readString(String msg){
        System.out.print(msg);
        return in.nextLine();
    }
    public static double readDouble(String msg)
    {
        System.out.print(msg);
        return Double.parseDouble(in.nextLine());
    }
    public static float readFloat(String msg)
    {
        System.out.print(msg);
        return Float.parseFloat(in.nextLine());
    }
    public static int readInt(String msg)
    {
        System.out.print(msg);
        return Integer.parseInt(in.nextLine());
    }
    
}
