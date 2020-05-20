package Extras.HackerRank;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class RoadsAndLibraries {

    // RESULTS IN TIME LIMIT EXCEEDED

    static long roadsAndLibraries(int n, int c_lib, int c_road, int [][] cities) {
        long cost = 0;
        if (c_road > c_lib) { // Build libraries
            cost = (long)c_lib * (long)n;
            return cost;
        } else {    // Build roads
            // In the minimum spanning tree of a certain connected component, there are m-1 edges, with m being the number
            // of vertices in a connected component. Knowing this, there is no need to actually try to build the connected
            // component, you only need to find the connected components themselves.
            HashSet<Integer> nonVisited = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                nonVisited.add(i);
            }
            //ArrayList[] adjList = new ArrayList[n+1];
            HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                adjList.put(i, new ArrayList<>());
            }
            for (int [] road : cities) {
                int c1 = road[0];
                int c2 = road[1];
                adjList.get(c1).add(c2);
                adjList.get(c2).add(c1);
            }
            while (!nonVisited.isEmpty()) {
                int start = -1;
                for (int i : nonVisited) {
                    start = i;
                    break;
                }
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(start);
                nonVisited.remove(start);
                long verticesInCC = 0;
                while (!queue.isEmpty()) {
                    start = queue.poll();
                    verticesInCC++;
                    ArrayList<Integer> list = adjList.get(start);
                    for (Object i : list) {
                        int ii = (int)i;
                        if (nonVisited.contains(ii)) {
                            nonVisited.remove(ii);
                            queue.add(ii);
                        }
                    }
                }
                cost += ((verticesInCC - 1) * (long)c_road) + (long)c_lib;
            }
            return cost;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        int q;
        File file = new File("input10.txt");
        String content;
        Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name());
        content = scanner.next();
        q = Integer.parseInt(content);
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            int n, m, clib, croad;
            content = scanner.nextLine();
            String [] tokens = content.split(" ");
            n = Integer.parseInt(tokens[0]);
            m = Integer.parseInt(tokens[1]);
            clib = Integer.parseInt(tokens[2]);
            croad = Integer.parseInt(tokens[3]);
            int [][] cities = new int[m][2];
            for (int j = 0; j < m; j++) {
                content = scanner.nextLine();
                tokens = content.split(" ");
                cities[j][0] = Integer.parseInt(tokens[0]);
                cities[j][1] = Integer.parseInt(tokens[1]);
            }
            System.out.println(roadsAndLibraries(n, clib, croad, cities));
        }
        /*int[][] cities = new int[][] {
                {1, 2},
                {3, 1},
                {2, 3}
        };
        int n = 3;
        int c_lib = 2;
        int c_road = 1;*/
        /*int[][] cities = new int[][] {
                {1, 3},
                {3, 4},
                {2, 4},
                {1, 2},
                {2, 3},
                {5, 6}
        };
        int n = 6;
        int c_lib = 2;
        int c_road = 5;
        System.out.println(roadsAndLibraries(n, c_lib, c_road, cities));*/
    }

}
