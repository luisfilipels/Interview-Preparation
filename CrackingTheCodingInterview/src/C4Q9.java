import java.util.ArrayList;
import java.util.LinkedList;

public class C4Q9 {

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

    //static ArrayList<String> bstSequences (C4Tree.TreeNode root) {

    // TODO Implement this question

    //}

    public static void main(String[] args) {
        C4Tree.BinarySearchTree bst = new C4Tree.BinarySearchTree();

        bst.add(5);

        bst.add(2);
        bst.add(7);

        bst.add(1);
        bst.add(3);

        bst.add(8);

        System.out.println(findListOfDepths(bst.root));
    }

}
