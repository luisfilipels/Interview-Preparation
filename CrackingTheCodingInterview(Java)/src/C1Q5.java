public class C1Q5 {

    static boolean oneAway (String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        String max = s1.length() > s2.length() ? s1 : s2;
        String min = s1.length() <= s2.length() ? s1 : s2;

        if (max.length() - min.length() > 1) return false;

        boolean foundDifferent = false;

        int i = 0, j = 0;

        while (i < max.length() && j < min.length()) {
            if (min.charAt(j) != max.charAt(i)) {
                if (!foundDifferent) {
                    foundDifferent = true;
                    if (max.length() != min.length()) {
                        j--;
                    }
                }
                else return false;
            }
            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneAway("pale", "pal"));
    }
}
