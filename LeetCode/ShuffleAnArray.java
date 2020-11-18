import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class ShuffleAnArray {

    static class Solution {

        int[] original;
        HashMap<Integer, Integer> idxToVal = new HashMap<>();

        public Solution(int[] nums) {
            original = nums;
        }

        public int[] reset() {
            return original;
        }

        public int[] shuffle() {
            int n = original.length;
            for (int i = 0; i < n; i++) {
                idxToVal.put(i, original[i]);
            }
            int [] returnArray = new int[n];
            Random random = new Random();
            int i = 0;
            while (!idxToVal.isEmpty()) {
                int m = idxToVal.size();
                int chosenIdx = random.nextInt(m);
                returnArray[i++] = idxToVal.get(chosenIdx);
                idxToVal.put(chosenIdx, idxToVal.get(idxToVal.size() - 1));
                idxToVal.remove(idxToVal.size()-1);
            }
            return returnArray;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[] {
                10, 20, 30, 40, 50, 60
        };
        Solution s = new Solution(test);

        for (int i = 0; i < 20; i++) {
            System.out.println(Arrays.toString(s.shuffle()));
        }
    }

}
