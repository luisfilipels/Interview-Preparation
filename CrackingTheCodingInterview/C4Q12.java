import java.util.HashMap;

public class C4Q12 {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode (int val) {
            this.val = val;
        }

        void createLeft (int val) {
            left = new TreeNode(val);
        }

        void createRight (int val) {
            right = new TreeNode(val);
        }
    }

    // This question can be seen as the tree version of the Subarray Sum Equals K question from LeetCode. If you understand
    // that question, then all you have to do is adapt its algorithm for use in a tree.

    static int countSumKInTree (TreeNode root, int k) {
        HashMap<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1);
        int [] count = new int[1];
        helper(root, k, sumFreq, 0, count);
        return count[0];
    }

    static void helper (TreeNode root, int k, HashMap<Integer, Integer> sumFreq, int currentSum, int[] count) {
        if (root == null) return;
        currentSum += root.val;
        if (sumFreq.containsKey(currentSum - k)) {
            count[0] += sumFreq.get(currentSum - k);
        }
        sumFreq.put(currentSum, sumFreq.getOrDefault(currentSum, 0) + 1);
        helper(root.left, k, new HashMap<>(sumFreq), currentSum, count);
        helper(root.right, k, new HashMap<>(sumFreq), currentSum, count);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.createLeft(-1);
        root.createRight(3);
        root.right.createRight(1);
        root.right.createLeft(3);
        root.right.left.createLeft(2);
        root.right.left.createRight(1);
        root.right.left.right.createRight(1);
        root.left.createLeft(4);
        root.left.left.createLeft(2);
        root.left.left.left.createRight(3);
        root.left.left.left.createLeft(-1);

        System.out.println(countSumKInTree(root, 5));
    }

}
