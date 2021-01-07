public class HouseRobberII {

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        return Math.max(rob(nums, 0, n-1), rob(nums, 1, n));
    }

    static int rob(int[] nums, int start, int end) {
        if (end - start == 0) return nums[start];
        if (end - start == 1) return Math.max(nums[start], nums[end-1]);

        int take = nums[start];
        int notTake = 0;

        for (int i = start+1; i < end; i++) {
            int bkpTake = take;

            take = Math.max(nums[i], notTake + nums[i]);
            notTake = Math.max(bkpTake, notTake);
        }

        return Math.max(take, notTake);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[] {2, 3}));
    }

}
