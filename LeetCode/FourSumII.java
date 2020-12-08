import java.util.Arrays;
import java.util.HashMap;

public class FourSumII {

    // O(n^2) solution
    private static int fourSumCount (int[] A, int[] B, int[] C, int[] D) {
        int count = 0;

        int n = A.length;

        HashMap<Integer, Integer> countsSums = new HashMap<>();

        for (int c : C) {
            for (int d : D) {
                countsSums.put(c + d, countsSums.getOrDefault(c + d, 0) + 1);
            }
        }

        for (int a : A) {
            for (int b : B) {
                int objective = -(a + b);
                count += countsSums.getOrDefault(objective, 0);
            }
        }
        return count;
    }

    // My first solution: O(n^3)
    /*private static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;

        HashMap<Integer, Integer> countsD = new HashMap<>();

        for (int x : D) {
            countsD.put(x, countsD.getOrDefault(x, 0) + 1);
        }

        for (int a : A) {
            for (int b : B) {
                for (int c : C) {
                    int objective = (a + b + c) * -1;
                    count += countsD.getOrDefault(objective, 0);
                }
            }
        }
        return count;
    }*/

    public static void main(String[] args) {
        int [] A = new int[] {1, 2};
        int [] B = new int[] {-2, -1};
        int [] C = new int[] {-1, 2};
        int [] D = new int[] {0, 2};

        System.out.println(fourSumCount(A, B, C, D));
    }

}
