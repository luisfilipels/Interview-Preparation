package Extras.InterviewBit;

import java.util.*;

public class Anagrams {

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
        int n = A.size();
        for(int i = 0; i < n; i++)
        {
            char[] arr = A.get(i).toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            if(map.get(str) != null)
            {
                map.get(str).add(i+1);
            }
            else {
                ArrayList<Integer> g = new ArrayList<Integer>();
                g.add(i+1);
                map.put(str, g);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("god");
        list.add("tca");
        System.out.println(anagrams(list));
    }
}
