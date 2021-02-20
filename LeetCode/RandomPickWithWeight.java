import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight {

    /*
    // Uses too much space and isn't accepted
    ArrayList<Integer> list = new ArrayList<>();

    public Solution(int[] w) {
        for (int j = 0; j < w.length; j++) {
            int x = w[j];
            for (int i = 0; i < x; i++) {
                list.add(j);
            }
        }
    }

    public int pickIndex() {
        int rnd = new Random().nextInt(list.size());
        return list.get(rnd);
    }*/

    // Passes, but is slow
    static class Solution {
        int[] arr;
        int sum = 0;

        public Solution(int[] w) {
            arr = w;
            for (int x : arr) this.sum += x;
        }

        public int pickIndex() {
            int rnd = new Random().nextInt(sum);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > rnd) return i;
                rnd -= arr[i];
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution(new int[] {3, 14, 1, 7});

        for (int i = 0; i < 10; i++) {
            System.out.println(s.pickIndex());
        }
    }

}
