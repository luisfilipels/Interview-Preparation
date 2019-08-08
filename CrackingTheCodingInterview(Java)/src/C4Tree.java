import java.util.ArrayList;
import java.util.List;

public interface C4Tree {



    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    abstract class Tree{
        TreeNode root;

        abstract void add (int item);

        public List<TreeNode> inOrderTraversal() {
            ArrayList<TreeNode> returnList = new ArrayList<>();
            if (root != null) {
                inOrderTraversal(root, returnList);
            }
            return returnList;
        }

        public void inOrderTraversal(TreeNode node, List<TreeNode> list) {
            if (node != null) {
                inOrderTraversal(node.left, list);
                list.add(node);
                inOrderTraversal(node.right, list);
            }
        }

        List<TreeNode> postOrderTraversal() {
            ArrayList<TreeNode> returnList = new ArrayList<>();
            if (root != null) {
                postOrderTraversal(root, returnList);
            }
            return returnList;
        }

        public void postOrderTraversal(TreeNode node, List<TreeNode> list) {
            if (node != null) {
                postOrderTraversal(node.left, list);
                postOrderTraversal(node.right, list);
                list.add(node);
            }
        }

        List<TreeNode> preOrderTraversal() {
            ArrayList<TreeNode> returnList = new ArrayList<>();
            if (root != null) {
                preOrderTraversal(root, returnList);
            }
            return returnList;
        }

        public void preOrderTraversal(TreeNode node, List<TreeNode> list) {
            if (node != null) {
                list.add(node);
                preOrderTraversal(node.left, list);
                preOrderTraversal(node.right, list);
            }
        }

    }

    class BinaryCompleteTree extends Tree {

        int nodeCount;
        int level;

        BinaryCompleteTree() {
            super();
            nodeCount = 0;
            level = 0;
        }

        @Override
        void add(int item) {
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

        private TreeNode findNode (int location) {
            if (location == 1) {
                return root;
            }
            TreeNode parent = findNode(location >> 1);
            return (location % 2 == 0 ? parent.left : parent.right);
        }


    }

    class BinarySearchTree extends Tree {

        @Override
        void add(int item) {
            if (root == null) {
                root = new TreeNode(item);
                return;
            }
            _add(root, item);
        }

        private TreeNode _add(TreeNode node, int item) {
            if (node == null) {
                node = new TreeNode(item);
                return node;
            }
            if (item <= node.value) {
                node.left = _add(node.left, item);
            } else {
                node.right = _add(node.right, item);
            }
            return node;
        }

        public TreeNode search(int item) {
            if (root != null) {
                return _search(root, item);
            } else return null;
        }

        private TreeNode _search(TreeNode node, int item) {
            if (node == null) {
                return null;
            }
            if (item == node.value) {
                return node;
            } else if (item < node.value) {
                return _search(node.left, item);
            } else {
                return _search(node.right, item);
            }
        }
    }

}
