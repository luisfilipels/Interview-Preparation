public class C4Q8 {

    // Thanks to the explanation of https://www.youtube.com/channel/UCZLJf_R2sWyUtXSKiKlyvAw

    /**static C4Tree.TreeNode commonAncestor (C4Tree.TreeNode root, C4Tree.TreeNode p, C4Tree.TreeNode q) {
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
    }*/

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

    // We use these booleans to check whether both nodes have been found or not.
    // Useful when we can't find a common ancestor.
    static boolean foundP = false;
    static boolean foundQ = false;


    static TreeNode commonAncestorHelper (TreeNode root, TreeNode p, TreeNode q) {
        if (root == p) {
            foundP = true;
            return root;
        } else if (root == q) {
            foundQ = true;
            return root;
        }

        if (root == null) return null;

        TreeNode left = commonAncestorHelper(root.left, p, q);
        TreeNode right = commonAncestorHelper(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else {
            if (left != null) return left;
            else if (right != null) return right;
            else return null;
        }
    }

    static TreeNode commonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        TreeNode result = commonAncestorHelper(root, p, q);

        if (foundQ && foundP) return result;
        else return null;
    }

    public static void main(String[] args) {
        TreeNode main = new TreeNode(1);
        main.createRight(3);
        main.right.createLeft(6);
        main.right.createRight(7);
        main.right.left.createRight(11);
        TreeNode root = new TreeNode(2);
        main.left = root;
        root.createLeft(4);
        root.createRight(5);
        root.left.createLeft(8);
        root.left.createRight(9);
        root.right.createRight(10);

        System.out.println(commonAncestor(main, root.left.left, root.right.right).val);

    }
}
