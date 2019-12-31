package Extras.LeetCode;

import java.util.Stack;

public class LargestRectangleInHistogram {

    /*
    Easier than it seems!
    https://www.youtube.com/watch?v=MhQPpAoZbMc
    */
    private static int largestRectangleArea (int [] heights) {
        if (heights.length == 0) {
            return 0;
        } else if (heights.length == 1) {
            return heights[0];
        }
        int n = heights.length;
        int returnArea = 0;
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < n) {
            if (stack.empty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int currentBar = stack.pop();
                int right = i;
                int currentArea;
                if (stack.empty()) {
                    currentArea = heights[currentBar] * right;
                } else {
                    int left = stack.peek();
                    currentArea = heights[currentBar] * (right - left - 1);
                }
                returnArea = Math.max(returnArea, currentArea);
            }
        }
        while (!stack.empty()) {
            int currentBar = stack.pop();
            int right = i;
            int currentArea;
            if (stack.empty()) {
                currentArea = heights[currentBar] * right;
            } else {
                int left = stack.peek();
                currentArea = heights[currentBar] * (right - left - 1);
            }
            returnArea = Math.max(returnArea, currentArea);
        }
        return returnArea;
    }

    public static void main(String[] args) {
        int [] hist = new int[] {2, 1, 5, 6, 2, 3};
        //int [] hist = new int[] {0, 0};
        System.out.println(largestRectangleArea(hist));
    }

}
