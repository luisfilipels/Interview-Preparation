package Extras.HackerRank;

public class SpecialStringAgain {

    static void expand (String s, int left, int right, long[] count) {
        char charToKeep = s.charAt(left);
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == charToKeep && s.charAt(right) == charToKeep) {
            count[0]++;
            left--;
            right++;
        }
    }

    static long substrCount (int n, String s) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        long [] count = new long[] {0};

        for (int center = 0; center < (n * 2) - 1; center++) {
            if (center == 0 || center == (n*2)-2) {
                count[0]++;
            } else {
                if (center % 2 == 0) { // Center on character
                    count[0]++;
                    int left =  (center/2)-1;
                    int right = (center/2)+1;
                    if (s.charAt(left) == s.charAt(right)) {
                        expand(s, left, right, count);
                    } else {
                        continue;
                    }
                } else {               // Center between characters
                    int left = (center/2);
                    int right = (center/2)+1;
                    if (s.charAt(left) == s.charAt(right)) {
                        expand(s, left, right, count);
                    }
                }
            }
        }

        return count[0];

    }

    public static void main(String[] args) {
        String s = "ab";
        System.out.println(substrCount(s.length(), s));
    }

}
