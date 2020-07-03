import java.util.ArrayList;
import java.util.LinkedList;

public class C4Q3 {

    static ArrayList<LinkedList<Integer>> findListOfDepths (C4Tree.TreeNode root) {
        ArrayList<LinkedList<Integer>> returnList = new ArrayList<>();
        if (root != null) {
            findListOfDepths(root, returnList, 0);
        }
        return returnList;
    }

    static void findListOfDepths (C4Tree.TreeNode node, ArrayList<LinkedList<Integer>> returnList, int nodeDepth) {
        if (node != null) {
            try {
                returnList.get(nodeDepth).add(node.value);
            } catch (Exception e) {
                returnList.add(new LinkedList<>());
                returnList.get(nodeDepth).add(node.value);
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

        C4Tree.TreeNode root = C4Q2.MinimalBST(arrayList);

        ArrayList<LinkedList<Integer>> list = findListOfDepths(root);

        System.out.println(list);


    }

}
