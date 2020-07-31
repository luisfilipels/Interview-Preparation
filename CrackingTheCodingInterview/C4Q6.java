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

    As such, notice that due to the way we form BSTs, given a node that has a right subtree, any successor it may have MUST be
    on said subtree. So how do find this element? An equivalent question may be, given a node with value X, and its right subtree
    (that has all of its elements with values greater than X), how do we find the minimum value of this subtree? Consider the
    node with value 3 in the tree above. Its successor must be in its right subtree, with root 6. If we go to the right from
    there, we will only find nodes with value greater than 6, which is not what we want. However, if we go to the left subtree,
    we will only find values that greater than 3, and less than 6. If so, if we continue going to the left, starting from 6,
    we reach 4 (that is the successor of 3). We can repeat this process for any node that has a right subtree to find its successor.

    But what if it does not have a right subtree? That may either mean we've reached the largest number of the entire BST,
    or that we've finished traversing the left subtree of a certain node and that said node is the successor of the node
    we're currently trying to find its successor. In either case, given we have parent pointers, we can simply go up on the
    tree until we find a node whose value is greater than the current node's value (remember, if we are in the left subtree
    of a node, then all the values in this subtree must have values that are less than that of the root node), meaning that
    we've found the root node of the subtree.

    In a balanced BST, this algorithm has an O(h) time complexity, with h being its height, and an O(1) space complexity.
    Its time complexity is O(n) in an unbalanced tree, with n being the amount of nodes in the tree.
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
