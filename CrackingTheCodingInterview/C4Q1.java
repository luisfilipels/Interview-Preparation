import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

public class C4Q1 {

    class Node {
        int id;
        ArrayList<Node> neighbors;
    }

    boolean bfs (Node n1, Node n2) {
        Queue<Node> queue = new ArrayDeque<>();
        HashSet<Node> visited = new HashSet<>();
        queue.add(n1);
        visited.add(n1);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    if (neighbor == n2) return true;
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    boolean checkPathExists(Node n1, Node n2) {
        return bfs(n1, n2) || bfs(n2, n1);
    }

    public static void main(String[] args) {

    }

}
