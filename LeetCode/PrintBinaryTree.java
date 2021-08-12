import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() { }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int getHeight(TreeNode root) {
        if (root == null) return 0;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    static void buildTree(TreeNode currentNode, String[][] array, int r, int c, int height) {
        if (currentNode == null) return;

        array[r][c] = Integer.toString(currentNode.val);

        int offset = (int)Math.pow(2, height - r - 1);
        buildTree(currentNode.left, array, r+1, c - offset, height);
        buildTree(currentNode.right, array, r+1, c + offset, height);
    }

    public static List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root)-1;

        int m = height+1;
        int n = (int)Math.pow(2, height+1) - 1;
        String[][] array = new String[m][n];

        buildTree(root, array, 0, (n-1)/2, height);

        List<List<String>> returnList = new ArrayList<>();

        copyArrayOntoList(array, returnList);

        return returnList;
    }

    private static void copyArrayOntoList(String[][] array, List<List<String>> returnList) {
        for (int r = 0; r < array.length; r++) {
            returnList.add(new ArrayList<>());
            for (int c = 0; c < array[0].length; c++) {
                if (array[r][c] == null) returnList.get(r).add("");
                else returnList.get(r).add(array[r][c]);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(printTree(root));
    }

}
