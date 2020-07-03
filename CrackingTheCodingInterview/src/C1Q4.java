public class C1Q4 {

    static boolean checkIsPalindromePermutation (String s) {
        int [] count = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {   // Supposing spaces do not count
                count[s.charAt(i)]++;
            }
        }

        boolean foundOdd = false;

        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0) {
                if (foundOdd) return false;
                else foundOdd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "\\abbc\\acccii\\";
        System.out.println(checkIsPalindromePermutation(s));
    }
}
