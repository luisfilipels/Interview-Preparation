package Extras.HackerRank;

import java.util.HashMap;

public class Abbreviation {


    // My second solution. Improves upon the first and passes.

    // This variable (for this implementation) is ESSENTIAL. Once we find a moment in which we can return true, we no longer
    // need to do any more recursive calls.
    static boolean possible = false;

    static String abbreviation (String a, String b) {
        possible = false;   // Needs to be set to false manually, as HackerRank will use multiple test cases in one go.
        if (b.length() > a.length()) {
            return "NO";
        }
        StringBuilder A = new StringBuilder(a);
        StringBuilder B = new StringBuilder(b);
        HashMap<String, Boolean> hash = new HashMap<>();
        hash.put(" ", true);
        return helper(A, B, hash) ? "YES" : "NO";
    }

    static boolean helper (StringBuilder a, StringBuilder b, HashMap<String, Boolean> hash) {

        if (possible) return true;  // If we found a solution, stop.

        // If a.length() is less than b.length(), and the only operations we are allowed to do are capitalizing characters
        // and removing them, it's impossible for us to reach a "TRUE" solution.
        if (a.length() < b.length()) return false;

        // Base case: both strings are empty.
        if (a.length() == b.length() && a.toString().equals(b.toString())) {
            possible = true;
            return true;
        } else if (b.length() == 0) {
            if (a.toString().toLowerCase().equals(a.toString())) {
                // If b.length() is 0 and all chars in are lower case, we can simply remove all of them.
                possible = true;
                return true;
            }
            // If they are not lowercase (there is at least one character that is in the upper case) and b == "", then
            // we can't remove all characters, so return false.
            else return false;
        }

        // We'll combine both strings into one so we can use DP with both string A and string B as variable parameters.
        String current = a.toString() + " " + b.toString();
        if (hash.containsKey(current)) return hash.get(current);

        int n = a.length();
        int m = b.length();

        char lastCharA = a.charAt(n-1);
        char lastCharB = b.charAt(m-1);

        if (Character.isUpperCase(lastCharA)) {
            if (lastCharA != lastCharB) {
                // If both last chars are in the upper case, but they are different, it's impossible to reach a true solution.
                hash.put(current, false);
                return false;
            } else {
                // If not (both chars are equal), then the solution for a = ...<char>, b = ...<char> is the same solution as
                // a = ..., b = ...
                StringBuilder newA = new StringBuilder(a);
                StringBuilder newB = new StringBuilder(b);
                newA.deleteCharAt(n-1);
                newB.deleteCharAt(m-1);
                boolean removeFromBoth = helper(newA, newB, hash);
                hash.put(current, removeFromBoth);
                return hash.get(current);
            }
        } else {
            if (Character.toUpperCase(lastCharA) == lastCharB) {
                // If lastCharA is lowercase, but can become equal to lastCharB by capitalizing it, then we must try:
                // 1 - Capitalizing the last char of a
                // 2 - Removing the last char of a
                StringBuilder toUpper = new StringBuilder(a);
                toUpper.deleteCharAt(n-1);
                toUpper.append(Character.toUpperCase(lastCharA));
                boolean convertToUpper = helper(toUpper, b, hash);
                StringBuilder remove = new StringBuilder(a);
                remove.deleteCharAt(n-1);
                boolean removeFromA = helper(remove, b, hash);
                hash.put(current, convertToUpper || removeFromA || possible);
                return hash.get(current);
            } else {
                // Else, remove this char.
                StringBuilder remove = new StringBuilder(a);
                remove.deleteCharAt(n-1);
                boolean removeFromA = helper(remove, b, hash);
                hash.put(current, removeFromA);
                return hash.get(current);
            }
        }
    }

    // My first solution. Exceeds time limit.
    /*static String abbreviation(String a, String b) {
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
    }*/



    public static void main(String[] args) {
        System.out.println(abbreviation("AbcDE", "ABDE"));
        System.out.println(abbreviation("daBcd", "ABC"));
        System.out.println(abbreviation("AbcDE", "AFDE"));
    }

}
