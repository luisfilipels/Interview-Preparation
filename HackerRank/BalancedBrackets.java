package Extras.HackerRank;

import java.util.Stack;

public class BalancedBrackets {

    static char getOpposite(char bracket) {
        if (bracket == '(') return ')';
        if (bracket == '[') return ']';
        if (bracket == '{') return '}';
        return '*';
    }

    static boolean isStart (char bracket) {
        if (bracket == '(' || bracket == '[' || bracket == '{') return true;
        return false;
    }

    static String isBalanced (String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (stack.isEmpty()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    return "NO";
                }
            } else {
                char lastChar = stack.peek();
                char expected = getOpposite(lastChar);
                if (c == expected) {
                    stack.pop();
                } else {
                    if (isStart(c)) {
                        stack.push(c);
                    } else {
                        return "NO";
                    }
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[(])}"));
    }

}
