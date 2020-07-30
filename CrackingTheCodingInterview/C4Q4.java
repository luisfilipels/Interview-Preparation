import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class C4Q4 {

    // TODO: Check if this is correct

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    static boolean flag = true;

    static int helper (TreeNode root, int currentDepth) {
        if (root == null) return currentDepth;

        int left = helper(root.left, currentDepth+1);
        int right = helper(root.right, currentDepth+1);

        if (Math.abs(left - right) > 1) flag = false;

        return Math.max(left, right);
    }

    static boolean isBalanced (TreeNode root) {
        helper(root, 0);
        return flag;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        /*root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);*/

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.right = new TreeNode(5);

        System.out.println(isBalanced(root));
        //System.out.println(checkSubTreeBalanced(root));
    }
}
