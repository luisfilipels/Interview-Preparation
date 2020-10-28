public class ImplementStrStr {

    // VERY slow solution
    private static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null || haystack.length() < needle.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j;
                for (j = 0; j + i < haystack.length() && j < needle.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(j + i)) {
                        break;
                    }
                }
                if (j == needle.length()) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("", ""));
    }

}
