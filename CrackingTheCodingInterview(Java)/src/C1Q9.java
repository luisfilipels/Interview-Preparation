public class C1Q9 {

    static boolean isRotation (String s1, String s2) {
        if (s1.length() == s2.length()) {
            String newS1 = s1 + s1;

            return isSubstring(newS1, s2);
        }
        return false;
    }

    static private boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        String s2 = "waterbottle";
        String s1 = "erbottlewat";

        System.out.println(isRotation(s1, s2));
    }

}
