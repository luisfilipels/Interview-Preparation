public class C4Q8 {

    // Thanks to the explanation of https://www.youtube.com/channel/UCZLJf_R2sWyUtXSKiKlyvAw

    static C4Tree.TreeNode commonAncestor (C4Tree.TreeNode root, C4Tree.TreeNode p, C4Tree.TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {               // Pass up the node we just found
            return root;
        }
        C4Tree.TreeNode left = commonAncestor(root.left, p, q);
        C4Tree.TreeNode right = commonAncestor(root.right, p, q);

        if (left != null && right != null) {        // If we've found that p and q have been found in the left and right subtrees, in which case, root is the common ancestor
            return root;
        }
        if (left == null && right == null) {        // If we haven't found in either the left nor right subtrees
            return null;
        }

        if (left != null) {                         // If we have found one of the values in the left subtree or right subtree, pass the value upwards
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        C4Tree.BinaryCompleteTree tree = new C4Tree.BinaryCompleteTree();

        for (int i = 1; i < 15; i++) {
            tree.add(i);
        }

        System.out.println(commonAncestor(tree.root, tree.root.left.left.left, tree.root).value);



    }
}
