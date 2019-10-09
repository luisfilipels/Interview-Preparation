package Extras;

import java.util.Stack;

public class TreeTraversalNoRecursion {

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        char value;

        TreeNode(char val) {
            value = val;
        }

    }

    private static class Tree {
        TreeNode root;
        Tree (char val) {
            root = new TreeNode(val);
        }

        TreeNode add(TreeNode node, char item) {
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
                System.out.println(current.value);
                if (current.right != null)  stack.push(current.right);
                if (current.left != null) stack.push(current.left);
            }
        }

        void InOrderNoRecursion () {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode current = root;
            while (current != null || !stack.empty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                System.out.println(current.value);
                current = current.right;
            }
        }

        void PostOrderNoRecursion() {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
                if (stack2.peek().left != null) stack1.push(stack2.peek().left);
                if (stack2.peek().right != null) stack1.push(stack2.peek().right);
            }
            while (!stack2.empty()) {
                System.out.println(stack2.pop().value);
            }
        }

    }

    public static void main(String[] args) {
        Tree tree = new Tree('A');
        tree.root.left = new TreeNode('B');
        tree.root.right = new TreeNode('C');
        tree.root.left.left = new TreeNode('D');
        tree.root.left.right = new TreeNode('E');
        tree.root.left.right.left = new TreeNode('F');
        //tree.InOrderNoRecursion();
        tree.PostOrderNoRecursion();
    }

}
