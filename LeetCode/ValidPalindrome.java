public class ValidPalindrome {

    static boolean isAlphanumeric (char c) {
        return Character.isDigit(c) || Character.isAlphabetic(c);
    }

    public static boolean isPalindrome (String s) {
        if (s.equals("")) return true;
        int n = s.length();
        int left = 0, right = n-1;

        while (left < right) {
            while (left < n && !isAlphanumeric(s.charAt(left))) left++;
            while (right >= 0 && !isAlphanumeric(s.charAt(right))) right--;
            if (left < n && right >= 0 && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "as bws a";
        System.out.println(isPalindrome(s));
    }

}
