import java.util.ArrayList;
import java.util.List;

public class C4Q5 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    static boolean isValidBst (TreeNode root) {
        return helper(root, null, null);
    }

    static boolean helper (TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if (min != null) {
            if (root.val < min) return false;
        }

        if (max != null) {
            if (root.val > max) return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(9);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        System.out.println(isValidBst(root));

    }

}
