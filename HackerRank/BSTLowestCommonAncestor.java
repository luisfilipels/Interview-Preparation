package Extras.HackerRank;

import java.util.HashMap;
import java.util.HashSet;

public class BSTLowestCommonAncestor {

    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
        }
    }

    public static void getParents (Node root, Node parent, HashMap<Node, Node> parents, HashMap<Integer, Node> map) {
        if (root == null) return;

        parents.put(root, parent);
        map.put(root.data, root);

        getParents(root.left, root, parents, map);
        getParents(root.right, root, parents, map);
    }

    public static Node lca(Node root, int v1, int v2) {
        HashMap<Node, Node> parent = new HashMap<>();
        HashMap<Integer, Node> map = new HashMap<>();

        getParents(root, null, parent, map);

        HashSet<Node> visited = new HashSet<>();

        Node temp = map.get(v1);

        while (temp != null) {
            visited.add(temp);
            temp = parent.get(temp);
        }

        temp = map.get(v2);

        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = parent.get(temp);
        }

        return null;
    }

    public static void main(String[] args) {

    }

}
