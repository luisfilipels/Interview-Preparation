package Extras.LeetCode;

public class FlattenBinTreeToLL {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    private static void flatten (TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
        TreeNode current = root;
        while (current != null) {
            current.right = current.left;
            current.left = null;
            current = current.right;
        }
    }

    static boolean foundBase = false;
    static TreeNode currentStep;

    private static void helper (TreeNode root) {
        if (root.left == null && !foundBase) {
            currentStep = root;
            foundBase = true;
        }
        if (root.left != null) {
            if (foundBase) {
                currentStep.left = root.left;
                currentStep = currentStep.left;
                helper(root.left);
            } else {
                helper(root.left);
            }
        }
        if (root.right != null) {
            currentStep.left = root.right;
            currentStep = currentStep.left;
            helper(root.right);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        flatten(root);
        System.out.println(root.val);
    }

}
