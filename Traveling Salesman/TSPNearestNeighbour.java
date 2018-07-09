package tp3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

// Traveling Salesman Problem using Nearest neighbour Algorithm

public class TSPNearestNeighbour {
    private int numberOfNodes;
    private Stack<Integer> stack;

    public TSPNearestNeighbour() {
        stack = new Stack<Integer>();
    }

    public void tsp(int adjacencyMatrix[][]) {
        int custo = 0;
        
        numberOfNodes = adjacencyMatrix[1].length;
        int[] visited = new int[numberOfNodes];
        visited[0] = 1;
        stack.push(0);
        int element, dst = 0, last = 0, i;
        int min = Integer.MAX_VALUE;
        boolean minFlag = false;
        System.out.print(0 + "\t");

        while (!stack.isEmpty()) {
            element = stack.peek();
            i = 0;
            min = Integer.MAX_VALUE;
            while (i < numberOfNodes) {
                if (adjacencyMatrix[element][i] > 1 && visited[i] == 0) {
                    if (min > adjacencyMatrix[element][i]) {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag) {
                custo += min;
                last = dst;
                visited[dst] = 1;
                stack.push(dst);
                System.out.print(dst + "\t");
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        
        custo += adjacencyMatrix[0][last];
        
        System.out.println("\nCusto = " + custo);
    }
}
