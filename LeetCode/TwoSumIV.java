import java.util.*;

public class TwoSumIV {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }

        TreeNode () {}
    }

    // First solution.
    private static boolean findTarget (TreeNode root, int k) {
        TreeNode temp = root;
        while (temp.val > k) {
            temp = temp.left;
        }

        Stack<TreeNode> stack = new Stack<>();
        HashSet<Integer> hash = new HashSet<>();
        stack.push(temp);

        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            int complement = k - current.val;
            if (hash.contains(complement)) return true;
            hash.add(current.val);
            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }
        return false;
    }

    private static void inorder(TreeNode root, List<Integer> returnList) {
        if (root == null) return;
        inorder(root.left, returnList);
        returnList.add(root.val);
        inorder(root.right, returnList);
    }

    // Second, optimized solution. Makes use of the fact that the inorder traversal of a BST is its elements in sorted order.
    private static boolean findTargetBST (TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int left = 0, right = list.size()-1;

        while (left < right) {
            if (list.get(left) + list.get(right) == k) return true;

            if (list.get(left) + list.get(right) > k) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
