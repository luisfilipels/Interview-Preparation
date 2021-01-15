public class ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n == k) return true;
        if (k > n) return false;

        int [] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int countOdds = 0;
        for (int x : count) {
            if (x % 2 != 0) countOdds++;
        }

        if (countOdds > k) return false;
        return true;
    }
}
