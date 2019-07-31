import java.util.ArrayList;
import java.util.List;

public interface C4Tree {

    class TreeNode{
        Object value;
        TreeNode left;
        TreeNode right;

        TreeNode(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    abstract class Tree <Type>{
        TreeNode root;

        abstract void add (Type item);

        abstract List<TreeNode> inOrderTraversal();

    }

    public class BinaryCompleteTree extends Tree {

        int nodeCount;
        int level;

        BinaryCompleteTree() {
            super();
            nodeCount = 0;
            level = 0;
        }

        @Override
        void add(Object item) {
            // Thanks to Funk, at StackOverflow!
            // https://stackoverflow.com/users/4838058/funk
            if (root == null) {
                root = new TreeNode(item);
                nodeCount = 1;
                return;
            } else {
                nodeCount++;
                TreeNode current = root;
                if (nodeCount >= Math.pow(2, level + 1)) {
                    level++;
                }
                for (int n = level - 1; n > 0; n--) {
                    current = checkBit(nodeCount, n) ? current.left : current.right;
                }
                if (checkBit(nodeCount, 0)) {
                    current.left = new TreeNode(item);
                } else {
                    current.right = new TreeNode(item);
                }
            }

        }

        boolean checkBit (int num, int position) {
            return ((num >> position) & 1) == 0;
        }

        private void tryAdd(Object item) {
            nodeCount++;
            TreeNode parent = findNode(nodeCount >> 1);
            if (nodeCount % 2 == 0) {
                parent.left = new TreeNode(item);
            } else {
                parent.right = new TreeNode(item);
            }
        }

        private TreeNode findNode (int location) {
            if (location == 1) {
                return root;
            }
            TreeNode parent = findNode(location >> 1);
            return (location % 2 == 0 ? parent.left : parent.right);
        }

        @Override
        public List<TreeNode> inOrderTraversal() {
            ArrayList<TreeNode> returnList = new ArrayList<>();
            if (root != null) {
                inOrderTraversal(root, returnList);
            }
            return returnList;
        }

        void inOrderTraversal(TreeNode node, List<TreeNode> list) {
            if (node != null) {
                inOrderTraversal(root.left, list);
                list.add(node);
                inOrderTraversal(root.right, list);
            }
        }
    }

}
