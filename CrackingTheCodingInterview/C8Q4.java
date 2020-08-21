import java.util.*;

public class C8Q4 {

    // Done using the explicit enumeration technique.
    static ArrayList<Integer> getBinRep (ArrayList<Integer> arr, int rep) {
        ArrayList<Integer> returnArray = new ArrayList<>();
        for (int i = arr.size()-1; i >= 0; i--) {
            if (((rep >> i) & 1) == 1) {
                returnArray.add(arr.get(arr.size() - 1 - i));
            }
        }
        return returnArray;
    }

    static ArrayList<ArrayList<Integer>> powerSet (ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
        for (int i = 0; i < set.size() * set.size(); i++) {
            powerSet.add(getBinRep(set, i));
        }
        return powerSet;
    }

    // Done using a recursive function
    static ArrayList<ArrayList<Integer>> powerSetRecursive (ArrayList<Integer> set) {
        HashSet<ArrayList<Integer>> powerSet = new HashSet<>();
        powerSetRecursiveHelper(set, 0, new ArrayList<>(), powerSet);
        return new ArrayList<>(powerSet);
    }

    static void powerSetRecursiveHelper (ArrayList<Integer> set, int currentIndex, ArrayList<Integer> currentSet, HashSet<ArrayList<Integer>> hash) {
        hash.add(currentSet);
        if (currentIndex >= set.size()) return;
        ArrayList<Integer> newSet = new ArrayList<>(currentSet);
        newSet.add(set.get(currentIndex));
        powerSetRecursiveHelper(set, currentIndex+1, currentSet, hash);
        powerSetRecursiveHelper(set, currentIndex+1, newSet, hash);
    }

    public static void main(String[] args) {
        Integer [] array = {1, 2, 3, 4};
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(array));
        System.out.println(powerSet(arr));
        System.out.println(powerSetRecursive(arr));
    }

}
