package Extras.HackerRank;

import java.util.Stack;

public class LargestRectangle {

    static long largestRectangle (int[] h) {
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        int i = 0;
        int n = h.length;

        while (i < n) {
            int heightAtI = h[i];
            if (stack.isEmpty() || h[stack.peek()] <= heightAtI) {
                stack.push(i++);
            } else {
                int currentBuilding = stack.pop();
                int right = i;
                if (stack.isEmpty()) {
                    maxArea = Math.max(maxArea, h[currentBuilding] * right);
                } else {
                    int left = stack.peek();
                    maxArea = Math.max(maxArea, h[currentBuilding] * (right - left - 1));
                }
            }
        }

        while (!stack.isEmpty()) {
            int currentBuilding = stack.pop();
            int right = i;
            if (stack.isEmpty()) {
                maxArea = Math.max(maxArea, h[currentBuilding] * right);
            } else {
                int left = stack.peek();
                maxArea = Math.max(maxArea, h[currentBuilding] * (right - left - 1));
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int [] input = new int[] {
                1,2,3,4,5
        };
        System.out.println(largestRectangle(input));
    }
}
