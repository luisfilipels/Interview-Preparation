package Extras.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestorBT {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x;}
    }

    // Alternative answer, creating parent pointers. To show off skillzzz, because it's slower than the original solution.
    private static TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        buildParents(root, null, parents);
        HashSet<TreeNode> visited = new HashSet<>();

        TreeNode temp = p;
        while (temp != null) {
            visited.add(temp);
            temp = parents.get(temp);
        }

        temp = q;
        while (temp != null) {
            if (visited.contains(temp)) return temp;
            temp = parents.get(temp);
        }
        return null;
    }

    private static void buildParents (TreeNode root, TreeNode parent, HashMap<TreeNode, TreeNode> parents) {
        if (root == null) return;
        parents.put(root, parent);
        buildParents(root.left, root, parents);
        buildParents(root.right, root, parents);
    }
    /*private static TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return returnNode;
    }

    private static TreeNode returnNode = null;

    private static boolean helper (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);
        boolean current = root == p || root == q;
        if ((right && current) || (left && current) || (left && right)) {
            returnNode = root;
        }
        return left || right || current;
    }*/

    /*static private boolean hasFound = false;
    static TreeNode returnNode;

    private static HashSet<TreeNode> helper (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == q && p == root) {
            if (!hasFound) {
                returnNode = root;
                hasFound= true;
            }
        }
        HashSet<TreeNode> left = helper(root.left, p, q);
        HashSet<TreeNode> right = helper(root.right, p, q);
        HashSet<TreeNode> returnHash = new HashSet<>();
        returnHash.add(root);
        if (left == null && right == null) {
            return returnHash;
        } else if (left == null) {
            returnHash.addAll(right);
        } else if (right == null) {
            returnHash.addAll(left);
        } else {
            returnHash.addAll(left);
            returnHash.addAll(right);
        }
        if (returnHash.contains(p) && returnHash.contains(q)) {
            if (!hasFound) {
                returnNode = root;
                hasFound= true;
            }
        }
        return returnHash;
    }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
    }

}

/*
* [3,5,1,6,2,0,8,null,null,7,4]
*  5
*  4
* */