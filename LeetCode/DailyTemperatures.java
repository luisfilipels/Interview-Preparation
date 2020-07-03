package Extras.LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    static private int[] dailyTemperatures(int[] T) {
        Stack<int[]> stack = new Stack<>();
        int [] returnArray = new int[T.length];
        stack.push(new int[] {T[0], 0});
        for (int i = 1; i < T.length; i++) {
            if (T[i] <= stack.peek()[0]) {
                stack.push(new int[] {T[i], i});
            } else if (T[i] > stack.peek()[0]) {
                while (!stack.empty() && T[i] > stack.peek()[0]) {
                    int popIndex = stack.pop()[1];
                    returnArray[popIndex] = i - popIndex;
                }
                stack.push(new int[] {T[i], i});
            }
            if (stack.empty()) {
                stack.push(new int[] {T[i], i});
            }
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int [] temp = new int[] {55,38,53,81,61,93,97,32,43,78};
        //int [] temp = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }

}
