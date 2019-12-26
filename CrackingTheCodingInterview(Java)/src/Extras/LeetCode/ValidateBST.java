package Extras.LeetCode;

public class ValidateBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    private static boolean isValidBST (TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode root, Integer lowEnd, Integer upperEnd) {
        if (root == null) return true;

        int val = root.val;
        if (lowEnd != null && val <= lowEnd) return false;
        if (upperEnd != null && val >= upperEnd) return false;

        if (! isValidBST(root.right, val, upperEnd)) return false;
        if (! isValidBST(root.left, lowEnd, val)) return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);*/
        System.out.println(isValidBST(root));
    }

}
