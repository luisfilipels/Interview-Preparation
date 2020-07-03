package Extras.LeetCode;

public class ValidateBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    // Although the algorithm is essentialy the same, I believe this implementation is easier to understand.
    // Thanks to Kevin Naughton Jr. https://www.youtube.com/watch?v=Z_-h_mpDmeg
    // Tushar Roy explains the logic behind it in a slightly better way (although LeetCode forcefully won't accept his solution)
    // https://www.youtube.com/watch?v=MILxfAbIhrE&t=37s

    private static boolean isValidBST(TreeNode root) {
        return validate (root, null, null);
    }

    private static boolean validate (TreeNode root, Integer min, Integer max) {

        if(root == null){
            return true;
        }
        int val = root.val;
        if ((min != null && val <= min) || (max != null && val >= max)) return false;

        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }


    /*
    private static boolean isValidBST (TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode root, Integer lowEnd, Integer upperEnd) {
        if (root == null) return true;

        int val = root.val;
        if (lowEnd != null && val <= lowEnd) return false;
        if (upperEnd != null && val >= upperEnd) return false;

        if (! isValidBST(root.right, val, upperEnd)) return false;
        if (! isValidBST(root.left, lowEnd, val)) return false;
        return true;
    }
    */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);*/
        System.out.println(isValidBST(root));
    }

}
