package Extras.LeetCode;

public class RegularExpressionMatching {

    // https://www.youtube.com/watch?v=bSdw9rJYf-I

    private static boolean isMatch (String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        boolean firstMatch = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "a*b";
        System.out.println(isMatch(s, p));
    }

}
