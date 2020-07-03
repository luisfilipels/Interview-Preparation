package Extras.HackerRank;

import java.util.HashSet;

public class TwoStrings {

    static String twoStrings (String s1, String s2) {
        HashSet<Character> hash = new HashSet<>();
        for (char c : s1.toCharArray()) {
            hash.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (hash.contains(c)) return "YES";
        }
        return "NO";
    }

}
