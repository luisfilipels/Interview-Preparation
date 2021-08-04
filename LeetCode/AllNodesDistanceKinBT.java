import java.util.*;

public class AllNodesDistanceKinBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static void buildParents (TreeNode current, TreeNode prev, HashMap<TreeNode, TreeNode> parents) {
        if (current == null) return;

        parents.put(current, prev);

        buildParents(current.left, current, parents);
        buildParents(current.right, current, parents);
    }

    static List<Integer> bfs(TreeNode target, HashMap<TreeNode, TreeNode> parents, int K) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        queue.add(target);
        int level = 0;

        while (level <= K) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current == null || visited.contains(current)) continue;
                visited.add(current);
                if (level == K) result.add(current.val);

                if(parents.get(current) != null) queue.add(parents.get(current));
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            level++;
        }

        return result;

    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();

        buildParents(root, null, parents);
        return bfs(target, parents, K);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(distanceK(root, root.left, 2));
    }

}
