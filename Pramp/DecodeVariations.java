package Extras.Pramp;

public class DecodeVariations {

    /*
    This one is remarkably simple once you've gone through some test cases with pen and paper, at least it is for the
    bottom-up DP approach. Let's start by looking at a small test case:

    index  =   0
    String = " 1 "

    In how many ways can we interpret that string? Logically, only in one way. What about this case?

    index  =   0 1
    String = " 1 2"

    We can either interpret it as ['1' '2'], or, as ['12'], so that makes it 2. Let's look at a bigger test case, and,
    with that, let's see in how many ways we can interpret the input from index 0, going to the current character.

    index  =   0 1 2
    String =  "2 2 2"
    ways =     1 2 x

    What's the value of x? Well, we can interpret the string as ['2' '2' '2'], ['22' '2'] or ['2' '22'], so that makes it three.
    What if the last character were an 8? If that were the case, then we would have ['2' '2' '8'] and ['22' '8']. Notice that,
    in case the number formed from positions i and i-1 is greater than 26, the number of ways that we can interpret
    the the string up to index i is the same as it is till i-1. What about this?

    index  =   0 1 2 3
    String =  "1 2 1 2"
    ways =     1 2 3 5

    Notice anything about the progression of ways? Position i has the number of ways equal to ways[i-1] + ways[i-2]!

    DOESN'T WORK FOR SOME STRINGS THAT HAVE ZEROES! DECODE WAYS ON LEETCODE IS CORRECT.

     */

    static int decodeVariations (String S) {
        int n = S.length();
        if (n == 0) return 0;
        if (n == 1) return 1;
        int [] dp = new int[n];
        dp[0] = 1;
        String firstTwo = "" + S.charAt(0) + S.charAt(1);
        dp[1] = Integer.parseInt(firstTwo) <= 26 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            String prevStr = "" + S.charAt(i-1) + S.charAt(i);
            if (Integer.parseInt(prevStr) <= 26) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    }

    // Brute force solution
    /*static int decodeVariations(String S) {
        return helper(S, 0);
    }

    static int helper (String s, int idx) {
        if (idx == s.length()) {
            return 1;
        }

        int current = 0;

        if (idx != s.length()-1) {
            String considerTwo = "" + s.charAt(idx) + s.charAt(idx+1);
            if (Integer.parseInt(considerTwo) <= 26) {
                current += helper(s, idx+2);
            }
        }
        current += helper(s, idx+1);
        return current;
    }*/

    public static void main(String[] args) {
        String input = "321121311231";
        System.out.println(decodeVariations(input));
    }

}
