package Extras.HackerRank;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SwapNodes {

    static class TreeNode {
        int data;
        int level;
        TreeNode left;
        TreeNode right;

        TreeNode (int data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    static int maxDepth = 1;

    static void createTree(int[][] indexes, HashMap<Integer, TreeNode> map, HashMap<Integer, ArrayList<TreeNode>> levels) {
        for (int i = 0; i < indexes.length; i++) {
            int currentNodeIndex = i+1;
            TreeNode currentNode = map.get(currentNodeIndex);
            if (currentNode.data == 11) {
                System.out.println("HERE");
            }
            int[] children = indexes[i];
            int newLevel = currentNode.level+1;
            maxDepth = Math.max(maxDepth, newLevel);

            if (children[0] != -1) {
                currentNode.left = new TreeNode(children[0], newLevel);
                map.put(children[0], currentNode.left);
                if (!levels.containsKey(newLevel)) {
                    levels.put(newLevel, new ArrayList<>());
                }
                levels.get(newLevel).add(currentNode.left);
            }
            if (children[1] != -1) {
                currentNode.right = new TreeNode(children[1], newLevel);
                map.put(children[1], currentNode.right);
                if (!levels.containsKey(newLevel)) {
                    levels.put(newLevel, new ArrayList<>());
                }
                levels.get(newLevel).add(currentNode.right);
            }
        }
    }

    static void swapSubtree (int k, HashMap<Integer, ArrayList<TreeNode>> levels) {
        int depth = k;
        for (int i = 1; depth <= maxDepth; i++) {
            depth = k * i;
            if (depth >= maxDepth) return;
            ArrayList<TreeNode> list = levels.get(depth);
            for (TreeNode n : list) {
                TreeNode temp = n.left;
                n.left = n.right;
                n.right = temp;
            }
        }

    }

    static void getTraversal (TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        getTraversal(root.left, list);
        list.add(root.data);
        getTraversal(root.right, list);
    }

    static int[][] swapNodes (int[][] indexes, int[] queries) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashMap<Integer, ArrayList<TreeNode>> levels = new HashMap<>();
        TreeNode root = new TreeNode(1,1);
        map.put(1, root);
        levels.put(1, new ArrayList<>());
        levels.get(1).add(root);

        createTree(indexes, map, levels);

        int [][] resultArray = new int[queries.length][indexes.length];

        for (int i = 0; i < queries.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int k = queries[i];
            swapSubtree(k, levels);
            getTraversal(root, list);
            for (int j = 0; j < list.size(); j++) {
                resultArray[i][j] = list.get(j);
            }
        }

        return resultArray;
    }

    public static void main(String[] args) {
        /*int[][] indexes = new int[][] {
                {2,3},
                {-1,-1},
                {-1,-1}
        };

        int[] queries = new int[] {1, 1};*/

        int [][] indexes = new int[][] {
                {2,3},
                {4,-1},
                {5,-1},
                {6,-1},
                {7,8},
                {-1,9},
                {-1,-1},
                {10,11},
                {-1,-1},
                {-1,-1},
                {-1,-1}
        };

        int[] queries = new int[] {2,4};

        System.out.println(Arrays.deepToString(swapNodes(indexes, queries)));
    }

}
