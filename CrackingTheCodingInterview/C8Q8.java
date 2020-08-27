import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class C8Q8 {

    static void helper (StringBuilder currentString, HashMap<Character, Integer> remainingChars, ArrayList<String> returnList) {
        if (remainingChars.isEmpty()) {
            returnList.add(currentString.toString());
        }
        for (Map.Entry<Character, Integer> entry : remainingChars.entrySet()) {
            char current = entry.getKey();
            int count = entry.getValue() - 1;
            HashMap<Character, Integer> newHash = new HashMap<>(remainingChars);
            if (count > 0) {
                newHash.put(current, count);
            } else {
                newHash.remove(current);
            }
            helper(new StringBuilder(currentString).append(current), newHash, returnList);
        }
    }

    static ArrayList<String> permutationsWithDups (String s) {
        ArrayList<String> returnList = new ArrayList<>();
        HashMap<Character, Integer> hash = new HashMap<>();
        char [] arr = s.toCharArray();
        for (char c : arr) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        helper(new StringBuilder(), hash, returnList);
        return returnList;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaa";
        ArrayList<String> result = permutationsWithDups(s);
        System.out.println(result.size());
        System.out.println(result);
    }

}
