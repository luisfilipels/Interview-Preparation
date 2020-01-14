package Extras.LeetCode;

import java.util.HashMap;

public class ConstructTreeFromInorderAndPreorder {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    private static int indexAtInorder (int x, int [] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == x) {
                return i;
            }
        }
        return -1;
    }

    private static TreeNode buildTree (int [] preorder, int [] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1);
    }

    static int preorderIndex = 0;

    private static TreeNode helper (int [] preorder, int [] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode current = new TreeNode(preorder[preorderIndex++]);
        if (start == end) return current;

        int currentIndex = indexAtInorder(current.val, inorder);

        current.left = helper(preorder, inorder, start, currentIndex - 1);
        current.right = helper(preorder, inorder, currentIndex + 1, end);
        return current;
    }

    public static void main(String[] args) {
        int [] inorder = {9, 3, 15, 20, 7};
        int [] preorder = {3, 9, 20, 15, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root.val);
    }

}
