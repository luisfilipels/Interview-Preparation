package Extras.InterviewBit;

import java.util.Stack;

public class RedundantBraces {

    private static int braces(String A) {
        char [] s = A.toCharArray();
        Stack<Character> stackBraces = new Stack<>();
        Stack<Character> stackOperators = new Stack<>();
        Stack<Character> stackLast = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') {
                stackBraces.add(s[i]);
                stackLast.add(s[i]);
            } else if (s[i] == '+' || s[i] == '-' || s[i] == '*' || s[i] == '/') {
                stackOperators.add(s[i]);
                stackLast.add(s[i]);
            } else if (s[i] == ')'){
                if (stackLast.peek() == '(') {
                    return 1;
                }
                try {
                    stackBraces.pop();
                    stackOperators.pop();
                } catch (Exception e) {
                    return 1;
                }
            }
        }
        if (stackBraces.empty()) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        //String A = "(a*b)+(b*(d+(a)))"; // 1
        //String A = "((a+b)+(b+a))"; // 0
        //String A = "(a+(a+b))"; // 0
        //String A = "((a+b))"; // 1
        //String A = "(a)"; // 1
        //String A = "a+b"; // 0
        String A = "a";
        System.out.println(braces(A));
    }
}
