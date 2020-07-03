package Extras.LeetCode;

import java.util.Stack;

public class DecodeString {

    /*static class Tuple {
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
    }*/


    // New solution. Virtually identical to previous one.
    static class Tuple {
        int amount;
        StringBuilder contents;

        Tuple (int amount, StringBuilder contents) {
            this.amount = amount;
            this.contents = contents;
        }
    }

    static String decodeString (String s) {
        Stack<Tuple> stack = new Stack<>();
        stack.push(new Tuple(1, new StringBuilder()));
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder temp = new StringBuilder();
                while (Character.isDigit(s.charAt(i))) {
                    temp.append(s.charAt(i));
                    i++;
                }
                int amount = Integer.parseInt(temp.toString());
                stack.push(new Tuple(amount, new StringBuilder()));
            } else {
                if (s.charAt(i) == ']') {
                    Tuple popped = stack.pop();
                    for (int j = 0; j < popped.amount; j++) {
                        stack.peek().contents.append(popped.contents);
                    }
                } else {
                    stack.peek().contents.append(s.charAt(i));
                }
            }
        }
        return stack.pop().contents.toString();
    }

    public static void main(String[] args) {
        String input = "3[a]2[bc]";
        System.out.println(decodeString(input));
    }

}
