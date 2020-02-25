package Extras.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinimumWindowSubstring {


    // Second solution. Not perfect, but vastly better!
    private static String minWindow(String s, String t) {
        int left = 0, right = 0;
        HashMap<Character, Integer> countInT = new HashMap<>();
        for (char c : t.toCharArray()) {
            int current = countInT.getOrDefault(c, 0);
            countInT.put(c, current+1);
        }
        HashMap<Character, Integer> countInS = new HashMap<>();

        /*
        This hashset is used to tell if all the letters in T have had their requirement of occurrences in the window met.
        If, for example, s = "AAABCD", and t = "AA", we will insert "A" into requirementsMet when the count of "A"s in
        countInS is greater than or equal to 2. When requirementsMet.size() == countInT.size(), that means that the current
        window has the correct count of letters in t that is to be expected.
         */
        HashSet<Character> requirementsMet = new HashSet<>();
        String returnString = "";
        StringBuilder currentString = new StringBuilder();
        while (left < s.length()) {
            do {
                char charAtRight = s.charAt(right);
                if (countInT.containsKey(charAtRight)) {
                    int currentInS = countInS.getOrDefault(charAtRight, 0);
                    countInS.put(charAtRight, currentInS+1);
                    if (countInS.get(charAtRight) >= countInT.get(charAtRight)) {
                        requirementsMet.add(charAtRight);
                    }
                }
                currentString.append(charAtRight);
                right++;
            } while (right < s.length() && requirementsMet.size() != countInT.size());
            // left < s.length():  To avoid going out of bounds.
            // requirementsMet.size() == countInT.size(): We want to contract the window while the constraints are met.
            // right == s.length(): If right has reached the end, we still want to contract the window.
            while (left < s.length() && ((left < right && requirementsMet.size() == countInT.size()) || right == s.length())) {
                char charAtLeft = s.charAt(left);
                if ((currentString.length() < returnString.length() || returnString.equals("")) && requirementsMet.size() == countInT.size()) {
                    returnString = currentString.toString();
                }
                if (countInT.containsKey(s.charAt(left))) {
                    int currentInS = countInS.getOrDefault(charAtLeft, 0);
                    countInS.put(charAtLeft, currentInS-1);
                    if (countInS.get(charAtLeft) < countInT.get(charAtLeft)) {
                        requirementsMet.remove(charAtLeft);
                    }
                }
                currentString.deleteCharAt(0);
                left++;
            }
        }
        return returnString;

    }

    /*static boolean constraintSatisfied (HashMap<Character, Integer> countT, HashMap<Character, Integer> countS) {
        if (countS.size() != countT.size()) return false;
        for (Map.Entry<Character, Integer> entry : countS.entrySet()) {
            if (entry.getValue() < countT.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }*/

    // First solution. Accepted, but very slow.
    /*private static String minWindow(String s, String t) {
        int left = 0, right = 0;
        HashMap<Character, Integer> countInT = new HashMap<>();
        for (char c : t.toCharArray()) {
            int current = countInT.getOrDefault(c, 0);
            countInT.put(c, current+1);
        }
        HashMap<Character, Integer> countInS = new HashMap<>();
        String returnString = "";
        StringBuilder currentString = new StringBuilder();
        while (left < s.length()) {
            while (right < s.length() && !constraintSatisfied(countInT, countInS)) {
                if (countInT.containsKey(s.charAt(right))) {
                    int currentInS = countInS.getOrDefault(s.charAt(right), 0);
                    countInS.put(s.charAt(right), currentInS+1);
                }
                currentString.append(s.charAt(right));
                right++;
            }
            while (left < s.length() && ((left < right && constraintSatisfied(countInT, countInS)) || right == s.length())) {
                if ((currentString.length() < returnString.length() || returnString.equals("")) && constraintSatisfied(countInT, countInS)) {
                    returnString = currentString.toString();
                }
                if (countInT.containsKey(s.charAt(left))) {
                    int currentInS = countInS.getOrDefault(s.charAt(left), 0);
                    countInS.put(s.charAt(left), currentInS-1);
                }
                currentString.deleteCharAt(0);
                left++;
            }
        }
        return returnString;

    }*/

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

}
