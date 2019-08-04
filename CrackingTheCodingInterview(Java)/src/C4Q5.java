import java.util.ArrayList;
import java.util.List;

public class C4Q5 {

    private static void inOrderTraversal(C4Tree.TreeNode node, List<C4Tree.TreeNode> list) {
        if (node != null) {
            inOrderTraversal(node.right, list);
            list.add(node);
            inOrderTraversal(node.left, list);
        }
    }

    static boolean isValidBst (C4Tree.TreeNode root) {
        return isValidBst(root, null, null);
    }

    static boolean isValidBst(C4Tree.TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.value <= min) || (max != null && node.value > max)) {      // If the current value is less than the previously computed minimum... Conversely for the max.
            return false;
        }
        return isValidBst(node.left, min, node.value) && isValidBst(node.right, node.value, max);

    }

    /*
    The following solution doesn't take into account children with the same value as their parent.

    private static boolean isValidBst (C4Tree.TreeNode root) {
        ArrayList<C4Tree.TreeNode> list = new ArrayList<>();

        inOrderTraversal(root, list);

        if (list.size() <= 1) {
            return true;
        }

        int current, previous;

        current = list.get(1).value;
        previous = list.get(0).value;

        for (int i = 1; i < list.size(); i++) {
            current = list.get(i).value;
            if (current > previous) {
                return false;
            } else {
                previous = current;
            }
        }
        return true;
    }
    */

    public static void main(String[] args) {
        C4Tree.TreeNode root = new C4Tree.TreeNode(8);
        root.left = new C4Tree.TreeNode(3);
        root.left.left = new C4Tree.TreeNode(1);
        root.left.right = new C4Tree.TreeNode(6);
        root.right = new C4Tree.TreeNode(10);
        root.right.right = new C4Tree.TreeNode(14);
        root.right.right.left = new C4Tree.TreeNode(13);

        System.out.println(isValidBst(root));
        //System.out.println(isValidBst(root));

        /*ArrayList preOrder = new ArrayList();
        preOrderTraversal(root, preOrder);
        System.out.println(preOrder);

        ArrayList inOrder = new ArrayList();
        inOrderTraversal(root, inOrder);
        System.out.println(inOrder);

        ArrayList postOrder = new ArrayList();
        postOrderTraversal(root, postOrder);
        System.out.println(postOrder);
        */

    }

}
