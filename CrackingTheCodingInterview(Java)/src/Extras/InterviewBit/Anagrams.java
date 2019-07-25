package Extras.InterviewBit;

import java.util.*;

public class Anagrams {

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashMap<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
        int n = A.size();
        ArrayList<Integer> list = new ArrayList<Integer>();
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

        for(ArrayList<Integer> l: map.values())
        {
            result.add(l);
        }
        return result;
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
