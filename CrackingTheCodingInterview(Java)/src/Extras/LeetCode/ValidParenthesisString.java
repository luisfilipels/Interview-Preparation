package Extras.LeetCode;

public class ValidParenthesisString {

    // LeetCode's solution
    private static boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);   // Doesn't allow lo to be less than 0
        }
        return lo == 0;
    }

    // My first solution. Accepted, but is O(3^n)
    /*
    private static boolean checkValidString(String s) {
        return helper(s, 0, 0);
    }

    private static boolean helper (String s, int i, int count) {
        if (i == s.length()) return count == 0;
        if (count < 0) return false;
        switch (s.charAt(i)) {
            case '(':
                return helper(s, i+1, count+1);
            case ')':
                return helper(s, i+1, count-1);
            default:
                return helper(s, i+1, count) || helper(s, i+1, count-1) || helper(s, i+1, count+1);
        }
    }
    */

    public static void main(String[] args) {
        String s = "(*((*())*";
        System.out.println(checkValidString(s));
    }

}
