package Extras.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinTreeInorder {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    static private List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        ArrayList<Integer> list = new ArrayList<>();
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(inorderTraversal(root));
    }

}
