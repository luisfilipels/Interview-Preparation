import java.util.HashMap;

public class LengthOfLongestSubstringWithAtMostKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int i = 0, j = 0;
        HashMap<Character, Integer> count = new HashMap<>();

        int n = s.length();
        int maxLength = 0;

        for (i = 0; i < n; i++) {
            char current;
            while (j < n && count.size() <= k) {
                current = s.charAt(j);
                count.put(current, count.getOrDefault(current, 0) + 1);
                if (count.size() <= k) maxLength = Math.max(maxLength, j - i + 1);
                j++;
            }
            current = s.charAt(i);
            count.put(current, count.get(current) - 1);
            if (count.get(current) == 0) count.remove(current);
        }

        return maxLength;
    }

}
