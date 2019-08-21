package Extras.InterviewBit;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LevelOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    // The following code is my solution. It was fully accepted, but as it makes heavy use of exceptions, I'm not sure if its
    // the best code for an interview.

    /*static public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> returnArray = new ArrayList<>();
        addToLevelArray(A, 0, returnArray);
        return returnArray;
    }

    static void addToLevelArray(TreeNode node, int currentLevel, ArrayList<ArrayList<Integer>> finalArray) {
        try {
            finalArray.get(currentLevel).add(node.val);
        } catch (Exception e) {
            finalArray.add(new ArrayList<>());
            finalArray.get(currentLevel).add(node.val);
        }
        if (node.left != null) {
            addToLevelArray(node.left, currentLevel + 1, finalArray);
        }
        if (node.right != null) {
            addToLevelArray(node.right, currentLevel + 1, finalArray);
        }

    }*/

    static public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (a == null)  return res;

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> al = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a = queue.poll();
                al.add(a.val);
                if (a.left != null)     queue.add(a.left);
                if (a.right != null)    queue.add(a.right);
            }
            res.add(al);
        }

        return res;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

}
