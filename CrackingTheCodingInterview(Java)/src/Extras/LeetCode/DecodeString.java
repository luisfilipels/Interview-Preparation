package Extras.LeetCode;

import java.util.Stack;

public class DecodeString {

    static class Tuple {
        Integer left;
        StringBuilder right;
        Tuple(int l, StringBuilder r) {
            left = l;
            right = r;
        }
    }

    static private String decodeString (String s) {
        Stack<Tuple> stack = new Stack<>();
        stack.push(new Tuple(1, new StringBuilder()));
        for (int i = 0; i < s.length(); i++) {
            StringBuilder temp = new StringBuilder();
            if (Character.isDigit(s.charAt(i))) {
                while (Character.isDigit(s.charAt(i))) {
                    temp.append(s.charAt(i++));
                }
                stack.push(new Tuple(Integer.parseInt(temp.toString()), new StringBuilder()));
            } else if (s.charAt(i) == ']') {
                Tuple pop = stack.pop();
                int times = pop.left;
                StringBuilder string = pop.right;
                for (int j = 0; j < times; j++) {
                    stack.peek().right.append(string);
                }
            } else {
                stack.peek().right.append(s.charAt(i));
            }
        }
        return stack.peek().right.toString();
    }

    // Wrong answer, only works if not nested.
    /*static private String decodeString (String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int number = -1;
        while (i < s.length()) {
            StringBuilder builder = new StringBuilder();
            if (Character.isDigit(s.charAt(i))) {
                while (Character.isDigit(s.charAt(i))) {
                    builder.append(s.charAt(i));
                    i++;
                }
                number = Integer.parseInt(builder.toString());
                builder.setLength(0);
            } else if (Character.isLetter(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
                i++;
            } else {
                i++;
                while (s.charAt(i) != ']') {
                    builder.append(s.charAt(i));
                    i++;
                }
                i++;
                for (int j = 0; j < number; j++) {
                    stringBuilder.append(builder);
                }
            }
        }
        return stringBuilder.toString();
    }*/

    public static void main(String[] args) {
        String input = "3[a]2[bc]";
        System.out.println(decodeString(input));
    }

}