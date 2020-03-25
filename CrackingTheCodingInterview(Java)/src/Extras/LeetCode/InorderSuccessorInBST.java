package Extras.LeetCode;

import com.sun.source.tree.Tree;

public class InorderSuccessorInBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static TreeNode findMinimum (TreeNode node) {
        TreeNode temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    static TreeNode findSuccessor (TreeNode root, TreeNode p) {
        if (p.right != null) {
            return findMinimum(p.right);
        }
        TreeNode temp = root;
        TreeNode successor = null;
        while (temp != null) {
            if (p.val < temp.val) {
                successor = temp;
                temp = temp.left;
            } else if (p.val > temp.val) {
                temp = temp.right;
            } else {
                break;
            }
        }
        return successor;
    }

    /*static TreeNode findSuccesor (TreeNode root, TreeNode p) {
        helper(root, p);
        return node;
    }

    static boolean foundTarget = false;
    static boolean targetAtributed = false;
    static TreeNode node;

    static void helper (TreeNode root, TreeNode target) {
        if (root == null) return;
        helper(root.left, target);
        if (!targetAtributed) {
            if (foundTarget) {
                node = root;
                targetAtributed = true;
            }
            if (!foundTarget && root == target) {
                foundTarget = true;
            }
        }
        helper(root.right, target);
    }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.right.left = new TreeNode(21);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(10);
        root.left.right.left.left = new TreeNode(9);
        root.left.right.left.right = new TreeNode(11);

        System.out.println(findSuccessor(root, root.left.right.right).val);
    }
}
