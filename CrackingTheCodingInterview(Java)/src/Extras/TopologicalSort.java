package Extras;

import java.util.*;

public class TopologicalSort {

    static class Vertex {

        Vertex (char value) {
            this.value = value;
        }

        char value;
        ArrayList<Vertex> neighbors = new ArrayList<>();
    }

    static class Graph {
        ArrayList<Vertex> vertices = new ArrayList<>();
        HashMap<Character, Vertex> hashMap = new HashMap<>();

        void addVertex (char value) {
            vertices.add(new Vertex(value));
            hashMap.put(value, vertices.get(vertices.size()-1));
        }

        void addEdge (char from, char to) {
            hashMap.get(from).neighbors.add(hashMap.get(to));
        }
    }

    static class Sorter {
        Deque<Character> stack = new ArrayDeque<>();
        HashSet<Vertex> visited = new HashSet<>();


        String sort (Graph g) {
            for (Vertex v : g.vertices) {
                if (!visited.contains(v)) {
                    dfs(v);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        }

        void dfs (Vertex v) {
            visited.add(v);
            for (Vertex n : v.neighbors) {
                if (!visited.contains(n)) {
                    dfs(n);
                }
            }
            stack.offerFirst(v.value);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex('a');
        g.addVertex('b');
        g.addVertex('c');
        g.addVertex('d');
        g.addVertex('e');
        g.addVertex('f');
        g.addVertex('g');
        //g.addVertex('h');

        /*g.addEdge('a', 'c');
        g.addEdge('b', 'c');
        g.addEdge('b', 'd');
        g.addEdge('c', 'e');
        g.addEdge('d', 'f');
        g.addEdge('e', 'f');
        g.addEdge('f', 'g');
        g.addEdge('e', 'h');*/

        g.addEdge('a', 'c');
        g.addEdge('b', 'c');
        g.addEdge('b', 'e');
        g.addEdge('c', 'd');
        g.addEdge('d', 'f');
        g.addEdge('e', 'f');
        g.addEdge('f', 'g');


        Sorter sorter = new Sorter();
        System.out.println(sorter.sort(g));

    }

}
