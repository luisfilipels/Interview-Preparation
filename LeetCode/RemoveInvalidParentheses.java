package Extras.LeetCode;

import java.util.*;

public class RemoveInvalidParentheses {

    // First answer. Brute force. Doesn't give TLE.
    private static List<String> removeInvalidParentheses (String s) {
        ArrayList<String> returnList = new ArrayList<>();
        helper(s,returnList,new StringBuilder(), 0, 0);
        return returnList;
    }

    /*
    Logically, all the strings in the answer set have the same length, which means that they have the same
    amount of characters removed. If we have to compare two strings by their length to check if they should be
    in the answer list, we will select the one whose countRemoved is smallest (which means that we removed the minimum
    amount of characters needed in order to make the string valid.
     */
    private static int minimumRemoved = Integer.MAX_VALUE;

    // In order to avoid adding duplicates
    private static HashSet<String> isInReturnList = new HashSet<>();

    private static void helper (String s, ArrayList<String> returnList, StringBuilder currentString, int i, int countRemoved) {

        // This means we have removed more characters then we previously found to be necessary, which means we can stop here.
        if (countRemoved > minimumRemoved) {
            return;
        }

        if (i >= s.length()) {
            if (countRemoved <= minimumRemoved) {
                String endString = currentString.toString();
                if (isInReturnList.contains(endString)) {
                    return;
                }
                if (isValid(endString)) {   // We need to check if the string we got is valid. If not, don't add it to the solution.
                    if (countRemoved < minimumRemoved) {
                        minimumRemoved = countRemoved;
                        returnList.clear();     // We found a string that has more characters than the ones we inserted into the solution before, so we clear the solution.
                    }
                    isInReturnList.add(endString);
                    returnList.add(endString);
                }
            }
            return;
        }
        if (s.charAt(i) == '(' || s.charAt(i) == ')') {
            helper(s, returnList, new StringBuilder(currentString).append(s.charAt(i)), i+1, countRemoved); // Didn't remove a character.
            helper(s, returnList, new StringBuilder(currentString), i+1, countRemoved+1);      // Removed a character.
        } else {
            helper(s, returnList, new StringBuilder(currentString).append(s.charAt(i)), i+1, countRemoved);
        }
    }

    // Standard function used to check if a string of parentheses is valid. VERY SLOW in relation to the alternative.
    /*private static boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == ')') {
                if (stack.isEmpty() && c == ')') {
                    return false;
                } else if (c == '(') {
                    stack.add(c);
                } else if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }*/

    // Better function to check if a string of parentheses is valid.
    private static boolean isValid (String s) {
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                counter++;
            } else if (c == ')') {
                counter--;
            }
            if (counter < 0) {
                return false;
            }
        }
        return counter <= 0;
    }

    public static void main(String[] args) {
        String input = "(a)())()";
        System.out.println(removeInvalidParentheses(input));
    }

}
