package Extras.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    //https://leetcode.com/problems/word-break/discuss/44054/Java-DP-solution

    static private boolean wordBreak (String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;                     //0123456789

        int n = s.length();

        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);

                if (wordDict.contains(sub) && (j == 0 || dp[j - 1] == true)) { //dp[j-1]==true when the previous word, ended at j-1, is in the string.
                    dp[i] = true;   // The substring that starts at 0 and ends at i is in the string s.
                    break;
                }
            }
        }

        return dp[n - 1];
    }

    /*
    // My brute force solution. Exceeds time limit.
    static private boolean wordBreak (String s, List<String> wordDict) {
        return helper(s, wordDict, new StringBuilder());
    }

    static boolean helper (String s, List<String> wordDict, StringBuilder currentString) {
        if (currentString.toString().equals(s)) {
            return true;
        } else if (currentString.toString().length() > s.length()) {
            return false;
        }
        boolean soFar = false;
        for (String word : wordDict) {
            StringBuilder newSB = new StringBuilder(currentString);
            newSB.append(word);
            soFar |= helper(s, wordDict, newSB);
        }
        return soFar;
    }
    */

    public static void main(String[] args) {
        String s = "catsanddog";
        ArrayList<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("cat");
        System.out.println(wordBreak(s, wordDict));
    }

}
