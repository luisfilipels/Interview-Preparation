import java.util.ArrayList;

public class MaxMin {

    public int solve(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x : A) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        return min + max;
    }

}
