package Extras.LeetCode;

import java.util.Stack;

public class LongestValidParentheses {

    private static int longestValidParentheses (String s) {
        // From LeetCode. Didn't make sense? Try cases such as (()), ((() or )))()
        Stack<Integer> stack = new Stack<>();
        int returnLength = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    returnLength = Math.max(returnLength, i - stack.peek());
                }
            }
        }
        return returnLength;
    }

    public static void main(String[] args) {
        String input = "(()(((()";
        System.out.println(longestValidParentheses(input));
    }

}
