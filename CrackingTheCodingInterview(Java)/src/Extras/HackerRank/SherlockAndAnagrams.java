package Extras.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {

    static void addOrInclude (String s, HashMap<String, Integer> hash) {
        if (hash.containsKey(s)) {
            int currentValue = hash.get(s);
            hash.replace(s, currentValue + 1);
        } else {
            hash.put(s, 1);
        }
    }

    static int sherlockAndAnagrams (String s) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()) {        // Adding all anagrams of size 1
            String current = "" + c;
            addOrInclude(current, hashMap);
        }
        for (int size = 2; size <= s.length(); size++) { // Analyzing anagrams of size 2..s.size()
            StringBuilder sb = new StringBuilder();
            int front = 0;
            while (front < size) {
                sb.append(s.charAt(front));
                front++;
            }
            //Sorting the first string before inserting
            char[] arr = sb.toString().toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            //Sorting the first string before inserting
            addOrInclude(sorted, hashMap);
            for (; front < s.length(); front++) {
                sb.append(s.charAt(front));
                sb.deleteCharAt(0);
                arr = sb.toString().toCharArray();
                Arrays.sort(arr);
                sorted = new String(arr);
                addOrInclude(sorted, hashMap);
            }
        }
        int finalCount = 0;
        /*
        We included everything we found, even anagrams that didn't have another copy in string s into the hashmap.
        From the editorial:

        Notice that if there are n substrings of s with signature sig, then they can form n(n-1)/2 pairs of substrings
        with signature sig, so we can just iterate over all values in the hashmap and for each value n add n(n-1)/2
        to the final result.

        n(n-1)/2 is equivalente to n choose 2, or n!/2!(n-2)!

        (sig, in this implementation, can be considered as the sorted strings that are inserted into the map)
         */
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            int value = entry.getValue();
            finalCount += (value * (value - 1))/2;
        }
        return finalCount;
    }


    public static void main(String[] args) {
        String s = "kkkk";
        System.out.println(sherlockAndAnagrams(s));
    }
}
