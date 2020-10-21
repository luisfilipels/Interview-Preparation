import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NAryTreeLevelOrderTraversal {

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private static List<List<Integer>> levelOrder (Node root) {
        if (root == null) return null;

        List<List<Integer>> returnList = new ArrayList<>();

        LinkedList<Node> queue = new LinkedList<>();
        queue.push(root);

        while(!queue.isEmpty()) {
            int n = queue.size();

            returnList.add(new ArrayList<>());
            int m = returnList.size();

            for (int i = 0; i < n; i++) {
                Node current = queue.poll();
                returnList.get(m-1).add(current.val);
                queue.addAll(current.children);
            }

            //returnList.get(m - 1).sort(Collections.reverseOrder());
        }

        return returnList;
    }

    public static void main(String[] args) {

    }

}
