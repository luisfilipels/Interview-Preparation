package Extras.LeetCode;

import java.util.ArrayList;

public class ConstructBSTFromPreorder {

    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {val = x;}
    }

    /*
    From the following preorder traversal: 8 5 1 7 10 12;
    We know the root node is 8. 5 must be to its left, as we're dealing with a BST. Thus, 1 must be to left of 5. With this,
    you can determine that given an index i representing a position in preorder[], if the value of i-1 is greater than that
    of i, then i is the left child of i-1. So what about 7? It could be the right child of 8, 5 and 1, but in reality, it's
    the right child of 5, because 5 is the highest node of the tree that has a value less than 7. And 10? It's the right child
    of 8, for the same reason. And 12? It's the right child of 10, because, if we look at all previous elements, 10 is the only
    one in which its value is less than 12, has no right child and has the largest value in relation to the other nodes.
     */

    private static TreeNode bstFromPreorder(int[] preorder) {
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode root = new TreeNode(preorder[0]);
        list.add(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode newNode = new TreeNode(preorder[i]);
            list.add(newNode);
            TreeNode testLeft = list.get(i-1);
            if (newNode.val < testLeft.val) {
                testLeft.left = newNode;
                continue;
            }
            int heighestNode = Integer.MAX_VALUE;
            int maxVal = list.get(i-1).val;
            for (int j = i - 1; j >= 0; j--) {
                TreeNode current = list.get(j);
                if (current.val < newNode.val && current.right == null && current.val >= maxVal) {
                    maxVal = current.val;
                    heighestNode = j;
                }
            }
            list.get(heighestNode).right = newNode;
        }
        return root;
    }

    public static void main(String[] args) {
        int [] preorder = new int[] {8,5,1,7,10,12};
        bstFromPreorder(preorder);
    }

}
