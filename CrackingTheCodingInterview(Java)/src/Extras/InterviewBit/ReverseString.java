package Extras.InterviewBit;

import java.util.Stack;

public class ReverseString {

    public static String reverseString(String A) {
        Stack <Character> stack = new Stack<>();
        for (char c : A.toCharArray()) {
            stack.add(c);
        }
        String returnString = "";
        while (!stack.empty()) {
            returnString += stack.pop();
        }
        return returnString;

    }

    public static void main(String[] args) {
        String A = "abcd";
        A = reverseString(A);
        System.out.println(A);
    }
}
