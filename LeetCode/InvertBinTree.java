package Extras.LeetCode;

public class InvertBinTree {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*static private void invertTreeHelper (TreeNode root) {
        if (root.left != null && root.right != null) {
            TreeNode swap = root.left;
            root.left = root.right;
            root.right = swap;
            invertTree(root.left);
            invertTree(root.right);
        } else if (root.left == null && root.right != null) {
            root.left = root.right;
            root.right = null;
            invertTree(root.left);
        } else if (root.left != null) {
            root.right = root.left;
            root.left = null;
            invertTree(root.right);
        }
    }

    static private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTreeHelper(root);
        return root;
    }*/

    // Simplified answer
    static private TreeNode invertTree (TreeNode root) {
        if (root == null) return null;

        TreeNode bkp = root.left;
        root.left = root.right;
        root.right = bkp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode newTree = invertTree(root);
        System.out.println(newTree.val);

    }

}
