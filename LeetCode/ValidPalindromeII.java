public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        final int n = s.length();

        int left = 0, right = n-1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                boolean removeLeft = helper(s, left+1, right);
                boolean removeRight = helper(s, left, right-1);

                return removeLeft || removeRight;
            }
            left++;
            right--;
        }

        return true;
    }

    boolean helper(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

}
