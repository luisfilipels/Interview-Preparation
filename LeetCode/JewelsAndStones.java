import java.util.HashMap;
import java.util.HashSet;

public class JewelsAndStones {

    // Not the fastest answer, however, asymptotically, it's better than the fastest answer.
    private static int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet<>();

        char[] arr = J.toCharArray();
        for (char c : arr) {
            jewels.add(c);
        }

        arr = S.toCharArray();
        int count = 0;
        for (char c : arr) {
            if (jewels.contains(c)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

}
