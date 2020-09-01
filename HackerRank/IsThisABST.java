package Extras.HackerRank;

public class IsThisABST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
        }
    }

    // This code should be correct, however, as this question appears to be bugged when using Java, the following code
    // in python 3 works and is accepted:
    /*
    def helper(root, min, max):
        if root is None:
            return True
        if max is not None and root.data >= max:
            return False
        if min is not None and root.data <= min:
            return False
        left = helper(root.left, min, root.data)
        right = helper(root.right, root.data, max)
        return left and right
     */
    static boolean helper (Node root, Integer neverLower, Integer neverAbove) {
        if (root == null) {
            return true;
        }

        if (neverAbove != null) {
            if (root.data >= neverAbove) {
                return false;
            }
        }

        if (neverLower != null) {
            if (root.data <= neverLower) {
                return false;
            }
        }

        return helper(root.left, neverLower, root.data) && helper(root.right, root.data, neverAbove);
    }

    static boolean checkBST (Node root) {
        return helper(root, null, null);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        System.out.println(checkBST(root));
    }

}
