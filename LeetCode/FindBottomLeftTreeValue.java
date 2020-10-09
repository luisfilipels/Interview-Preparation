import java.util.ArrayDeque;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class TreeNodeAux {
        TreeNode node;
        int level;
        int lefts;

        TreeNodeAux() {}
    }

    // This one is much easier than it may seem at first! Beats 100% of other attempts!
    // The node that we need to select from the tree is at the greatest height in the tree, counting from the root.
    // Not only that, but if it's the leftmost value of that specific height, that implies that to reach that node,
    // during our recursive calls, we mostly called root.left instead of root.right. So, if we memorize the maximum level
    // reached in the tree at each recursive call, as well as the amount of times we went to the left of each tree's
    // predecessors, we can store the nodes that maximized each of these two values. If we find a node that is at a greater
    // height in the tree than the one we previously thought was at the most height, or if we find a node that is at the
    // same height as our previous candidate, but had more root.left calls to reach it, we overwrite the previous candidate
    // with the data of the current node.
    private static int findBottomLeftValue (TreeNode root) {
        if (root.left == null && root.right == null) return root.val;

        var returnValue = new TreeNodeAux();

        helper(root, 0, 0, returnValue);

        return returnValue.node.val;
    }

    private static void helper (TreeNode root, int level, int lefts, TreeNodeAux selected) {
        if (root == null) return;

        if (level > selected.level || (level == selected.level && selected.lefts < lefts)) {
            selected.node = root;
            selected.level = level;
            selected.lefts = lefts;
        }

        helper(root.left, level+1,lefts+1, selected);
        helper(root.right, level+1, lefts-1, selected);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(7);

        System.out.println(findBottomLeftValue(root));
    }

}
