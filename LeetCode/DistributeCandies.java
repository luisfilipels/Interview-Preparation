import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DistributeCandies {

    // Brute force, 100ms solution.
    /*public static int distributeCandies (int [] candies) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        int n = candies.length;

        for (int i : candies) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }

        int countCandies = 0;
        HashSet<Integer> candiesSelected = new HashSet<>();
        while (countCandies < n/2) {
            for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
                if (entry.getValue() != 0) {
                    candiesSelected.add(entry.getKey());
                    countCandies++;
                    entry.setValue(entry.getValue()-1);
                }
                if (countCandies >= n/2) break;
            }
        }

        return candiesSelected.size();
    }*/

    // Smarter solution. Still takes 50ms
    /*public static int distributeCandies (int [] candies) {
        HashSet<Integer> hash = new HashSet<>();

        int n = candies.length;

        for (int i : candies) {
            hash.add(i);
        }

        return Math.min(n / 2, hash.size());
    }*/

    // Optimal solution. Faster than 97.71% of other submissions.
    public static int distributeCandies (int [] candies) {
        HashSet<Integer> hash = new HashSet<>();

        int n = candies.length;

        for (int i : candies) {
            hash.add(i);
            if (hash.size() > n/2) return hash.size() - 1;
        }

        return hash.size();
    }

    public static void main(String[] args) {
        int [] arr = new int[] {1, 1, 1, 2, 3, 3, 4, 5};
        System.out.println(distributeCandies(arr));
    }

}
