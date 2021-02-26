public class RangeSumOfBST {

    private class TreeNode {
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

    public int rangeSumBST(TreeNode node, int low, int high) {
        if (node == null) return 0;

        int sum = 0;
        if (node.val < low) {
            sum = rangeSumBST(node.right, low, high);
        } else if (node.val > high) {
            sum = rangeSumBST(node.left, low, high);
        } else {
            sum = node.val + rangeSumBST(node.left, low, high) + rangeSumBST(node.right, low, high);
        }

        return sum;
    }

}
