package Extras.LeetCode;

public class MaxDepthBT {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // New solution.
    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    // First solution. Correct, but unnecessarily complex.
    /*
    private static int maxDepth;

    static private void preOrder (TreeNode node, int currentDepth) {
        maxDepth = Integer.max(maxDepth, currentDepth);
        if (node.left != null) preOrder(node.left, currentDepth+1);
        if (node.right != null) preOrder(node.right, currentDepth+1);
    }

    static public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth = 1;
        preOrder(root, maxDepth);
        return maxDepth;
    }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(2);

        System.out.println(maxDepth(root));

    }

}
