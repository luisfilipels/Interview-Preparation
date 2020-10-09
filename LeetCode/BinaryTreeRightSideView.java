import java.util.*;

public class BinaryTreeRightSideView {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }

        TreeNode () {}
    }

    private static void helper(TreeNode root, int level, TreeMap<Integer,ArrayList<Integer>> map) {
        if (root == null) return;

        if (map.get(level) == null) map.put(level, new ArrayList<Integer>());

        map.get(level).add(root.val);

        helper(root.left, level + 1, map);
        helper(root.right, level + 1, map);
    }

    private static List<Integer> rightSideView(TreeNode root){
        if (root == null) return new ArrayList<Integer>();

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        helper(root, 0, map);

        List<Integer> returnList = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            returnList.add(entry.getValue().get(entry.getValue().size() - 1));
        }

        return returnList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideView(root));
    }

}
