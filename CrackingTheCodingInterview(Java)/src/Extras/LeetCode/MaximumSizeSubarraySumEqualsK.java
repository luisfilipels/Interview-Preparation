package Extras.LeetCode;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsK {

    static int maxSubArrayLen(int [] nums, int k) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] == k ? 1 : 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(k, -1);
        int current = 0;
        int response = 0;
        for (int i = 0; i < nums.length; i++) {
            current += nums[i];
            if (hash.containsKey(current)) {
                response = Math.max(response, i - hash.get(current));
            }
            hash.putIfAbsent(current + k, i);
        }
        return response;
    }

    public static void main(String[] args) {
        int [] ints = new int[] {1, 2, 0, -1, 7, 3, -3, -2, 2, 3, 4};
        System.out.println(maxSubArrayLen(ints, 0));
    }

}
