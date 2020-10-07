import Extras.LeetCode.MergeTwoBinTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PathSumII {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    private static List<List<Integer>> pathSum (TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        //pathSum(root, new ArrayList<>(), 0, sum, result);
        pathSum(root, null, new HashMap<TreeNode, TreeNode>(), 0, sum, result);
        return result;
    }

    // First solution
    private static void pathSum (TreeNode root, List<Integer> currentList, int currentSum, int sum, List<List<Integer>> returnList) {
        if (root == null) return;

        List<Integer> newList = new ArrayList<>(currentList);
        newList.add(root.val);
        currentSum += root.val;
        if (currentSum == sum && root.left == null && root.right == null) {
            returnList.add(newList);
            return;
        }

        pathSum(root.left, newList, currentSum, sum, returnList);
        pathSum(root.right, newList, currentSum, sum, returnList);
    }

    // Second solution. Saves some space.
    private static void pathSum (TreeNode root, TreeNode ancestor, HashMap<TreeNode, TreeNode> parents, int currentSum, int sum, List<List<Integer>> returnList) {
        if (root == null) return;

        parents.put(root, ancestor);
        currentSum += root.val;

        if (currentSum == sum && root.left == null && root.right == null) {
            TreeNode current = root;
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (current != null) {
                list.add(current.val);
                current = parents.get(current);
            }
            Collections.reverse(list);
            returnList.add(list);
            return;
        }

        pathSum(root.left, root, parents, currentSum, sum, returnList);
        pathSum(root.right, root, parents, currentSum, sum, returnList);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left =new TreeNode(11);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        root.right.left = new TreeNode(13);

        System.out.println(pathSum(root, 22));
    }

}
