package Extras.LeetCode;

import java.util.Stack;

public class TrappingRainWater {

    private static int trap (int [] height) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int i = 0;
        int volume = 0;
        while (i < n) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int bounded_height = Math.min(height[i], height[stack.peek()]) - height[top];
                volume += distance * bounded_height;
            }
            stack.push(i++);
        }

        return volume;
    }

    /*
    My attempt without any help. Got somewhat close.
    private static int trap (int [] height) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int i = 0;
        int volume = 0;
        while (i < n) {
            if (stack.empty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int rightHeight = height[i];
                int right = i;
                int levelIndex = stack.pop();
                int left = 0;
                while (!stack.empty() && height[levelIndex] < height[stack.peek()]) {
                    if (height[stack.peek()] > height[levelIndex]) {
                        left = stack.peek();
                        break;
                    }
                    stack.pop();
                }
                int currHeight = Math.min(height[left], rightHeight) - height[levelIndex];
                volume += (right - left - 1) * currHeight;
                //if (!stack.empty() && height[stack.peek()] )
            }
        return volume;
     }
     */

    public static void main(String[] args) {
        //int [] input = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        //int [] input = new int[] {3, 0, 3};
        int [] input = new int[] {2, 1, 0, 2};
        System.out.println(trap(input));
    }

}
