package Extras.LeetCode;

public class BinaryTreeMaximumPathSum {

    private static class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    private static int maxPathSum (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int [] sum = new int[1];        // Useful to keep count of the maximum found so far without using a global variable.
        sum[0] = Integer.MIN_VALUE;
        maxPathSum(root, sum);
        return sum[0];

    }

    private static int maxPathSum (TreeNode root, int [] sum) {
        if (root == null) {
            return 0;
        }

        int left = maxPathSum(root.left, sum);
        int right = maxPathSum(root.right, sum);

        int currentIsNotTop = Math.max(Math.max(left, right) + root.val, root.val); // If consider the current node as not being the top of a subtree with maximum path sum, we will have this value.
        int currentIsTop = left + right + root.val; //Otherwise, if we consider it as the top of the subtree

        sum[0] = Math.max(Math.max(currentIsNotTop, currentIsTop), Math.max(sum[0], root.val)); // The maximum so far is the max of both of the previous, the current maximum, and this node's value (in case of negative numbers in the subtree)

        return currentIsNotTop;
    }

    /*private static int maxPathSum (TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxSoFar = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxSoFar;
    }*/

    /*private static int[] maxPathSumHelper (TreeNode root) {

        if (root == null) {
            return new int[] {0, 0};
        }

        int [] left = maxPathSumHelper(root.left);
        int [] right = maxPathSumHelper(root.right);

        int [] returnValue = new int[2];

        returnValue[0] = Math.max(Math.max(left[0], right[0]) + root.val, root.val);
        returnValue[1] = left[0] + right[0] + root.val;

        maxSoFar = Math.max(Math.max(returnValue[0], returnValue[1]), Math.max(maxSoFar, root.val));
        return returnValue;
    }*/

    public static void main(String[] args) {

        /*TreeNode root = new TreeNode(9);
        root.left = new TreeNode(6);
        root.right= new TreeNode(-3);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(2);
        root.right.right.left.left = new TreeNode(-6);
        root.right.right.left.right = new TreeNode(-6);
        root.right.right.left.left.left = new TreeNode(-6);*/


        /*TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-2);*/

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(3);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(3);

        System.out.println(maxPathSum(root));
    }

}
