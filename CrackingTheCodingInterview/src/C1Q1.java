import java.util.Arrays;

public class C1Q1 {

    // Alternative solution. Time: O(log(n)). Space: O(1), if not considering the chars array
    static boolean hasAllUnique (String s) {
        if (s.length() > 128) return false;

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i-1] == chars[i]) {
                return false;
            }
        }
        return true;
    }

    // Other solution. Time: O(n). Space: O(1), as the array size is constant.
    static boolean hasAllUnique2 (String s) {
        if (s.length() > 128) return false;

        int [] count = new int[128];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            if (count[s.charAt(i)] > 1) return false;
        }
        return true;
    }

    // Alternative solution, using bit masking. Assuming chars from 'a' to 'z'.
    static boolean hasAllUnique3 (String s) {
        int bitMask = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentChar = s.charAt(i) - 'a'; // Get the position of the current bit.
            int helper = 1 << currentChar;  // Move the 1 to the correct position
            int currentBit = (bitMask >> currentChar) & 1; // Check if the bit that's currently set at helperPosition is 0
            if (currentBit == 0) {  // If so, then we can set it to 1.
                bitMask = bitMask | helper;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(hasAllUnique3(s));
    }
}
