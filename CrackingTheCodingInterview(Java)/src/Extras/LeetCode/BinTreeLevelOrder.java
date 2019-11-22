package Extras.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinTreeLevelOrder {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    // A solução seguinte está totalmente correta. As de baixo obtém o resultado correto, porém pelo método errado.
    static List<List<Integer>> levelOrder (TreeNode root) {
        if (root == null) {
            List<List<Integer>> returnList = new ArrayList<>();
            return returnList;
        }

        List<List<Integer>> returnList = new ArrayList<>();
        Queue<Object[]> queue = new ArrayDeque<>();
        queue.add(new Object[]{root, 0});
        while (!queue.isEmpty()) {
            Object [] current = queue.poll();
            TreeNode currentNode = (TreeNode)current[0];
            int currentLevel = (int)current[1];
            if (currentLevel >= returnList.size()) {
                returnList.add(new ArrayList<>());
            }
            returnList.get(currentLevel).add(currentNode.val);
            if (currentNode.left != null) queue.add(new Object[] {currentNode.left, currentLevel+1});
            if (currentNode.right != null) queue.add(new Object[] {currentNode.right, currentLevel+1});
        }

        //helper(returnList, root, 0);
        return returnList;
    }

    /*
    static void helper (List<List<Integer>> returnList, TreeNode node, int currentLevel) {
        if (currentLevel >= returnList.size()) {
            returnList.add(new ArrayList<>());
        }
        if (node.left != null) helper(returnList, node.left, currentLevel+1);
        returnList.get(currentLevel).add(node.val);
        if (node.right != null) helper(returnList, node.right, currentLevel+1);
        /*
        // Dá pra ser feita com exception handling como abaixo, mas a exceção consome MUITO tempo. A solução acima faz o
        // mesmo, é mais elegante, e mais rápida, no entanto, ela não faz um percurso "level order", apenas obtéms seu
        // resultado.
        try {
            returnList.get(currentLevel).add(node.val);
        } catch (Exception e) {
            int size = returnList.size();
            for (int i = 0; i <= currentLevel - size; i++) {
                returnList.add(new ArrayList<>());
            }
            returnList.get(currentLevel).add(node.val);
        }*/
    //}

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(-1);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(1);
        System.out.println(levelOrder(root));
    }

}
