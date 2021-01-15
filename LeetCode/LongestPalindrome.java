public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int n = s.length();

        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int result = 0;
        for (int x : count) {
            result += (x/2) * 2;
            if (result % 2 == 0 && x % 2 == 1) result++;
        }

        return result;
    }

}
