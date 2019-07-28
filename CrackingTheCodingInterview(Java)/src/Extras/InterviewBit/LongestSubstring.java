package Extras.InterviewBit;

import java.util.HashSet;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String A) {

        if (A.length() <= 1) {
            return 1;
        }

        char [] array = A.toCharArray();
        HashSet<Character> hashSet = new HashSet<>();
        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (!hashSet.contains(array[j])) {
                    hashSet.add(array[j]);
                    maxLength = Math.max(++currentLength, maxLength);
                } else {
                    hashSet.clear();
                    currentLength = 0;
                    break;
                }
            }
        }
        return maxLength;

    }

    public static void main(String[] args) {
        String string = "abcddeabcvzbb";
        System.out.println(lengthOfLongestSubstring(string));
    }
}
