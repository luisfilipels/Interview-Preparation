package Extras.InterviewBit;

import java.util.Stack;

public class GenerateAllParentheses {

    private static char opositeOf(char c) {
        if (c == '(') return ')';
        if (c == '[') return ']';
        if (c == '{') return '}';
        if (c == ')') return '(';
        if (c == ']') return '[';
        if (c == '}') return '{';
        return 'a';
    }

    public static int isValid(String A) {
        Stack<Character> stack = new Stack<>();
        for (char c : A.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.add(c);
            } else if (c == '}' || c == ')' || c == ']') {
                try {
                    if (stack.peek() == opositeOf(c)) {
                        stack.pop();
                    } else return 0;
                } catch (Exception e) {
                    return 0;
                }

            }
        }
        if (stack.empty()) return 1;
        return 0;
    }

    public static void main(String[] args) {
        String A = "";
        System.out.println(isValid(A));
    }

}
