public class LowestCommonAncestorOfABinarySearchTree {
    private static class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    TreeNode helper(TreeNode node, int small, int big) {
        if (node.val >= small && node.val <= big) {
            return node;
        } else if (node.val > big) {
            return helper(node.left, small, big);
        } else {
            return helper(node.right, small, big);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = Math.min(p.val, q.val);
        int big = Math.max(p.val, q.val);

        return helper(root, small, big);
    }
}
