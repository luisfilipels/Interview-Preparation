public class KthSmallestElementInBST {

    static public class TreeNode {
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

    private static int kthSmallest (TreeNode root, int k) {
        return inorderKthSmallest(root, new int[] {k});
    }

    private static int inorderKthSmallest (TreeNode root, int[] countNums) {
        if (countNums[0] < 0) return Integer.MIN_VALUE;
        if (root == null) return Integer.MIN_VALUE;

        int left = inorderKthSmallest(root.left, countNums);

        countNums[0]--;
        if (countNums[0] == 0) return root.val;

        int right = inorderKthSmallest(root.right, countNums);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        System.out.println(kthSmallest(root, 2));
    }

}
