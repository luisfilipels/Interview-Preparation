public class SubtreeOfAnotherTree {

    private static class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    void preorder (TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('X');
            sb.append('|');
            return;
        }

        sb.append(root.val);
        sb.append('|');

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder ss = new StringBuilder();
        ss.append('|');
        StringBuilder st = new StringBuilder();
        st.append('|');

        preorder(s, ss);
        preorder(t, st);

        return ss.toString().contains(st.toString());
    }

}
