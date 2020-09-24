public class ConvertSortedArrayToBST {
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

    private static TreeNode sortedArrayToBST (int [] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private static TreeNode helper (int [] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right)/2;
        TreeNode returnNode = new TreeNode(nums[mid]);
        returnNode.left = helper(nums, left, mid-1);
        returnNode.right = helper(nums, mid+1, right);

        return returnNode;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {0, 1, 2, 3, 4, 5};
        TreeNode root = sortedArrayToBST(arr);
        System.out.println(root.val);
    }
}
