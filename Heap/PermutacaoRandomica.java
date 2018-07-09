package Pratica04;
import java.util.Random;

//Permutação
public class PermutacaoRandomica {
  public static double rand0a1 (Random rand) {
   
    rand.setSeed (System.currentTimeMillis ());
   
    return rand.nextDouble ();
  }
  public static void permut (Item v[], int n) {
    Random rand = new Random ();
    for (int i = n - 1; i > 0; i--) {
      int j = (int) (((double) i * rand0a1 (rand)) + 1.0);
      Item b = v[i]; v[i] = v[j]; v[j] = b;
    }
  }
  public static void permut (int v[], int n) {
    Random rand = new Random ();
    for (int i = n - 1; i > 0; i--) {
      int j = (int) (((double) i * rand0a1 (rand)) + 1.0);
      int b = v[i]; v[i] = v[j]; v[j] = b;
    }
  }
  public static void permut (char v[], int n) {
    Random rand = new Random ();
    for (int i = n - 1; i > 0; i--) {
      int j = (int) (((double) i * rand0a1 (rand)) + 1.0);
      char b = v[i]; v[i] = v[j]; v[j] = b;
    }
  }

}