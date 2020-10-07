public class LongestZigZag {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }

        TreeNode () {}
    }

    private static int longestZigZag (TreeNode root) {
        return longestZigZag(root, null, 0, 0);
    }

    private static int longestZigZag (TreeNode root, Character lastCall, int currentDist, int maxDist) {
        if (root == null) return currentDist-1;

        maxDist = Math.max(currentDist, maxDist);

        if (lastCall == null) {
            int left = longestZigZag(root.left, 'l', currentDist+1, maxDist);
            int right = longestZigZag(root.right, 'r', currentDist+1, maxDist);
            return Math.max(left, right);
        } else if (lastCall == 'l'){
            int left = longestZigZag(root.left, 'l', 1, maxDist);
            int right = longestZigZag(root.right, 'r', currentDist+1, maxDist);
            return Math.max(left, right);
        } else {
            int left = longestZigZag(root.left, 'l', currentDist+1, maxDist);
            int right = longestZigZag(root.right, 'r', 1, maxDist);
            return Math.max(left, right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.left = new TreeNode();
        root.right = new TreeNode();
        root.left.right = new TreeNode();

        root.right.left = new TreeNode();
        root.right.right = new TreeNode();
        root.right.right.right = new TreeNode();
        root.right.right.left = new TreeNode();
        root.right.right.left.right = new TreeNode();
        root.right.right.left.right.right = new TreeNode();

        /*root.left.right.left = new TreeNode();
        root.left.right.right = new TreeNode();
        root.left.right.left.right = new TreeNode();*/

        System.out.println(longestZigZag(root));
    }

}
