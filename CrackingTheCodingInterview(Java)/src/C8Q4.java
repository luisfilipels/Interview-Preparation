import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// Pode ser feito com enumeração explicita, obviamente. Mas como?

// Fiz com enumeração explícita, mas tendo que ordenar para cada elemento adicionado :P

public class C8Q4 {

    static int [][] dp;

    static ArrayList<Integer> getBinRep (ArrayList<Integer> arr, int rep) {
        int current = rep;
        ArrayList<Integer> returnArray = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (((current >> i) & 1) == 1) {
                returnArray.add(arr.get(arr.size() - 1 - i));
            }
        }
        Collections.sort(returnArray);
        return returnArray;
    }

    static ArrayList<ArrayList<Integer>> powerSet (ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
        for (int i = 0; i < set.size() * set.size(); i++) {
            powerSet.add(getBinRep(set, i));
        }
        Collections.sort(powerSet, Comparator.comparingInt(ArrayList::size));
        return powerSet;
    }

    public static void main(String[] args) {
        Integer [] array = {1, 2, 3, 4};
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(array));
        System.out.println(powerSet(arr));
    }

}
