package Extras;

import java.util.*;

public class GraphDFSNoRecursionDijkstra {

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

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        };

        ArrayList<Integer> dijkstra (int s, int e) {
            int [] cost = new int[graph.length];
            for (int i = 0; i < cost.length; i++) {
                cost[i] = Integer.MAX_VALUE;
            }
            int [] backtrack = new int[graph.length];
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(comparator);
            cost[s] = 0;
            priorityQueue.add(new int[]{0, s});
            while (!priorityQueue.isEmpty()) {
                int [] vertexWeight = priorityQueue.poll();
                int startVertex = vertexWeight[1];
                int dist = vertexWeight[0];
                for (int v = 0; v < graph.length; v++) {
                    if (graph[startVertex][v] != 0 && cost[v] > cost[startVertex] + dist) {
                        cost[v] = cost[startVertex] + graph[startVertex][v];
                        priorityQueue.add(new int[]{cost[v], v});
                        backtrack[v] = startVertex;
                    }
                }
            }
            ArrayList<Integer> returnArray = new ArrayList<>();
            int j = e;
            returnArray.add(e);
            while (backtrack[j] != s) {
                returnArray.add(backtrack[j]);
                j = backtrack[j];
            }
            returnArray.add(s);
            Collections.reverse(returnArray);
            return returnArray;
        }

    }

    public static void main(String[] args) {
        AdjMatrixGraph graph = new AdjMatrixGraph(7);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        //System.out.println(graph.DFS(0, 3));
        System.out.println(graph.dijkstra(4, 2));
    }

}
