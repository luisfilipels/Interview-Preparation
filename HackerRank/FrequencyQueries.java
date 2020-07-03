package Extras.HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyQueries {

    static HashMap<Integer, Integer> hash = new HashMap<>();

    static HashMap<Integer, Integer> frequencyPresent = new HashMap<>();

    static void add (int x) {
        if (hash.containsKey(x)) {
            int lastFrequency = hash.get(x);
            frequencyPresent.put(lastFrequency, frequencyPresent.getOrDefault(lastFrequency, 0) - 1);
        }
        hash.put(x, hash.getOrDefault(x, 0) + 1);
        int currentFrequency = hash.get(x);
        frequencyPresent.put(currentFrequency, frequencyPresent.getOrDefault(currentFrequency, 0) + 1);
    }

    static void remove (int y) {
        if (hash.containsKey(y) && hash.get(y) > 0) {
            if (hash.containsKey(y)) {
                int lastFrequency = hash.get(y);
                frequencyPresent.put(lastFrequency, frequencyPresent.getOrDefault(lastFrequency, 0) - 1);
            }
            hash.put(y, hash.getOrDefault(y, 0) - 1);
            int currentFrequency = hash.get(y);
            frequencyPresent.put(currentFrequency, frequencyPresent.getOrDefault(currentFrequency, 0) + 1);
        }
    }

    static boolean checkFrequency (int z) {
        if (frequencyPresent.containsKey(z) && frequencyPresent.get(z) >= 1) {
            return true;
        }
        return false;
    }

    static List<Integer> freqQuery (List<List<Integer>> queries) {
        List<Integer> returnList = new ArrayList<>();

        for (List<Integer> query : queries) {
            int operation = query.get(0);
            int number = query.get(1);
            switch (operation) {
                case 1:
                    add(number);
                    break;
                case 2:
                    remove(number);
                    break;
                case 3:
                    if (checkFrequency(number)) {
                        returnList.add(1);
                    } else {
                        returnList.add(0);
                    }
                    break;
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
        /*int [][] queriesArray = new int[][] {
                {1, 1},
                {2, 2},
                {3, 2},
                {1, 1},
                {1, 1},
                {2, 1},
                {3, 2}
        };*/

        int [][] queriesArray = new int[][] {
                {1, 3},
                {2, 3},
                {3, 2},
                {1, 4},
                {1, 5},
                {1, 5},
                {1, 4},
                {3, 2},
                {2, 4},
                {3, 2}
        };

        List<List<Integer>> list = new ArrayList<>();
        for (int [] query : queriesArray) {
            list.add(new ArrayList<>());
            list.get(list.size()-1).add(query[0]);
            list.get(list.size()-1).add(query[1]);
        }
        System.out.println(freqQuery(list));
    }

}
