package Extras.LeetCode;

import java.util.HashSet;

public class LongestSubstringWoutRepChars {

    private static int lengthOfLongestSubstring (String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int left = 0, right = 0;
        int answer = 0;
        HashSet<Character> inSubstring = new HashSet<>();
        while (right < s.length()) {
            if (!inSubstring.contains(s.charAt(right))) {
                inSubstring.add(s.charAt(right));
                right++;
                answer = Math.max(answer, right - left);
            } else {
                inSubstring.remove(s.charAt(left));
                left++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String input = "bbbbb";
        System.out.println(lengthOfLongestSubstring(input));
    }


}
