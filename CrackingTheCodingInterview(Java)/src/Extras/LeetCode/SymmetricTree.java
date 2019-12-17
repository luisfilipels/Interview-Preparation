package Extras.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class SymmetricTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    private static boolean isSymmetric (TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<ArrayList<Integer>> levels = perLevel(root);
        for (ArrayList<Integer> level : levels) {
            if (level.size() > 1 && level.size() % 2 == 1) {
                return false;
            }
            int i = 0;
            int j = level.size()-1;
            while (i <= j) {
                if (!level.get(i).equals(level.get(j))) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    static class Tuple {
        TreeNode node;
        int level;
        Tuple(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    private static ArrayList<ArrayList<Integer>> perLevel (TreeNode root) {
        ArrayList<ArrayList<Integer>> returnArray = new ArrayList<>();
        Queue<Tuple> queue = new ArrayDeque<>();
        queue.add(new Tuple(root,0));
        while (!queue.isEmpty()) {
            Tuple currentTuple = queue.poll();
            TreeNode currentNode = currentTuple.node;
            int currentLevel = currentTuple.level;
            if (currentLevel >= returnArray.size()) {
                returnArray.add(new ArrayList<>());
            }
            if (currentLevel+1 >= returnArray.size()) {
                returnArray.add(new ArrayList<>());
            }
            if (currentNode != null) {
                returnArray.get(currentLevel).add(currentNode.val);
            } else {
                returnArray.get(currentLevel).add(-1);
            }
            if (currentNode != null) {
                queue.add(new Tuple(currentNode.left, currentLevel+1));
                queue.add(new Tuple(currentNode.right, currentLevel+1));
            }
        }
        return returnArray;



        /*if (currentLevel >= current.size()) {
            current.add(new ArrayList<>());
        }
        if (root.left != null) perLevel(root.left, current, currentLevel+1);
        current.get(currentLevel).add(root.val);
        if (root.right != null) perLevel(root.right, current,  currentLevel+1);*/
        /*if (root.left != null) {
            current.addAll(perLevel(root.left, current, currentLevel+1));
        }
        if (currentLevel > current.size()) {
            while (current.size() < currentLevel) {
                current.add(new ArrayList<>());
            }
            current.get(currentLevel-1).add(root.val);
        }
        if (root.right != null) {
            current.addAll(perLevel(root.right, current, currentLevel+1));
        }
        return current;*/
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        System.out.println(isSymmetric(root));
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));*/
    }

}
