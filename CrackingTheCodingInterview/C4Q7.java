import java.util.*;

public class C4Q7 {

    // Classical question for using topological sort. In the book, you can find it under the "Advanced Topics" section.

    static class Node {
        char id;
        HashSet<Node> neighbors = new HashSet<>();
        int inbound = 0;

        Node (char id) {
            this.id = id;
        }
    }

    static ArrayList<Character> findBuildOrder (char [] projects, char[][] dependencies) {
        HashMap<Character, Node> nodes = new HashMap<>();
        for (char c : projects) {
            nodes.put(c, new Node(c));
        }
        for (char [] dependency : dependencies) {
            char from = dependency[0];
            char to = dependency[1];
            nodes.get(from).neighbors.add(nodes.get(to));
            nodes.get(to).inbound++;
        }
        ArrayList<Character> order = new ArrayList<>();
        Queue<Node> processNext = new ArrayDeque<>();

        for (Map.Entry<Character, Node> entry : nodes.entrySet()) {
            if (entry.getValue().inbound == 0) processNext.add(entry.getValue());
        }

        while (!processNext.isEmpty()) {
            Node current = processNext.poll();
            for (Node neighbor : current.neighbors) {
                neighbor.inbound--;
                if (neighbor.inbound == 0) {
                    processNext.add(neighbor);
                }
            }
            order.add(current.id);
        }

        if (order.size() != nodes.size()) {
            throw new UnsupportedOperationException();
        }

        return order;

    }

    public static void main(String[] args) {
        char [] projects = new char[] {'a', 'b', 'c', 'd', 'e', 'f'};
        char [][] dependencies = new char[][] {
                {'a', 'd'},
                {'f', 'b'},
                {'b', 'd'},
                {'f', 'a'},
                {'d', 'c'},
                //{'c', 'a'}
        };

        System.out.println(findBuildOrder(projects, dependencies));
    }

}
