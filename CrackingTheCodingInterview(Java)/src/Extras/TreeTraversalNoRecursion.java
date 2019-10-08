package Extras;

import java.util.Stack;

public class TreeTraversalNoRecursion {

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        TreeNode(int val) {
            value = val;
        }

    }

    private static class Tree {
        TreeNode root;
        Tree (int val) {
            root = new TreeNode(val);
        }

        TreeNode add(TreeNode node, int item) {
            if (node == null) {
                node = new TreeNode(item);
                return node;
            }
            if (item <= node.value) {
                node.left = add(node.left, item);
            } else {
                node.right = add(node.right, item);
            }
            return node;
        }

        void PreOrderNoRecursion () {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()) {
                TreeNode current = stack.pop();
                if (current.right != null)  stack.push(current.right);
                if (current.left != null) stack.push(current.left);
            }
        }

        void InOrderNoRecursion () {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()) {
                TreeNode current = root;
                
            }
            while (current.left != null) {
                current = current.left;
            }
            while (!stack.empty()) {

            }
        }

    }

}
