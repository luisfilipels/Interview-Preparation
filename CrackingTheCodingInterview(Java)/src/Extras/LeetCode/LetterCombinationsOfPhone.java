package Extras.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhone {

    static HashMap<Character, char[]> map = new HashMap<>();
    static List<String> returnList = new ArrayList<>();

    private static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return returnList;
        }
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        helper(digits, 0, new StringBuilder());
        return returnList;

    }

    private static void helper (String digits, int currentIndex, StringBuilder currentString) {
        if (currentString.length() == digits.length()) {
            returnList.add(currentString.toString());
            return;
        }
        char [] currentLetterMap = map.get(digits.charAt(currentIndex));
        for (char c : currentLetterMap) {
            StringBuilder newSB = new StringBuilder(currentString);
            newSB.append(c);
            helper(digits, currentIndex+1, newSB);
        }
    }


    public static void main(String[] args) {
        String input = "23";
        System.out.println(letterCombinations(input));
    }

}
