import java.util.*;

public class BinTreeLevelOrderII {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }

        TreeNode () {}
    }

    // First solution. Beats only 21% of other solutions.
    /*private static void helper(TreeNode root, int level, TreeMap<Integer, ArrayList<Integer>> map) {
        if (root == null) return;

        if (map.get(level) == null) map.put(level, new ArrayList<Integer>());

        map.get(level).add(root.val);

        helper(root.left, level + 1, map);
        helper(root.right, level + 1, map);
    }

    private static List<List<Integer>> levelOrderBottom (TreeNode root) {
        if (root == null) return new ArrayList<>();

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        helper(root, 0, map);

        List<List<Integer>> returnList = new ArrayList<>();

        for (int i = map.size()-1; i >= 0; i--) {
            returnList.add(map.get(i));
        }

        return returnList;
    }*/

    private static List<List<Integer>> levelOrderBottom (TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> returnList = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> newList = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode current = queue.poll();

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);

                newList.add(current.val);
            }
            returnList.add(0, newList);
        }
        return returnList;
    }

    public static void main(String[] args) {

    }

}
