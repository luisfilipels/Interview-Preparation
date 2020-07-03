package Extras.LeetCode;

import java.util.Arrays;

public class JumpGame {

    // The best solution given by LeetCode. Try simulating it, and you'll see it's quite easy to understand why it's correct.
    /*
    private static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }*/

    // My third implementation. Works similarly to my previous one, but is not recursive and uses only O(n) space.
    enum Possibilities {
        possible, impossible, unknown
    }

    static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        Possibilities[] dp = new Possibilities[nums.length];
        Arrays.fill(dp, Possibilities.unknown);
        int n = nums.length;
        dp[n-1] = nums[n-1] == 0 ? Possibilities.possible : Possibilities.impossible;
        for (int i = n-2; i >= 0; i--) {
            if (nums[i] == 0) dp[i] = Possibilities.impossible;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= n-1) {
                    dp[i] = Possibilities.possible;
                    break;
                }
                if (dp[i+j] == Possibilities.possible) {
                    dp[i] = Possibilities.possible;
                }
            }
            if (dp[i] != Possibilities.possible) {
                dp[i] = Possibilities.impossible;
            }
        }
        return dp[0] == Possibilities.possible ? true : false;
    }

    // My second implementation. For each position in the nums array, it is either possible or impossible to, starting
    // from said position, reach the last element in the array, or exceed it. We simply memoize the result from previous
    // iterations, and that grants an increase in performance.

    /*enum Index {
        possible, impossible, unknown
    }

    private static Index canJumpFromIndex (int [] nums, int cur) {
        if (cur >= nums.length-1) {
            return Index.possible;
        }
        if (dp[cur] != Index.unknown) {
            return dp[cur];
        }
        if (nums[cur] == 0) {
            dp[cur] = Index.impossible;
            return Index.impossible;
        }
        for (int i = nums[cur]; i > 0; i--) {
            dp[cur] = canJumpFromIndex(nums, cur + i);
            if (dp[cur] == Index.possible) return Index.possible;
        }
        return Index.impossible;
    }

    static Index [] dp;

    private static boolean canJump (int [] nums) {
        if (nums.length == 1) {
            return true;
        }
        dp = new Index[nums.length+1];
        Arrays.fill(dp, Index.unknown);
        canJumpFromIndex(nums,0);
        return dp[0] == Index.possible;
    }*/

    // My first implementation. Time limit exceeds at the last case.
    /*private static boolean canJump (int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        do {
            if (nums[current] == 0) {
                if (stack.isEmpty()) {
                    return false;
                }
                current = stack.peek();
            } else {
                stack.push(current);
            }
            int currentJump = nums[current];
            if (nums[current] > 0) {
                nums[current]--;
            }
            if (nums[current] == 0) stack.pop();
            current += currentJump;
            if (stack.isEmpty() && nums[current] > 0) {
                stack.push(current);
            }
            if (current >= nums.length - 1) return true;
        } while (!stack.empty());
        return false;
    }*/

    public static void main(String[] args) {
        int [] input = new int[] {0};
        System.out.println(canJump(input));
    }

}
