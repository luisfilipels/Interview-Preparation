package Extras.LeetCode;

import java.util.HashMap;

public class SubarraySumEqualsK {

    /*

    Take the following input to better understand what's going on:

    sum:   3 7 14 16 13 14 18 20
    input: 3 4  7  2 -3  1  4  2
    index: 0 1  2  3  4  5  6  7

    Does the interval from 5..7 sum to 7? We can find out by seeing if the sum from 0..7 - the sum from 5..7 equals k. Why?
              sum = 13      sum = 20 - 13 = 7
           ____________           ________
    sum:   3 7 14 16 13           14 18 20
    input: 3 4  7  2 -3            1  4  2
    index: 0 1  2  3  4            5  6  7

     */

    private static int subarraySum (int [] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();   // Key: Value of sum. Value: Number of times the key has been found.
        int currentSum = 0; // For a cumulative sum
        hash.put(0, 1); // Needed in cases like nums = {3, 1, 2}, and k = 6, as for i = 2, currentSum - k = 0.
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (hash.containsKey(currentSum - k)) {
                count += hash.get(currentSum - k);
            }
            hash.put(currentSum, hash.getOrDefault(currentSum, 0) + 1); // Put the current sum in the hashmap, as it is a value of a sum. Needed in cases that have negative integers in the array.
        }
        return count;
    }

    /*
    // Brute force solution. O(n²) time, O(1) space.
    private static int subarraySum (int [] nums, int k) {
        int currentSum;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum == k) {
                    count++;
                }
            }
        }
        return count;
    }*/

    public static void main(String[] args) {
        int [] input = new int[] {1, 1, 1};
        System.out.println(subarraySum(input, 4));
    }

}
