package Extras.LeetCode;

public class LongestPalindromicSubstring {

    private static String longestPalindrome (String s) {

        /*
        A string is palindromic if it can be "mirrored". E.g.:

        ba -> no
        aa -> yes
        aaa -> yes
        aba -> yes
        baa -> no

        Notice that the center of a palindrome can be at a character, or between two characters. Thus, simply going through
        the string, character by character may not be enough to find the largest palindrome. If we follow this (bad) logic
        through the string "baab", we will find that the largest palindrome is the string "b", when in reality, it is "baab".
        To solve this, consider the following string:

        "babad"

        We can split it in the following manner:

        real index:     0   1   2   3   4
        string:         b   a   b   a   d
        center index:   0 1 2 3 4 5 6 7 8

        By splitting the string in this manner and analyzing where each center index is, we see that if center index is even,
        the center of the palindrome is at a character, and if it is odd, then it is between two characters. With this, we can
        go through each center index, and expand the string to the left and to the right until either our left or right pointer is out
        of bounds, or until the character which they represent is different from one another. When this happens, we check if
        the size of this substring is greater than the size of the greatest substring we have found so far, and if so, we
        attribute the returnString to this new substring.

         */

        if (s.length() == 1) {
            return s;
        }
        String returnString = "";
        for (int mid = 1; mid < s.length() * 2 - 1; mid++) {
            int i, j;
            if (mid % 2 == 0) {
                i = (mid / 2) - 1;
                j = (mid / 2);
                int currentSize = 2;
                while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                    i--;
                    j++;
                    currentSize += 2;
                }
                if (currentSize - 2 > returnString.length()) {
                    returnString = s.substring(i+1, j);
                }
            } else {
                i = j = mid / 2;
                int currentSize = 1;
                while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                    i--;
                    j++;
                    currentSize += 2;
                }
                if (currentSize - 2 > returnString.length()) {
                    returnString = s.substring(i+1, j);
                }
            }
        }
        return returnString;
    }

    public static void main(String[] args) {
        String input = "babad";
        System.out.println(longestPalindrome(input));
    }

}
