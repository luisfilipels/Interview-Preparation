public class SplitTwoStringsToMakePalindrome {

    public boolean checkPalindromeFormation(String a, String b) {
        if (partition(a, b)) return true;
        if (partition(b, a)) return true;
        return false;
    }

    boolean partition (String a, String b) {

        int left = 0, right = a.length()-1;

        while (left < right) {
            if (a.charAt(left) != b.charAt(right)) {
                return palindrome(b, left, right) || palindrome(a, left, right);
            }
            left++;
            right--;
        }

        return true;
    }

    boolean palindrome (String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

}
