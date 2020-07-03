package Extras.LeetCode;

public class EditDistance {

    // https://www.youtube.com/watch?v=MiqoA-yF-0M&lc=z23oz3n4gvvve1welacdp43avyc40f2n5d3lkrdolktw03c010c.1582572166445973
    private static int minDistance (String word1, String word2) {
        word1 = " " + word1;
        word2 = " " + word2;
        int [][] dp = new int[word2.length()][word1.length()];
        for (int l = 0; l < word2.length(); l++) {
            dp[l][0] = l;
        }
        for (int c = 0; c < word1.length(); c++) {
            dp[0][c] = c;
        }
        for (int w2 = 1; w2 < word2.length(); w2++) {
            for (int w1 = 1; w1 < word1.length(); w1++) {
                if (word1.charAt(w1) == word2.charAt(w2)) {
                    dp[w2][w1] = dp[w2-1][w1-1];
                } else {
                    dp[w2][w1] = Math.min(Math.min(dp[w2-1][w1], dp[w2-1][w1-1]), dp[w2][w1-1]) + 1;
                }
            }
        }
        return dp[word2.length()-1][word1.length()-1];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1,word2));
    }

}
