package Extras;

import java.util.ArrayList;
import java.util.Stack;

public class GraphDFSNoRecursion {

    private static class AdjMatrixGraph {

        int [][] graph;

        AdjMatrixGraph(int n) {
            graph = new int[n][n];
        }

        void addEdge (int o, int d) {
            graph[o - 1][d - 1] = 1;
            graph[d - 1][o - 1] = 1;
        }

        boolean DFS (int o, int d) {
            boolean [] visited = new boolean[graph.length];
            for (int i = 0; i < visited.length; i++) {
                visited[i] = false;
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(o);
            visited[o] = true;
            while (!stack.empty()) {
                int current = stack.pop();
                for (int dest = 0; dest < graph.length; dest++) {
                    if (!visited[dest] && graph[current][dest] != 0) {
                        visited[dest] = true;
                        stack.push(dest);
                    }
                }
            }
            if (visited[d]) {
                return true;
            } else {
                return false;
            }
        }

    }

    public static void main(String[] args) {
        AdjMatrixGraph graph = new AdjMatrixGraph(7);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 7);
        //graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        System.out.println(graph.DFS(0, 3));
    }

}
