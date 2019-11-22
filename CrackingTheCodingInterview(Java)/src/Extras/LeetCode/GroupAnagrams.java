package Extras.LeetCode;

import java.util.*;

public class GroupAnagrams {

    // Minha solução 1, muitíssima ineficiente.
    static List<List<String>> groupAnagrams (String [] strs) {
        List<List<String>> returnList = new ArrayList<>();
        HashMap<HashMap, ArrayList<String>> hashMapHashSet = new HashMap<>();
        for (String s : strs) {
            HashMap<Character, Integer> currentHash = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (!currentHash.containsKey(c)) {
                    currentHash.put(c, 0);
                } else {
                    int currentValue = currentHash.get(c);
                    currentHash.replace(c, currentValue+1);
                }
            }
            if (!hashMapHashSet.containsKey(currentHash)) {
                hashMapHashSet.put(currentHash, new ArrayList<>());
            }
            hashMapHashSet.get(currentHash).add(s);
        }
        for (Map.Entry<HashMap, ArrayList<String>> entry : hashMapHashSet.entrySet()) {
            returnList.add(new ArrayList<>());
            ArrayList<String> currentArray = entry.getValue();
            for (String s : currentArray) {
                returnList.get(returnList.size()-1).add(s);
            }
        }
        return returnList;
    }

    // Minha solução 2, ligeiramente melhor.
    /*static List<List<String>> groupAnagrams (String [] strs) {
        HashMap<String, ArrayList<String>> hashMapHashSet = new HashMap<>();
        for (String s : strs) {
            int [] currentCount = new int[26];
            for (Character c : s.toCharArray()) {
                currentCount[c - 'a']++;
            }
            StringBuilder str = new StringBuilder();
            for (int i : currentCount) {
                str.append("#").append(i);
            }
            String st = str.toString();
            if (!hashMapHashSet.containsKey(st)) {
                hashMapHashSet.put(st, new ArrayList<>());
            }
            hashMapHashSet.get(st).add(s);
        }
        return new ArrayList<>(hashMapHashSet.values());
    }*/

    // Solução de outra pessoa, muito melhor.
    /*
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
     */

    public static void main(String[] args) {
        String [] input = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input));
    }

}
