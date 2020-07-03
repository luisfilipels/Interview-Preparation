package Extras.LeetCode;

import java.util.HashMap;

public class HouseRobberIII {

    //https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // New solution. Uses more space.
    static private int rob(TreeNode root) {
        if (root == null) return 0;
        return helper(root, new HashMap<>());
    }

    static private int helper (TreeNode root, HashMap<TreeNode, Integer> hash) {
        if (root == null) return 0;

        if (hash.containsKey(root)) return hash.get(root);

        int max = root.val;

        if (root.left != null) {
            max += helper(root.left.left, hash) + helper(root.left.right, hash);
        }
        if (root.right != null) {
            max += helper(root.right.left, hash) + helper(root.right.right, hash);
        }

        int val =  Math.max(helper(root.left, hash) + helper(root.right, hash), max);
        hash.put(root, val);
        return val;
    }


    // Old solution, but just as good (except for space, the old one is better)
    /*static private int rob (TreeNode root) {
        if (root == null) return 0;
        int [] returnArray = helper(root);
        return Math.max(returnArray[0], returnArray[1]);
    }

    static private int[] helper (TreeNode node) {
        int [] ret = new int[2];  // ret[0] = if we rob, ret[1] = if we do not rob
        if (node == null) return ret;
        int [] left = helper(node.left);
        int [] right = helper(node.right);
        ret[0] = node.val + left[1] + right[1]; // If we *do* rob root, we can't rob neither left nor right.
        ret[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // If we *do not* rob root, we may or may not rob left and right
        return ret;
    }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(rob(root));
    }

}
