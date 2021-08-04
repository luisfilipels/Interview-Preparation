import java.util.Arrays;

public class LargestBSTSubtree {

    public static class TreeNode {
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

    static int maxSize = 0;

    static int helper (TreeNode node, int max, int min) {
        if (node == null) return 0;

        int left = helper(node.left, node.val, min);
        int right = helper(node.right, max, node.val);

        if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE) {
            // left and right are BSTs with values that came from above
            maxSize = Math.max(maxSize, left + right + 1);
            if (node.val >= max || node.val <= min) return Integer.MIN_VALUE;
            return left + right + 1;
        }

        left = helper(node.left, node.val, Integer.MIN_VALUE);
        right = helper(node.right, Integer.MAX_VALUE, node.val);

        if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE) {
            // left and right are BSTs rooted at this node
            maxSize = Math.max(maxSize, left + right + 1);
        }

        return Integer.MIN_VALUE;

    }

    public static int largestBSTSubtree(TreeNode root) {
        helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);

        return maxSize;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);

        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);*/

        System.out.println(largestBSTSubtree(root));

        String s = "/././//.";

        String [] arr = s.split("/");

        System.out.println(Arrays.toString(s.split("/")));
    }

}
