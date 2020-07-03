package Extras.LeetCode;

import java.util.*;

public class SlidingWindowMaximum {

    // Thanks to: https://www.youtube.com/watch?v=fbkvdWUS5Ic

    private static int[] maxSlidingWindow (int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int [] returnArray = new int[nums.length - k + 1];

        int i = 0;
        while (i < nums.length) {
            if (!queue.isEmpty() && queue.peekFirst() == i - k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);

            if (i >= k - 1) {
                returnArray[i - k + 1] = nums[queue.peekFirst()];
            }
            i++;
        }

        return returnArray;

    }

    public static void main(String[] args) {
        int [] nums = new int[] {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }

}
