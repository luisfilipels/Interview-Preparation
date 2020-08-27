import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class C8Q7 {

    static void helper (StringBuilder currentString, HashSet<Character> remainingChars, ArrayList<String> returnList) {
        if (remainingChars.isEmpty()) {
            returnList.add(currentString.toString());
        }
        for (char c : remainingChars) {
            HashSet<Character> newHash = new HashSet<>(remainingChars);
            newHash.remove(c);
            helper(new StringBuilder(currentString).append(c), newHash, returnList);
        }
    }

    static ArrayList<String> permutations (String s) {
        ArrayList<String> returnList = new ArrayList<>();
        HashSet<Character> hash = new HashSet<>();
        char [] arr = s.toCharArray();
        for (char c : arr) {
            hash.add(c);
        }
        helper(new StringBuilder(), hash, returnList);
        return returnList;
    }

    public static void main(String[] args) {
        String s = "abcdefghij";
        System.out.println(permutations(s).size());
    }

}
