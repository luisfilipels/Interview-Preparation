import java.util.ArrayList;

public class C4Q4 {

    static int checkHeight(C4Tree.TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    static boolean isBalanced (C4Tree.TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    /*
    static boolean checkNodeBalanced (C4Tree.TreeNode node) {
        if (node != null) {
            int hl = checkHeight(node.left);
            int hr = checkHeight(node.right);
            if (Math.abs(hl - hr) > 1) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    static boolean checkSubTreeBalanced (C4Tree.TreeNode node) {
        if (node != null) {
            boolean currentIsBalanced = checkNodeBalanced(node);
            boolean leftIsBalanced = checkSubTreeBalanced(node.left);
            boolean rightIsBalanced = checkSubTreeBalanced(node.right);
            return leftIsBalanced && rightIsBalanced && currentIsBalanced;
        }
        return true;
    }

    static int checkHeight (C4Tree.TreeNode node) {
        if (node == null) {
            return -1;
        }
        int hl, hr;
        if (node.left == null) {
            hl = 0;
        } else {
            hl = checkHeight(node.left);
        }
        if (node.right == null) {
            hr = 0;
        } else {
            hr = checkHeight(node.right);
        }
        int height = 1 + Math.max(hr, hl);
        return height;
    }
    */

    public static void main(String[] args) {
        //int [] array = {1, 2, 2, 3, 3, 4, 5, 5, 6};
        //ArrayList<Integer> arrayList = new ArrayList<>();
        //for (int i : array) {
        //    arrayList.add(i);
        //}

        //C4Tree.TreeNode root = C4Q2.MinimalBST(arrayList);

        C4Tree.TreeNode root = new C4Tree.TreeNode(1);
        root.left = new C4Tree.TreeNode(2);
        root.right = new C4Tree.TreeNode(3);
        root.left.left = new C4Tree.TreeNode(5);
        root.left.right = new C4Tree.TreeNode(4);

        System.out.println(isBalanced(root));
        //System.out.println(checkSubTreeBalanced(root));
    }
}
