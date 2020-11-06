import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class InsertDeleteGetRandom {

    static class RandomizedSet {

        HashMap<Integer, Integer> valueToIdx = new HashMap<>(); // From value to index
        ArrayList<Integer> arr = new ArrayList<>();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (!valueToIdx.containsKey(val)) {
                arr.add(val);
                valueToIdx.put(val, arr.size()-1);
                return true;
            }
            return false;
        }

        void swap(int x, int y) {
            int temp = arr.get(x);
            arr.set(x, arr.get(y));
            arr.set(y, temp);
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (valueToIdx.containsKey(val)) {
                int idx = valueToIdx.get(val);
                swap(idx, arr.size()-1);
                int valAtEnd = arr.get(idx);
                valueToIdx.put(valAtEnd, idx);
                arr.remove(arr.size()-1);
                valueToIdx.remove(val);
                return true;
            }
            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return arr.get((int)(Math.random() * (arr.size())));
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.size(); i++) {
                sb.append(arr.get(i)).append(" ");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();

        /*System.out.println(set.remove(0));
        System.out.println(set.remove(0));
        System.out.println(set.insert(0));
        System.out.println(set.getRandom());
        System.out.println(set.remove(0));
        System.out.println(set.insert(0));*/
        set.insert(1);
        set.insert(2);
        set.insert(3);
        set.insert(4);
        System.out.println(set.toString());

        set.remove(2);
        set.remove(1);
        set.remove(4);
        set.insert(5);
        set.insert(1);
        System.out.println(set.toString());

        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
    }

}
