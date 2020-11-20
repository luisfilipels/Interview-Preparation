import java.util.*;

public class BinaryTreeZigZagLevelOrderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) { this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> returnList = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.add(root);
        boolean inverted = false;
        while (!(stack1.isEmpty() && stack2.isEmpty())) {
            Stack<TreeNode> currentStack;
            Stack<TreeNode> otherStack;

            if (stack1.isEmpty()) {
                currentStack = stack2;
                otherStack = stack1;
            } else {
                currentStack = stack1;
                otherStack = stack2;
            }
            int n = currentStack.size();

            returnList.add(new ArrayList<>());
            int m = returnList.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = currentStack.pop();
                returnList.get(m-1).add(node.val);

                if (!inverted) {
                    if (node.left != null) otherStack.add(node.left);
                    if (node.right != null) otherStack.add(node.right);
                } else {
                    if (node.right != null) otherStack.add(node.right);
                    if (node.left != null) otherStack.add(node.left);
                }
            }
            inverted = !inverted;
        }
        return returnList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(10);

        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(2);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);


        System.out.println(zigzagLevelOrder(root));
    }

}
