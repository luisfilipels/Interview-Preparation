package Extras.LeetCode;

public class DiameterOfBinaryTree {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    static int value = 0;

    static private int diameterOfBinaryTree (TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return value - 1;
    }

    static private int helper (TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        value = Math.max(value, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        //root.left.left.left = new TreeNode(4);
        //root.left.left.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //root.left.right.right = new TreeNode(5);
        //root.left.right.right.right = new TreeNode(5);
        //root.left.right.right.right.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }

}
