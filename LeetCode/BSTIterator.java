import java.util.Stack;

public class BSTIterator {

    static public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }


    // Basically, we do an iterative in-order traversal and return a value every time we pop a node from
    // the stack
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    public int next() {
        TreeNode returnNode = stack.pop();
        if (returnNode.right != null) {
            TreeNode current = returnNode.right;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }
        return returnNode.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
