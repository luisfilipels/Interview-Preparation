import java.util.Arrays;

public class CombinationSumIV {

    // This is almost like the coin change problem with infinite coins.
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            int result = 0;
            for (int val : nums) {
                if (i - val >= 0) {
                    result += dp[i - val];
                } else break;
            }
            dp[i] = result;
        }

        return dp[target];
    }

}
