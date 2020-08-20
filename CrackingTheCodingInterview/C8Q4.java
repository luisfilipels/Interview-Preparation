import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

    public static void main(String[] args) {
        Integer [] array = {1, 2, 3, 4};
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(array));
        System.out.println(powerSet(arr));
    }

}
