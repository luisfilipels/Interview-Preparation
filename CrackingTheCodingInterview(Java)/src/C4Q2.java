import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/*
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

    static C4Tree.TreeNode MinimalBST (ArrayList<Integer> array) {
        // TODO Check how my implemntation can be improved
        if (array.size() == 0) {
            return null;
        } else if (array.size() == 1) {
            return new C4Tree.TreeNode(array.get(0));
        }
        int middle = array.size() / 2;

        C4Tree.TreeNode root = new C4Tree.TreeNode(array.get(middle));

        for (int sep = 1; sep <= middle; sep++) {
            try {
                root = addNode(array, root, middle + sep);
            } catch (IndexOutOfBoundsException ignored) {}

            try {
                root = addNode(array, root, middle - sep);
            } catch (IndexOutOfBoundsException ignored) {}

        }

        return root;
    }

    static C4Tree.TreeNode addNode (ArrayList<Integer> array, C4Tree.TreeNode currentNode, int currentArrIndex) {
        if (currentNode == null) {
            currentNode = new C4Tree.TreeNode(array.get(currentArrIndex));
            return currentNode;
        }
        if (array.get(currentArrIndex) < currentNode.value) {
            currentNode.left = addNode(array, currentNode.left, currentArrIndex);
        } else if (array.get(currentArrIndex) > currentNode.value) {
            currentNode.right = addNode(array, currentNode.right, currentArrIndex);
        } else {
            if (currentNode.right == null) {
                currentNode.right = addNode(array, currentNode.right, currentArrIndex );
            } else {
                currentNode.left = addNode(array, currentNode.left, currentArrIndex);
            }
        }
        return currentNode;
    }

    public static void main(String[] args) {

        //int [] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int [] array = {1, 2, 2, 3, 3, 4, 5, 5, 6};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : array) {
            arrayList.add(i);
        }

        MinimalBST(arrayList);

    }

}
