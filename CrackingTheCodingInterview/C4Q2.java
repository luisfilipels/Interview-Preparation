import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
Book solution:

    TreeNode createMinimalBST (int array[]) {
        return createMinimalBST(array, 0, array.length -1);
    }

    TreeNode createMinimalBST (int arr[], int start, int end) {
        if (end < start) return null;
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }

 */

public class C4Q2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    static TreeNode helper (int [] arr, int i, int j) {
        if (j - i == 1) {
            TreeNode returnNode = new TreeNode(arr[j]);
            returnNode.left = new TreeNode(arr[i]);
            return returnNode;
        }
        if (i == j) {
            return new TreeNode(arr[i]);
        }
        int mid = (i + j) / 2;
        TreeNode current = new TreeNode(arr[mid]);
        current.left = helper(arr, i, mid-1);
        current.right = helper(arr, mid+1, j);

        return current;
    }

    static TreeNode MinimalBST (int [] arr) {
        int mid = arr.length/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(arr, 0, mid-1);
        root.right = helper(arr, mid+1, arr.length-1);
        return root;
    }

    public static void main(String[] args) {

        //int [] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int [] array = {1,2,3,4,5,6,7,8};

        TreeNode result = MinimalBST(array);

    }

}
