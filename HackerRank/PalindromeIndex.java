public class PalindromeIndex {

    static boolean helper (String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    static int palindromeIndex(String s) {
        int n = s.length();
        int left = 0, right = n-1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                boolean removeLeft = helper(s, left+1, right);
                boolean removeRight = helper(s, left, right-1);

                if (removeLeft) return left;
                if (removeRight) return right;
                return -1;
            }
            left++;
            right--;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(palindromeIndex("bcbc"));
        System.out.println(palindromeIndex("aaab"));
        System.out.println(palindromeIndex("baa"));
        System.out.println(palindromeIndex("aaa"));
    }

}
