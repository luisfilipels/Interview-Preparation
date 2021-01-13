import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PairsWithSpecificDifference {

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        if (k == 0) return new int[][] {};

        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        for (int x : arr) {
            map.put(x-k, x);
        }

        for (int x : arr) {
            if (map.containsKey(x)) {
                result.add(new int[] {map.get(x), x});
            }
        }

        int[][] returnArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            returnArray[i][0] = result.get(i)[0];
            returnArray[i][1] = result.get(i)[1];
        }

        return returnArray;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {1,5,11,7};
        System.out.println(Arrays.deepToString(findPairsWithGivenDifference(arr, 6)));
    }

}
