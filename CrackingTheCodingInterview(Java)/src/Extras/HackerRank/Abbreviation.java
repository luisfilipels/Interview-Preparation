package Extras.HackerRank;

import java.util.HashMap;

public class Abbreviation {

    // Best solution I could come up with :/
    // Exceeds time limit
    static String abbreviation(String a, String b) {
        if (b.length() > a.length()) {
            return "NO";
        }
        StringBuilder A = new StringBuilder(a);
        StringBuilder B = new StringBuilder(b);
        HashMap<String, Boolean> hash = new HashMap<>();
        return helper(A, B, 0, hash) ? "YES" : "NO";
    }

    static boolean helper (StringBuilder a, StringBuilder b, int i, HashMap<String, Boolean> hash) {
        String aString = a.toString();
        String bString = b.toString();
        if (hash.containsKey(aString)) {
            return hash.get(aString);
        }
        if (i == a.length()) {
            if (aString.equals(bString)) {
                hash.put(aString, true);
                return true;
            }
            hash.put(aString, false);
            return false;
        }
        if (Character.isLowerCase(a.charAt(i))) {
            StringBuilder remove = new StringBuilder(a);
            remove.deleteCharAt(i);
            char upper = Character.toUpperCase(a.charAt(i));
            StringBuilder upperCase = new StringBuilder(a);
            upperCase.deleteCharAt(i);
            upperCase.insert(i, upper);
            boolean tryRemove = helper(remove, b, i, hash);
            boolean tryUpper = helper(upperCase, b, i+1, hash);
            hash.put(a.toString(), tryUpper || tryRemove);
            return hash.get(a.toString());
        } else {
            hash.put(aString, helper(a, b, i+1, hash));
            return hash.get(aString);
        }
    }



    public static void main(String[] args) {
        System.out.println(abbreviation("AbcDE", "ABDE"));
        System.out.println(abbreviation("daBcd", "ABC"));
        System.out.println(abbreviation("AbcDE", "AFDE"));
    }

}
