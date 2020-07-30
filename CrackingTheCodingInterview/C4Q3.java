import java.util.ArrayList;
import java.util.LinkedList;

public class C4Q3 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    static ArrayList<LinkedList<Integer>> findListOfDepths (TreeNode root) {
        ArrayList<LinkedList<Integer>> returnList = new ArrayList<>();
        if (root != null) {
            findListOfDepths(root, returnList, 0);
        }
        return returnList;
    }

    static void findListOfDepths (TreeNode node, ArrayList<LinkedList<Integer>> returnList, int nodeDepth) {
        if (node != null) {
            try {
                returnList.get(nodeDepth).add(node.val);
            } catch (Exception e) {
                returnList.add(new LinkedList<>());
                returnList.get(nodeDepth).add(node.val);
            }
            findListOfDepths(node.left, returnList, nodeDepth + 1);
            findListOfDepths(node.right, returnList, nodeDepth + 1);
        }
    }

    public static void main(String[] args) {
        int [] array = {1, 2, 2, 3, 3, 4, 5, 5, 6};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : array) {
            arrayList.add(i);
        }


    }

}
