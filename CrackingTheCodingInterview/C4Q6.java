import java.util.HashMap;

public class C4Q6 {

    /*
    For a better view of this question, let's build a BST in which all elements to the right of a certain node are greater
    than it, and all elements to the left will be less than it.

                                                    8
                                                 /     \
                                                3       10
                                              /   \        \
                                             1     6       14
                                                 /   \     /
                                                4     7   13

    Remember that in an in-order traversal, for each node, we traverse the left subtree, then we visit the node, and finally
    traverse the right subtree. Doing so for the tree above we have: 1, 3, 4, 6, 7, 8, 10, 13, 14. Whenever we have a properly
    formed BST, running an in-order traversal on it will result in all of the values of said BST to be presented in sorted order.
    As such, notice that due to the way we form BSTs, given a node that has a right subtree, any successor it may have will be
    on said subtree. But what if it does not have a right subtree?

     */

    // HashMap used only for testing.
    static HashMap<Integer, TreeNode> hash = new HashMap<>();

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(int val) {
            this.val = val;
            hash.put(val, this);
        }

        void createLeft (int val) {
            left = new TreeNode(val);
            left.parent = this;
            hash.put(val, left);
        }

        void createRight (int val) {
            right = new TreeNode(val);
            right.parent = this;
            hash.put(val, right);
        }
    }

    static TreeNode findSuccessor (TreeNode node) {
        TreeNode temp;
        if (node.right != null) {
            temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
        } else {
            temp = node;
            while (temp.val <= node.val) {
                temp = temp.parent;
                if (temp == null) return null;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.createLeft(3);
        root.createRight(10);
        root.left.createLeft(1);
        root.left.createRight(6);
        root.left.right.createLeft(4);
        root.left.right.createRight(7);
        root.right.createRight(14);
        root.right.right.createLeft(13);

        System.out.println(findSuccessor(hash.get(11)).val);

    }

}
