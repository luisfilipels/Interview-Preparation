import java.util.ArrayList;

public class C4Q10 {

    public static void preOrderTraversal(C4Tree.TreeNode node, ArrayList<C4Tree.TreeNode> list) {
        if (node != null) {
            list.add(node);
            preOrderTraversal(node.left, list);
            preOrderTraversal(node.right, list);
        }
    }

    public static void inOrderTraversal(C4Tree.TreeNode node, ArrayList<C4Tree.TreeNode> list) {
        if (node != null) {
            inOrderTraversal(node.left, list);
            list.add(node);
            inOrderTraversal(node.right, list);
        }
    }

    public static void postOrderTraversal(C4Tree.TreeNode node, ArrayList<C4Tree.TreeNode> list) {
        if (node != null) {
            postOrderTraversal(node.left, list);
            postOrderTraversal(node.right, list);
            list.add(node);
        }
    }

    // Answer from the book.

    /*
    By utilizing a pre-order traversal, we can check if the string resulting
    from the traversal of each tree differs at the point in which the traversal of the smaller tree
    starts at the larger tree. The problem is that by simply utilizing a pre-order traversal, it could be the case
    that trees with different structures had the same traversal. E.g.:

            3                    3
          /                        \
        4                            4

    traversal:
        3 4                       3 4

    We solve that by considering null nodes as leafs, and inserting them into our string as a special character. Example:

            3                    3
          /   \                /    \
        4       x             x      4
      /    \                        /  \
     x      x                      x    x

     traversal:
     3 4 x x x               3 x 4 x x
    */

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

    static boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(t1, string1);
        getOrderString(t2, string2);

        return string1.indexOf(string2.toString()) != -1;                   // Returns -1 if different

    }

    static void getOrderString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");
            return;
        }
        sb.append(node.val + " ");
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);
    }



    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(7);
        root2.left = new TreeNode(6);
        root2.right = new TreeNode(8);


        System.out.println(containsTree(root, root2));

    }

}
