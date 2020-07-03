package Extras.LeetCode;

public class PalindromicSubstrings {

    static int countSubstrings (String S) {
        int N = S.length(), ans = 0;
        for (int current = 0; current <= 2*N-1; ++current) {
            int left = current / 2;
            int right = left + current % 2; // Quando sobra 1, estamos olhando entre uma letra e outra.
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ananaanana";
        System.out.println(countSubstrings(s));
    }

}
