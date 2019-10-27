package Extras.LeetCode;

public class MergeTwoBinTrees {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    private static void fillPreOrderHelper(TreeNode t1, TreeNode t2, TreeNode t3) {
        t3.val = t1.val + t2.val;
        if (t1.left == null && t2.left != null) {
            t1.left = new TreeNode(0);
        } else if (t2.left == null && t1.left != null) {
            t2.left = new TreeNode(0);
        }

        if (t1.left != null && t2.left != null) {
            t3.left = new TreeNode(0);
            fillPreOrderHelper(t1.left, t2.left, t3.left);
        }
        if (t1.right == null && t2.right != null) {
            t1.right = new TreeNode(0);
        } else if (t2.right == null && t1.right != null) {
            t2.right = new TreeNode(0);
        }
        if (t1.right != null && t2.right != null) {
            t3.right = new TreeNode(0);
            fillPreOrderHelper(t1.right, t2.right, t3.right);
        }
    }

    private static TreeNode fillPreOrderMain(TreeNode t1, TreeNode t2) {
        TreeNode t3 = new TreeNode(0);
        fillPreOrderHelper(t1, t2, t3);
        return t3;
    }

    static private TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            t1 = new TreeNode(0);
        }
        if (t2 == null) {
            t2 = new TreeNode(0);
        }
        return fillPreOrderMain(t1, t2);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);
        TreeNode res = mergeTrees(root1, root2);
    }

}
