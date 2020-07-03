import java.util.Arrays;

public class C1Q2 {
    /*public static void main(String[] args) {
        String input1 = "abcdef";
        String input2 = "zzz";

        int [] conta = new int[26];

        for (int i = 0 ; i < input1.length(); i++) {
            conta[input1.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < input2.length(); i++) {
            conta[input2.charAt(i) - 'a'] -= 1;
        }
        for (int i : conta) {
            if (i != 0) {
                System.out.println("Not a permutation!");
                return;
            }
        }
        System.out.println("Permutation!");

    }*/

    // Alternative solution, using sorting. Time: O(log(n))
    boolean checkIsPermutation (String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char [] s1Sorted = s1.toCharArray();
        char [] s2Sorted = s2.toCharArray();

        Arrays.sort(s1Sorted);
        Arrays.sort(s2Sorted);

        return Arrays.equals(s1Sorted, s2Sorted);
    }

    // Counting occurrences. Time: O(n)
    boolean checkIsPermutation2 (String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int [] count = new int[128];

        int n = s1.length();

        for (int i = 0; i < n; i++) {
            count[s1.charAt(i)]++;
        }

        for (int i = 0; i < n; i++) {
            count[s2.charAt(i)]--;

            if (count[s2.charAt(i)] != 0) return false;
        }
        return true;
    }
}
